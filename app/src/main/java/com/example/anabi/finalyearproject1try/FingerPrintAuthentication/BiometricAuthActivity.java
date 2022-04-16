package com.example.anabi.finalyearproject1try.FingerPrintAuthentication;

import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.anabi.finalyearproject1try.IntroSliderMaterial.IntroSliderActivity;
import com.example.anabi.finalyearproject1try.R;
import com.multidots.fingerprintauth.AuthErrorCodes;
import com.multidots.fingerprintauth.FingerPrintAuthCallback;
import com.multidots.fingerprintauth.FingerPrintAuthHelper;

public class BiometricAuthActivity extends AppCompatActivity implements FingerPrintAuthCallback {

    FingerPrintAuthHelper mFingerPrintAuthHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biometric_auth);


        mFingerPrintAuthHelper = FingerPrintAuthHelper.getHelper(this,this);


    }


    @Override
    protected void onResume() {
        super.onResume();
        //start finger print authentication
        mFingerPrintAuthHelper.startAuth();
    }


    @Override
    protected void onPause() {
        super.onPause();
        mFingerPrintAuthHelper.stopAuth();
    }


    @Override
    public void onNoFingerPrintHardwareFound() {


        Toast.makeText(this, "Your Device does not have Fingerprint sensor !", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNoFingerPrintRegistered() {

        Toast.makeText(this, "Sir, please register Fingerprint from your setting first!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBelowMarshmallow() {

        Toast.makeText(this, "You device doesn't support fingerprint authentication!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAuthSuccess(FingerprintManager.CryptoObject cryptoObject) {

        Toast.makeText(this, "Fingerprint Authenticated successfully!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), IntroSliderActivity.class));

    }

    @Override
    public void onAuthFailed(int errorCode, String errorMessage) {

        switch (errorCode) {    //Parse the error code for recoverable/non recoverable error.
            case AuthErrorCodes.CANNOT_RECOGNIZE_ERROR:
                //Cannot recognize the fingerprint scanned.
                Toast.makeText(this, "Cannot recongnize!", Toast.LENGTH_SHORT).show();
                break;
            case AuthErrorCodes.NON_RECOVERABLE_ERROR:
                //This is not recoverable error. Try other options for user authentication. like pin, password.
                break;
            case AuthErrorCodes.RECOVERABLE_ERROR:
                //Any recoverable error. Display message to the user.
                break;
        }

    }
}
