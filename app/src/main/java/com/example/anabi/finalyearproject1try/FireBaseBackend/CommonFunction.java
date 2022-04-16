package com.example.anabi.finalyearproject1try.FireBaseBackend;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.anabi.finalyearproject1try.FireBaseBackend.activity.UpdateActivity;
import com.example.anabi.finalyearproject1try.FireBaseBackend.fragment.PostModel;
import com.example.anabi.finalyearproject1try.FireBaseBackend.model.CommentModel;
import com.example.anabi.finalyearproject1try.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class CommonFunction {


    FirebaseAuth mAuth;
    FirebaseFirestore firebaseFirestore;

    public void OpenOption(PostModel postModel, String model, String productId, String collection, final CardView view) {

        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        PopupMenu popup = new PopupMenu(view.getContext(), view);
        MenuInflater inflater = popup.getMenuInflater();

        if (mAuth.getCurrentUser().getEmail().equals("greatadib82@gmail.com")) {
            inflater.inflate(R.menu.admin_menu_option, popup.getMenu());
        } else if (model.equals(mAuth.getCurrentUser().getUid())) {
            inflater.inflate(R.menu.admin_menu_option, popup.getMenu());
        } else {
            inflater.inflate(R.menu.common_menu_option, popup.getMenu());
        }

        popup.setOnMenuItemClickListener(new MyMenuItemClickListener(postModel, null, collection, productId, view.getContext()));
        popup.show();


    }

    public void commentOption(CommentModel model, String collection, CardView view) {
        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        PopupMenu popup = new PopupMenu(view.getContext(), view);
        MenuInflater inflater = popup.getMenuInflater();

        if (mAuth.getCurrentUser().getEmail().equals("greatadib82@gmail.com")) {
            inflater.inflate(R.menu.comment_option, popup.getMenu());
        } else if (model.getUserUID().equals(mAuth.getCurrentUser().getUid())) {
            inflater.inflate(R.menu.comment_option, popup.getMenu());
        } else {
            inflater.inflate(R.menu.blank, popup.getMenu());
        }

        popup.setOnMenuItemClickListener(new MyMenuItemClickListener(null,model,collection, model.getCommentID(), view.getContext()));
        popup.show();
    }

    private class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        String productID, collection;
        Context context;
        PostModel postModel;
        CommentModel model;

        public MyMenuItemClickListener(PostModel postModel, CommentModel model, String collection, String productId, Context context) {
            this.productID = productId;
            this.context = context;
            this.collection = collection;
            this.postModel = postModel;
            this.model = model;
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.edit_post:
                    Intent intent = new Intent(context, UpdateActivity.class);
                    intent.putExtra("model", postModel);
                    intent.putExtra("collection",collection);
                    context.startActivity(intent);
                    return true;
                case R.id.delete_post:
                    firebaseFirestore
                            .collection(collection)
                            .document(productID)
                            .delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(context, "The post is deleted", Toast.LENGTH_SHORT).show();
                        }
                    });
                    return true;
                case R.id.share_post:
                    //new

                    Intent myIntent = new Intent(Intent.ACTION_SEND);
                    myIntent.setType("text/plain");
                    String shareBody = "Your body is here"+firebaseFirestore
                                                                .collection(collection);

                    String shareSub = "Blog Post";
                    myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                    myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                    context.startActivity(Intent.createChooser(myIntent, "Share using"));

                    // new end
                    Toast.makeText(context, "This is share button", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }
    }

}
