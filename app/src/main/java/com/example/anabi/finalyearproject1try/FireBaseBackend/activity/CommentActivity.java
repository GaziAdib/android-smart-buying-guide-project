package com.example.anabi.finalyearproject1try.FireBaseBackend.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.anabi.finalyearproject1try.FireBaseBackend.CommonFunction;
import com.example.anabi.finalyearproject1try.FireBaseBackend.fragment.PostModel;
import com.example.anabi.finalyearproject1try.FireBaseBackend.model.CommentModel;
import com.example.anabi.finalyearproject1try.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CommentActivity extends AppCompatActivity {

    PostModel postModel;

    EditText commentBoxFiled;

    FirebaseAuth mAuth;
    FirebaseFirestore firebaseFirestore;

    RecyclerView phoneRecycler;

    private FirestoreRecyclerAdapter<CommentModel, ProductViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        postModel = (PostModel) getIntent().getSerializableExtra("postModel");

        commentBoxFiled = findViewById(R.id.commentBox);

        phoneRecycler = findViewById(R.id.commentList);
        phoneRecycler.setLayoutManager(new LinearLayoutManager(this));
        FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
        Query query = rootRef.collection(postModel.getSelectedProductCategory()+"/"+postModel.getProductId()+"/Comments")
                .orderBy("comment", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<CommentModel> options = new FirestoreRecyclerOptions.Builder<CommentModel>()
                .setQuery(query, CommentModel.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<CommentModel, ProductViewHolder>(options) {

            @NonNull
            @Override
            public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.comment_item, viewGroup, false);
                return new ProductViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull final ProductViewHolder holder, int position, @NonNull final CommentModel model) {

                holder.username.setText(model.getUserName());
                holder.commentValue.setText(model.getComment());
                Glide.with(holder.userImage.getContext())
                        .load(model.getUserImage()
                        ).into(holder.userImage);

                holder.mainClick.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        final CommonFunction commonFunction = new CommonFunction();
                        String collection = postModel.getSelectedProductCategory()+"/"+postModel.getProductId()+"/Comments";
                        commonFunction.commentOption(model, collection, holder.mainClick);

                        return false;
                    }
                });
            }
        };
        phoneRecycler.setAdapter(adapter);


    }

    public void sendMsg(View view) {
        final String comment = commentBoxFiled.getText().toString();


        if (!TextUtils.isEmpty(comment)) {
            commentBoxFiled.setText("");
            firebaseFirestore.collection("Users").document(mAuth.getCurrentUser().getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        String username = task.getResult().getString("userName");
                        String userImage = task.getResult().getString("userImage");

                        String random = UUID.randomUUID().toString();

                        final Map<String, Object> commentBox = new HashMap<>();
                        commentBox.put("comment", comment);
                        commentBox.put("userName", username);
                        commentBox.put("userUID", mAuth.getCurrentUser().getUid());
                        commentBox.put("userImage", userImage);
                        commentBox.put("commentID", random);

                        firebaseFirestore.collection(postModel.getSelectedProductCategory()+"/" + postModel.getProductId() + "/Comments")
                                .document(random).set(commentBox).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(CommentActivity.this, "Comment Added", Toast.LENGTH_SHORT).show();
                                    commentBoxFiled.setText("");

                                } else {
                                    Toast.makeText(CommentActivity.this, "Something Went wrong", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                    } else {
                        Toast.makeText(CommentActivity.this, "Something Went wrong", Toast.LENGTH_SHORT).show();

                    }
                }
            });


        } else {
            Toast.makeText(this, "Please add some comment first", Toast.LENGTH_SHORT).show();
        }
    }


    private class ProductViewHolder extends RecyclerView.ViewHolder {

        private View view;

        TextView username, commentValue;
        ImageView userImage;

        CardView mainClick;


        ProductViewHolder(View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.userImage);
            username = itemView.findViewById(R.id.userName);
            commentValue = itemView.findViewById(R.id.commentValue);
            mainClick = itemView.findViewById(R.id.mainClick);
        }


    }


    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();

        if (adapter != null) {
            adapter.stopListening();
        }
    }
}
