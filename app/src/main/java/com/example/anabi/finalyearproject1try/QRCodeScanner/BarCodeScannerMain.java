package com.example.anabi.finalyearproject1try.QRCodeScanner;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.Manifest.permission.CAMERA;

public class BarCodeScannerMain extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private static final int REQUEST_CAMERA = 1;
    private ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

            if(checkPermission()){

                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                
            }
            else {

                    requestPermission();
                
            }

        }
    }


    private boolean checkPermission(){


        return (ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA)== PackageManager.PERMISSION_GRANTED);

    }


    private void requestPermission(){


        ActivityCompat.requestPermissions(this,new String[] {CAMERA}, REQUEST_CAMERA);

    }


    public void onRequestPermissionsResult(int requestCode, String permission[], int grantResults[]){

        switch (requestCode){

            case REQUEST_CAMERA:
                if(grantResults.length > 0){

                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if(cameraAccepted){

                        Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                    }else {

                        Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

                            if(shouldShowRequestPermissionRationale(CAMERA)){

                                displayAlertMessage("You need to allow for both permission",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int i) {

                                                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){

                                                    requestPermissions(new String[]{CAMERA}, REQUEST_CAMERA);

                                                }


                                            }
                                        });
                                return;

                            }
                        }
                    }
                }
                break;


        }


    }


    @Override
   public void onResume() {
        super.onResume();

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if(checkPermission()){


                if(scannerView == null){

                    scannerView = new ZXingScannerView(this);
                    setContentView(scannerView);
                }
                scannerView.setResultHandler(this);

                scannerView.startCamera();

            }
            else {
                requestPermission();
            }
        }
    }





    @Override
    protected void onDestroy() {
        super.onDestroy();
        scannerView.stopCamera();
    }










    public void displayAlertMessage(String message, DialogInterface.OnClickListener listener){

        new AlertDialog.Builder(getApplicationContext())
                .setMessage(message)
                .setPositiveButton("Ok",listener)
                .setNegativeButton("Cancel",null)
                .create()
                .show();
    }





    @Override
    public void handleResult(Result result) {

        final String scanResult = result.getText();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan result");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                scannerView.resumeCameraPreview(BarCodeScannerMain.this);

            }
        });

        builder.setNeutralButton("Visit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(scanResult));
                startActivity(intent);

            }
        });

        builder.setMessage(scanResult);
        AlertDialog alert = builder.create();
        alert.show();

    }
}
