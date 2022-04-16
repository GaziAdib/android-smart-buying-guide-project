package com.example.anabi.finalyearproject1try.FireBaseBackend.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anabi.finalyearproject1try.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPasswordActivity extends AppCompatActivity {

    private EditText passwordEmail;
    private Button resetPassBtn;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);


        passwordEmail = (EditText) findViewById(R.id.et_forgetEmailId);
        resetPassBtn = (Button) findViewById(R.id.passwordResetButtonId);
        mAuth = FirebaseAuth.getInstance();


        resetPassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userEmail = passwordEmail.getText().toString().trim();


                if(userEmail.equals("")){

                    Toast.makeText(ForgetPasswordActivity.this, "Enter email please..", Toast.LENGTH_SHORT).show();
                }else {


                    mAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful()){

                                Toast.makeText(ForgetPasswordActivity.this, "Password reset email send..", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(getApplicationContext(),LoginActivity.class));

                            }else {

                                Toast.makeText(ForgetPasswordActivity.this, "Error is sending password reset option..", Toast.LENGTH_SHORT).show();

                            }



                        }
                    });


                }





            }
        });
    }
}
