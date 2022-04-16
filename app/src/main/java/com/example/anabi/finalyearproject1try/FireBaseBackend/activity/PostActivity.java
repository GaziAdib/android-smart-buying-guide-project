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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.anabi.finalyearproject1try.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
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

public class PostActivity extends AppCompatActivity {

    private Uri imageUri = null;
    private FirebaseAuth mAuth;
    private StorageReference storageReference;
    private Bitmap compressed;
    private String user_id;
    private FirebaseFirestore mfireStore;
    private Spinner postSpinnerAddCategory;
    private ArrayAdapter<String> postAdapterAddCategory;
    private String itemSelected;
    private EditText productIDEdt, productNameEdt, productDescriptionEdt, productPriceEdt, screenSizeEdt, recommendationEdt;
    private Button submitPostBtn;
    private ImageView postImageView;
    private ProgressDialog progressDialog;
    private Spinner postSpinnerAddComponent;
    private String componentItemSelected;
    private ArrayAdapter<String> postAdapterAddComponent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

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
        screenSizeEdt = findViewById(R.id.postScreenSize);
        recommendationEdt = findViewById(R.id.recommendation);

        postImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(PostActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) !=
                            PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(PostActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                    } else {
                        chooseImage();
                    }
                } else {
                    chooseImage();
                }
            }
        });

        postSpinnerAddCategory = findViewById(R.id.postSpinnerAddCategory);
        postAdapterAddCategory = new ArrayAdapter<>(PostActivity.this, R.layout.post_activity_spinner_for_program,
                new String[]{"Add Category", "Smart Phone", "Laptop", "Desktop", "Television"});
        postSpinnerAddCategory.setAdapter(postAdapterAddCategory);

        postSpinnerAddCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemSelected = postSpinnerAddCategory.getItemAtPosition(position).toString();
                if (itemSelected.equals("Add Category")) {
                } else if (itemSelected.equals("Smart Phone")) {
                    itemSelected = "Smart Phone";
                } else if (itemSelected.equals("Laptop")) {
                    itemSelected = "Laptop";
                    screenSizeEdt.setVisibility(View.VISIBLE);
                } else if (itemSelected.equals("Desktop")) {
                    postSpinnerAddComponent.setVisibility(View.VISIBLE);
                    itemSelected = "Desktop";
                } else if (itemSelected.equals("Television")) {
                    itemSelected = "Television";
                    screenSizeEdt.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        postSpinnerAddComponent = findViewById(R.id.postSpinnerAddComponent);
        postAdapterAddComponent = new ArrayAdapter<>(PostActivity.this, R.layout.post_activity_spinner_for_program,
                new String[]{"Add Component", "CPU", "Motherboard", "Monitor","Keyboard", "Mouse","RAM","GPU","HDD","SSD"});
        postSpinnerAddComponent.setAdapter(postAdapterAddComponent);

        postSpinnerAddComponent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                componentItemSelected = postSpinnerAddComponent.getItemAtPosition(position).toString();
                if(componentItemSelected.equals("CPU")){
                    componentItemSelected = "CPU";
                }else if(componentItemSelected.equals("Motherboard")){
                    componentItemSelected = "Motherboard";
                }
                else if(componentItemSelected.equals("Monitor")){
                    componentItemSelected = "Monitor";
                }
                else if(componentItemSelected.equals("Keyboard")){
                    componentItemSelected = "Keyboard";
                }
                else if(componentItemSelected.equals("Mouse")){
                    componentItemSelected = "Mouse";
                }
                else if(componentItemSelected.equals("RAM")){
                    componentItemSelected = "RAM";
                }
                else if(componentItemSelected.equals("GPU")){
                    componentItemSelected = "GPU";
                }
                else if(componentItemSelected.equals("HDD")){
                    componentItemSelected = "HDD";
                }
                else if(componentItemSelected.equals("SSD")){
                    componentItemSelected = "SSD";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        submitPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String productId = productIDEdt.getText().toString();
                final String productName = productNameEdt.getText().toString();
                final String productDescription = productDescriptionEdt.getText().toString();
                final String productPrice = productPriceEdt.getText().toString();
                final String selectedProductCategory = itemSelected;
                final String selectedProductComponent = componentItemSelected;
                final String screenSize = screenSizeEdt.getText().toString();
                final String recommendation = recommendationEdt.getText().toString();



                if (!TextUtils.isEmpty(productId) && !TextUtils.isEmpty(productName) && !TextUtils.isEmpty(productDescription) && !TextUtils.isEmpty(productPrice) && !TextUtils.isEmpty(selectedProductCategory) && imageUri != null  && !TextUtils.isEmpty(recommendation)) {

                    FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
                    DocumentReference docIdRef = rootRef.collection(selectedProductCategory).document(productId);
                    docIdRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();
                                if (document.exists()) {
                                    Toast.makeText(PostActivity.this, "Sorry the Product ID is alredy present", Toast.LENGTH_LONG).show();
                                } else {
                                    progressDialog.setMessage("Storing Data.....");
                                    progressDialog.show();
                                    Log.d("checking", "Data not Present");
                                    File newFile = new File(imageUri.getPath());
                                    try {
                                        compressed = new Compressor(PostActivity.this)
                                                .setMaxHeight(125)
                                                .setMaxWidth(125)
                                                .setQuality(80)
                                                .compressToBitmap(newFile);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                    compressed.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

                                    byte[] thumbData = byteArrayOutputStream.toByteArray();
                                    String randomName = UUID.randomUUID().toString();
                                    UploadTask image_path = storageReference.child("product_Image").child(randomName + ".jpg").putBytes(thumbData);
                                    image_path.addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                                        @Override
                                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                                            if (task.isSuccessful()) {
                                                storeData(task, productId, productName, productDescription, productPrice, selectedProductCategory, selectedProductComponent, screenSize, recommendation);
                                            } else {


                                                String error = task.getException().getMessage();


                                                Toast.makeText(PostActivity.this, "(IMAGE Error) : " + error, Toast.LENGTH_LONG).show();


                                                progressDialog.dismiss();


                                            }
                                        }
                                    });
                                }
                            }
                        }
                    });


                } else {
                    Toast.makeText(PostActivity.this, "Please mention all details!", Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }

            }
        });
    }

    private void storeData(Task<UploadTask.TaskSnapshot> task, final String productId, String productName, String productDescription, String productPrice, final String selectedProductCategory, String recomm, String screenSize, String componentCategory) {
        Uri downloadURI;
        if (task != null) {
            downloadURI = task.getResult().getDownloadUrl();
        } else {
            downloadURI = imageUri;
        }
        Map<String, Object> productData = new HashMap<>();
        productData.put("productId", productId);
        productData.put("productName", productName);
        productData.put("productImage", downloadURI.toString());
        productData.put("productDescription", productDescription);
        productData.put("productPrice", productPrice);
        productData.put("selectedProductCategory", selectedProductCategory);
        productData.put("selectedProductComponent", recomm);
        productData.put("ScreenSize", screenSize);
        productData.put("Recommendation", componentCategory);
        productData.put("timeStamp", FieldValue.serverTimestamp());
        productData.put("userID", mAuth.getCurrentUser().getUid());
        productData.put("postUserEmail", mAuth.getCurrentUser().getEmail());


        mfireStore.collection(selectedProductCategory).document(productId).set(productData)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            progressDialog.dismiss();
                            Toast.makeText(PostActivity.this, "Post Submitted Successfully", Toast.LENGTH_SHORT).show();
                            //setFeedDetails(selectedProductCategory, productId);
                        } else {
                            String error = task.getException().getMessage();
                            Toast.makeText(PostActivity.this, "(FIRESTORE Error) : " + error, Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                        PostActivity.this.finish();
                    }
                });


    }


    private void chooseImage() {
        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .setAspectRatio(2, 1)
                .start(PostActivity.this);
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
