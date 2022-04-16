package com.example.anabi.finalyearproject1try.FingerPrintAuthentication;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.anabi.finalyearproject1try.IntroSliderMaterial.IntroSliderActivity;
import com.example.anabi.finalyearproject1try.R;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class FingerPrintAuthActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_print_auth);

        final Executor executor = Executors.newSingleThreadExecutor();

        final BiometricPrompt biometricPrompt = new BiometricPrompt.Builder(this)
                .setTitle("Fingerprint Authentication")
                .setSubtitle("Increases the security")
                .setDescription("Finger print uses your biometric so it is very secure way to use your app!")
                .setNegativeButton("Cancel", executor, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).build();

        Button authBtn = findViewById(R.id.authenticateId);

        final FingerPrintAuthActivity activity = this;

        authBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                biometricPrompt.authenticate(new CancellationSignal(), executor, new BiometricPrompt.AuthenticationCallback() {
                    @Override
                    public void onAuthenticationError(int errorCode, CharSequence errString) {
                        super.onAuthenticationError(errorCode, errString);

                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                Toast.makeText(FingerPrintAuthActivity.this, "Error check if your device support fingerprint!", Toast.LENGTH_SHORT).show();

                            }
                        });
                    }

                    @Override
                    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
                        super.onAuthenticationHelp(helpCode, helpString);

                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                Toast.makeText(FingerPrintAuthActivity.this, "Undiscoverable error ocurred!", Toast.LENGTH_SHORT).show();

                            }
                        });
                    }

                    @Override
                    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                        super.onAuthenticationSucceeded(result);

                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                Toast.makeText(FingerPrintAuthActivity.this, "Authenticated! congratulations", Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(FingerPrintAuthActivity.this, IntroSliderActivity.class)); //after splash auth then intro slider
                            }
                        });

                    }

                    @Override
                    public void onAuthenticationFailed() {
                        super.onAuthenticationFailed();

                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                Toast.makeText(FingerPrintAuthActivity.this, "Authentication failed! try gain", Toast.LENGTH_SHORT).show();

                            }
                        });
                    }


                });

            }
        });


        FingerprintManager fingerprintManager = (FingerprintManager) getSystemService(Context.FINGERPRINT_SERVICE);
        if (!fingerprintManager.isHardwareDetected()) {
            // Device doesn't support fingerprint authentication

            Intent i = new Intent(getApplicationContext(),IntroSliderActivity.class);
            startActivity(i);

        } else if (!fingerprintManager.hasEnrolledFingerprints()) {
            Toast.makeText(activity, "Add fingerprint auth in setting! then proceed", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(activity, "Tap your finger in sensor to proceed", Toast.LENGTH_SHORT).show();
        }


    }
}

