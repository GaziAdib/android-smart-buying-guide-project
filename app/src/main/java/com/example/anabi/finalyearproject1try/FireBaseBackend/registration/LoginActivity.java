package com.example.anabi.finalyearproject1try.FireBaseBackend.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anabi.finalyearproject1try.DashboardActivity;
import com.example.anabi.finalyearproject1try.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {

    private TextView forgotPasswordTv;
    private Button signUpBtn, loginBtn;
    private EditText userEmail,userPassword;
    private ProgressBar loadingProgress;
    private FirebaseAuth mAuth;
    private FirebaseFirestore mFirebaseFirestore;
    private String user_id;

    @Override
    protected void onStart() {
        super.onStart();


        if(mAuth.getCurrentUser()!=null){
            //startActivity(new Intent(LoginActivity.this, DatabaseDashboardActivity.class));
            startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userEmail = findViewById(R.id.loginMail);
        userPassword = findViewById(R.id.loginPassword);
        loginBtn = findViewById(R.id.loginBtn);
        signUpBtn = findViewById(R.id.loginRegister);
        loadingProgress = findViewById(R.id.loginProgressBar);
        loadingProgress.setVisibility(View.INVISIBLE);
        forgotPasswordTv = findViewById(R.id.forgetPasswordTv);

        mAuth = FirebaseAuth.getInstance();


        // forget pass tv function on click


        forgotPasswordTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ForgetPasswordActivity.class);
                startActivity(i);
            }
        });


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginBtn.setVisibility(View.INVISIBLE);
                loadingProgress.setVisibility(View.VISIBLE);
                final String email = userEmail.getText().toString();
                final String password = userPassword.getText().toString();
                if(email.isEmpty() || password.isEmpty()){
                    showMessage("Please Verify all fields") ;
                    signUpBtn.setVisibility(View.VISIBLE);
                    loadingProgress.setVisibility(View.INVISIBLE);
                }else{
                    signIn(email, password);
                }
            }
        });
    }

    private void signIn(final String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    loadingProgress.setVisibility(View.INVISIBLE);
                    loginBtn.setVisibility(View.VISIBLE);
                    //startActivity(new Intent(LoginActivity.this, DatabaseDashboardActivity.class));
                    startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                    Toast.makeText(LoginActivity.this, "Contratulations! You are logged in as "+email, Toast.LENGTH_LONG).show();
                }else {
                    showMessage(task.getException().getMessage());
                    loginBtn.setVisibility(View.VISIBLE);
                    loadingProgress.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }


    // forgot password functions






}
