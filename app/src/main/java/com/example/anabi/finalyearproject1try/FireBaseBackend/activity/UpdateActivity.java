package com.example.anabi.finalyearproject1try.FireBaseBackend.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.anabi.finalyearproject1try.FireBaseBackend.fragment.PostModel;
import com.example.anabi.finalyearproject1try.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import id.zelory.compressor.Compressor;

public class UpdateActivity extends AppCompatActivity {

    private EditText productIDEdt, productNameEdt, productDescriptionEdt, productPriceEdt;
    private Button submitPostBtn;
    private ImageView postImageView;
    private TextView postSpinnerAddCategory;

    private Uri imageUri = null;

    PostModel postModel;

    private StorageReference storageReference;
    private Bitmap compressed;
    private String user_id;
    private FirebaseFirestore mfireStore;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        postModel = (PostModel) getIntent().getSerializableExtra("model");

        progressDialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
        user_id = mAuth.getCurrentUser().getUid();
        mfireStore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        postImageView = findViewById(R.id.postImage);
        productIDEdt = findViewById(R.id.postProductID);
        productNameEdt = findViewById(R.id.postName);
        productDescriptionEdt = findViewById(R.id.postAddDescription);
        productPriceEdt = findViewById(R.id.postAddPrice);
        submitPostBtn = findViewById(R.id.postSubmitBtn);
        postSpinnerAddCategory = findViewById(R.id.postSpinnerAddCategory);

        Glide.with(this)
                .load(postModel.getProductImage()
                ).into(postImageView);
        productIDEdt.setText(postModel.getProductId());
        productIDEdt.setEnabled(false);
        productNameEdt.setText(postModel.getProductName());
        productDescriptionEdt.setText(postModel.getProductDescription());
        productPriceEdt.setText(postModel.getProductPrice());

        postSpinnerAddCategory.setText(getIntent().getStringExtra("collection"));
        postSpinnerAddCategory.setEnabled(false);


        postImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                    if (ContextCompat.checkSelfPermission(UpdateActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) !=
                            PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(UpdateActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);

                    } else {

                        chooseImage();

                    }

                } else {

                    chooseImage();

                }
            }
        });

        submitPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String productId = postModel.getProductId();
                final String productName = productNameEdt.getText().toString();
                final String productDescription = productDescriptionEdt.getText().toString();
                final String productPrice = productPriceEdt.getText().toString();
                final String selectedProductCategory = getIntent().getStringExtra("collection");



                if (!TextUtils.isEmpty(productId) && !TextUtils.isEmpty(productName) && !TextUtils.isEmpty(productDescription) && !TextUtils.isEmpty(productPrice) && !TextUtils.isEmpty(selectedProductCategory)) {
                    progressDialog.setMessage("Storing Data.....");
                    progressDialog.show();
                    Log.d("checking", "Data not Present");

                    if(imageUri!=null){
                        File newFile = new File(imageUri.getPath());
                        try {
                            compressed = new Compressor(UpdateActivity.this)
                                    .setMaxHeight(125)
                                    .setMaxWidth(125)
                                    .setQuality(80)
                                    .compressToBitmap(newFile);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        compressed.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

                        String randomName = UUID.randomUUID().toString();
                        byte[] thumbData = byteArrayOutputStream.toByteArray();
                        UploadTask image_path = storageReference.child("product_Image").child(randomName + ".jpg").putBytes(thumbData);
                        image_path.addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                                if (task.isSuccessful()) {
                                    updateData(task, productId, productName, productDescription, productPrice, selectedProductCategory);
                                } else {


                                    String error = task.getException().getMessage();


                                    Toast.makeText(UpdateActivity.this, "(IMAGE Error) : " + error, Toast.LENGTH_LONG).show();


                                    progressDialog.dismiss();


                                }
                            }
                        });
                    }else {
                        updateData(null, productId, productName, productDescription, productPrice, selectedProductCategory);
                    }


                }else {
                    Toast.makeText(UpdateActivity.this, "Please mention all details!", Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }
            }
        });

    }

    private void updateData(Task<UploadTask.TaskSnapshot> task, String productId, String productName, String productDescription, String productPrice, String selectedProductCategory) {
        Uri downloadURI;
        if (task != null) {
            downloadURI = task.getResult().getDownloadUrl();
        } else if(imageUri==null) {
            downloadURI = Uri.parse(postModel.getProductImage());
        }else {
            downloadURI = imageUri;
        }
        Map<String, Object> productData = new HashMap<>();
        productData.put("productId", productId);
        productData.put("productName", productName);
        productData.put("productImage", downloadURI.toString());
        productData.put("productDescription", productDescription);
        productData.put("productPrice", productPrice);
        productData.put("selectedProductCategory", selectedProductCategory);
        productData.put("timeStamp", FieldValue.serverTimestamp());
        productData.put("userID", mAuth.getCurrentUser().getUid());

        mfireStore.collection(selectedProductCategory).document(productId).set(productData)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            progressDialog.dismiss();
                            Toast.makeText(UpdateActivity.this, "Post Submitted Successfully", Toast.LENGTH_SHORT).show();
                            //setFeedDetails(selectedProductCategory, productId);
                        } else {
                            String error = task.getException().getMessage();
                            Toast.makeText(UpdateActivity.this, "(FIRESTORE Error) : " + error, Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                        UpdateActivity.this.finish();
                    }
                });
    }

    private void chooseImage() {
        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .setAspectRatio(2, 1)
                .start(UpdateActivity.this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {

                imageUri = result.getUri();
                postImageView.setImageURI(imageUri);


            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {

                Exception error = result.getError();

            }
        }

    }
}
