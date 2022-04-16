package com.example.anabi.finalyearproject1try.FireBaseBackend.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.anabi.finalyearproject1try.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {

    private Button signUpBtn, loginBtn;
    private EditText userEmail,userPassword,userName;
    private ProgressBar loadingProgress;
    private FirebaseAuth mAuth;
    private FirebaseFirestore mFirebaseFirestore;
    private String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        userEmail = findViewById(R.id.regMail);
        userPassword = findViewById(R.id.regPassword);
        userName = findViewById(R.id.regName);
        loadingProgress = findViewById(R.id.regProgressBar);
        signUpBtn = findViewById(R.id.regBtn);
        loginBtn = findViewById(R.id.logBtn);
        loadingProgress.setVisibility(View.INVISIBLE);


        mAuth = FirebaseAuth.getInstance();
        mFirebaseFirestore = FirebaseFirestore.getInstance();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
            }
        });


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signUpBtn.setVisibility(View.INVISIBLE);
                loadingProgress.setVisibility(View.VISIBLE);
                final String email = userEmail.getText().toString().trim();
                final String password = userPassword.getText().toString().trim();
                final String name = userName.getText().toString().trim();

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if( email.isEmpty() || name.isEmpty() || password.isEmpty()) {

                    if(!email.matches(emailPattern)){
                        Toast.makeText(RegistrationActivity.this, "Enter valid Email please!", Toast.LENGTH_SHORT).show();
                    }

                    if(password.length() < 6){
                        Toast.makeText(RegistrationActivity.this, "Please make sure Password is at least 6 digit!", Toast.LENGTH_SHORT).show();
                    }
                    

                    // something goes wrong : all fields must be filled
                    // we need to display an error message
                    showMessage("Please Verify all fields") ;
                    signUpBtn.setVisibility(View.VISIBLE);
                    loadingProgress.setVisibility(View.INVISIBLE);


                }
                else {
                    // everything is ok and all fields are filled now we can start creating user account
                    // CreateUserAccount method will try to create the user if the email is valid

                    CreateUserAccount(email,name,password);
                }
            }
        });


    }
    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }

    private void CreateUserAccount(final String email, final String name, final String password) {


        // this method create user account with specific email and password

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            // user account created successfully
                            showMessage("Account created");
                            // after we created user account we need to update his profile picture and name
                            //updateUserInfo( name, email);
                            signUpBtn.setVisibility(View.VISIBLE);
                            loadingProgress.setVisibility(View.INVISIBLE);
                            Toast.makeText(RegistrationActivity.this,"Registration done!", Toast.LENGTH_SHORT).show();
                            Intent valueIntent = new Intent(RegistrationActivity.this, SetProfileActivity.class);
                            valueIntent.putExtra("UserName", name);
                            valueIntent.putExtra("userEmail", email);
                            valueIntent.putExtra("userPassword", password);
                            startActivityForResult(valueIntent,111);

                        }
                        else
                        {
                            // account creation failed
                            showMessage("account creation failed" + task.getException().getMessage());
                            signUpBtn.setVisibility(View.VISIBLE);
                            loadingProgress.setVisibility(View.INVISIBLE);
                        }
                    }
                });
    }

    private void updateUserInfo(String name, String email) {

        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("userName", name);
        userInfo.put("userEmail", email);

        mFirebaseFirestore.collection("Users").document(mAuth.getCurrentUser().getUid()).set(userInfo)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        signUpBtn.setVisibility(View.VISIBLE);
                        loadingProgress.setVisibility(View.INVISIBLE);
                        Toast.makeText(RegistrationActivity.this,"Registration done!", Toast.LENGTH_SHORT).show();
                        loadDetails();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        signUpBtn.setVisibility(View.VISIBLE);
                        loadingProgress.setVisibility(View.INVISIBLE);
                        Toast.makeText(RegistrationActivity.this,"Error! " +e, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void loadDetails() {
        mFirebaseFirestore.collection("Users").document(mAuth.getCurrentUser().getUid()).get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        String Name = documentSnapshot.getString("userName");
                        Toast.makeText(RegistrationActivity.this,"Value is: "+Name,Toast.LENGTH_SHORT).show();
                        Intent valueIntent = new Intent(RegistrationActivity.this, SetProfileActivity.class);
                        valueIntent.putExtra("UserName", Name);
                        startActivityForResult(valueIntent,111);
                    }
                });
    }
}
