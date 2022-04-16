package com.example.anabi.finalyearproject1try.FireBaseBackend.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.anabi.finalyearproject1try.FireBaseBackend.fragment.PostModel;
import com.example.anabi.finalyearproject1try.R;

public class DetailsActivity extends AppCompatActivity {

    PostModel postModel;

    TextView productID,productName,productCategory,productDescription,postedBy,detailsProductRecommendation;
    ImageView productImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_details);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        postModel = (PostModel) getIntent().getSerializableExtra("postModel");

        productID = findViewById(R.id.detail_product_ID);
        productName = findViewById(R.id.details_product_name);
        productCategory = findViewById(R.id.detail_product_category);
        productDescription = findViewById(R.id.details_product_description);
        postedBy = findViewById(R.id.details_posted_by);
        productImage = findViewById(R.id.detail_productImage);
        detailsProductRecommendation = findViewById(R.id.details_product_recommendation);

        productID.setText("[Product ID] : \t"+postModel.getProductId());
        productName.setText("[Name] : \t"+postModel.getProductName());
        productCategory.setText("[Category] : \t"+postModel.getSelectedProductCategory());
        productDescription.setText("[Description] : \n\n"+postModel.getProductDescription());
        postedBy.setText("Posted By: \t"+postModel.getPostUserEmail());
        detailsProductRecommendation.setText("[Recommendation] : \n\n "+postModel.getSelectedProductComponent()); // it is recommmendation actually

        Glide.with(this)
                .load(postModel.getProductImage()
                ).into(productImage);

    }

    public void openCommentActivity(View view) {
        Intent intent = new Intent(this, CommentActivity.class);
        intent.putExtra("postModel",postModel);
        startActivity(intent);
    }
}
