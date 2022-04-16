package com.example.anabi.finalyearproject1try.FireBaseBackend.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.anabi.finalyearproject1try.FireBaseBackend.CommonFunction;
import com.example.anabi.finalyearproject1try.FireBaseBackend.activity.CommentActivity;
import com.example.anabi.finalyearproject1try.FireBaseBackend.activity.DetailsActivity;
import com.example.anabi.finalyearproject1try.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class LaptopPhoneFragment extends Fragment {


    RecyclerView phoneRecycler;

    private FirestoreRecyclerAdapter<PostModel, ProductViewHolder> adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_phone, null);

        phoneRecycler = view.findViewById(R.id.phone_recycler_view);
        phoneRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
        Query query = rootRef.collection("Laptop")
                .orderBy("productName", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<PostModel> options = new FirestoreRecyclerOptions.Builder<PostModel>()
                .setQuery(query, PostModel.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<PostModel, ProductViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final ProductViewHolder holder, int position, @NonNull final PostModel model) {
                holder.name.setText(model.getProductName());
                holder.category.setText(model.getSelectedProductCategory());
                holder.price.setText(model.getProductPrice());
                try {
                    long millisecond = model.getTimeStamp().getTime();
                    String dateString = DateFormat.format("MM/dd/yyyy", new Date(millisecond)).toString();
                    holder.timestamp.setText(dateString);
                } catch (Exception e) {

                    Toast.makeText(holder.timestamp.getContext(), "Exception : " + e.getMessage(), Toast.LENGTH_SHORT).show();

                }

                Glide.with(holder.feedImage.getContext())
                        .load(model.getProductImage()
                        ).into(holder.feedImage);

                final CommonFunction commonFunction = new CommonFunction();
                holder.mainClick.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        commonFunction.OpenOption(model, model.getUserID(), model.getProductId(), "Smart Phone", holder.mainClick);
                        return false;
                    }
                });
                holder.mainClick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(holder.mainClick.getContext(), DetailsActivity.class);
                        intent.putExtra("postModel",model);
                        startActivity(intent);
                    }
                });

                holder.commentClick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(holder.commentClick.getContext(), CommentActivity.class);
                        intent.putExtra("postModel",model);
                        startActivity(intent);
                    }
                });
            }


            @NonNull
            @Override
            public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_recycler_item, parent, false);
                return new ProductViewHolder(view);
            }
        };
        phoneRecycler.setAdapter(adapter);
        return view;
    }


    private class ProductViewHolder extends RecyclerView.ViewHolder {
        private View view;

        TextView name, category, timestamp, price;
        ImageView feedImage;
        CardView mainClick,commentClick;

        ProductViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.feed_recyclerName);
            category = itemView.findViewById(R.id.feed_recyclerCategory);
            timestamp = itemView.findViewById(R.id.feed_recyclerTimeStamp);
            price = itemView.findViewById(R.id.feed_recyclerPrice);
            feedImage = itemView.findViewById(R.id.feed_recyclerImage);
            mainClick = itemView.findViewById(R.id.mainClick);
            commentClick = itemView.findViewById(R.id.commentClick);
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
