package com.example.anabi.finalyearproject1try.FireBaseBackend.registration;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anabi.finalyearproject1try.DashboardActivity;
import com.example.anabi.finalyearproject1try.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
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

import de.hdodenhof.circleimageview.CircleImageView;
import id.zelory.compressor.Compressor;

public class SetProfileActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private CircleImageView mSelectImag;
    private Uri imageUri = null;
    private static final String LOG_TAG = "SetProfileActivity";
    private EditText edtprofileName, edtProfession;
    private Button profileSetBtn;
    private String userName, userEmail, userPassword;
    private FirebaseAuth mAuth;
    private StorageReference storageReference;
    private Bitmap compressed;
    private String user_id;
    private FirebaseFirestore mfireStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_profile);

        Log.d(LOG_TAG,"onCreate");

        mAuth = FirebaseAuth.getInstance();
        user_id = mAuth.getCurrentUser().getUid();
        mfireStore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        progressDialog = new ProgressDialog(this);
        userName = getIntent().getStringExtra("UserName");
        userEmail = getIntent().getStringExtra("userEmail");
        userPassword = getIntent().getStringExtra("userPassword");

        edtprofileName = findViewById(R.id.setProfileName);
        edtProfession = findViewById(R.id.setProfileProfession);
        profileSetBtn = findViewById(R.id.setProfileSubmitBtn);

        edtprofileName.setText(userName);

        mSelectImag = findViewById(R.id.circleImageView2);
        mSelectImag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                    if (ContextCompat.checkSelfPermission(SetProfileActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) !=
                            PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(SetProfileActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);

                    } else {

                        chooseImage();

                    }

                } else {

                    chooseImage();

                }
            }
        });
        profileSetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG,"entered in profile submit btn");
                progressDialog.setMessage("Storing Data.....");
                progressDialog.show();
                final String user_email = userEmail;
                final String user_password = userPassword;
                final String user_name = userName;
                final String user_profession = edtProfession.getText().toString();
                if(!TextUtils.isEmpty(user_name) && !TextUtils.isEmpty(user_profession) && !TextUtils.isEmpty(user_email)&& !TextUtils.isEmpty(user_password)&& imageUri != null){
                    File newFile = new File(imageUri.getPath());
                    try {
                        compressed = new Compressor(SetProfileActivity.this)
                                .setMaxHeight(125)
                                .setMaxWidth(125)
                                .setQuality(50)
                                .compressToBitmap(newFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    compressed.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

                    byte[] thumbData = byteArrayOutputStream.toByteArray();

                    UploadTask image_path = storageReference.child("user_image").child(user_id+".jpg").putBytes(thumbData);
                    image_path.addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            if(task.isSuccessful()){
                                Log.d(LOG_TAG,"entered in image_path complete");
                                storeData(task, user_name, user_profession, user_email, user_password);
                            }else {


                                String error = task.getException().getMessage();


                                Toast.makeText(SetProfileActivity.this, "(IMAGE Error) : " + error, Toast.LENGTH_LONG).show();
                                Log.d(LOG_TAG, "image_path Error is : "+error);


                                progressDialog.dismiss();


                            }
                        }
                    });
                }else{
                    Toast.makeText(SetProfileActivity.this, "Please mention all details!", Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }
            }
        });


    }

    private void storeData(Task<UploadTask.TaskSnapshot> task, String user_name, String user_profession, String userEmail, String userPassword) {

        Uri downloadURI;
        if(task != null){
            downloadURI = task.getResult().getDownloadUrl();
        }else {
            downloadURI = imageUri;
        }

        Map<String, String> userData = new HashMap<>();
        userData.put("userName", user_name);
        userData.put("userProfession", user_profession);
        userData.put("userImage", downloadURI.toString());
        userData.put("userEmail", userEmail);
        userData.put("userPassword", userPassword);

        mfireStore.collection("Users").document(user_id).set(userData)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){

                            progressDialog.dismiss();
                            Toast.makeText(SetProfileActivity.this, "User data is stored successfully", Toast.LENGTH_LONG).show();
                            //Intent mainIntent = new Intent(SetProfileActivity.this, DatabaseDashboardActivity.class);
                            Intent mainIntent = new Intent(SetProfileActivity.this, DashboardActivity.class); // previous database dashboard
                            startActivity(mainIntent);
                            finish();

                        }else {
                            String error = task.getException().getMessage();
                            Toast.makeText(SetProfileActivity.this, "(FIRESTORE Error) : " + error, Toast.LENGTH_LONG).show();

                        }
                        progressDialog.dismiss();

                    }
                });


    }

    private void chooseImage() {
        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .setAspectRatio(1,1)
                .start(SetProfileActivity.this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {

                imageUri = result.getUri();
                mSelectImag.setImageURI(imageUri);


            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {

                Exception error = result.getError();

            }
        }

    }
}
