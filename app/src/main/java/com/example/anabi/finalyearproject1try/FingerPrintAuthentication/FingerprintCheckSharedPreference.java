package com.example.anabi.finalyearproject1try.FingerPrintAuthentication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.anabi.finalyearproject1try.R;

public class FingerprintCheckSharedPreference extends AppCompatActivity {

    Button yesBtn, noBtn, doneBtn;
    //SharedPreferences preferences;
    //Boolean firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fingerprint_check_shared_preference);

        yesBtn = findViewById(R.id.yesFingerprintButtonId);
        noBtn = findViewById(R.id.noFingerprintButtonId);
       // doneBtn = findViewById(R.id.click_done_btn_id);

//        doneBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                SavePrefData();
//
//                if(yesBtn.isActivated()){
//
//                    restorePrefData();
//                    startActivity(new Intent(getApplicationContext(),FingerPrintAuthActivity.class));
//                }
//                else {
//                    restorePrefData();
//                    startActivity(new Intent(getApplicationContext(), IntroSliderActivity.class));
//                }
//
//
//
//            }
//        });




        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Intent fingerActivityIntent = new Intent(getApplicationContext(),FingerPrintAuthActivity.class);
                //Intent fingerActivityIntent = new Intent(getApplicationContext(), SplashActivity.class);
                //startActivity(fingerActivityIntent);
                Toast.makeText(FingerprintCheckSharedPreference.this, "Saved preferences for  fingerprint supported device", Toast.LENGTH_SHORT).show();
                //SavePrefData();




            }
        });

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent i = new Intent(getApplicationContext(), IntroSliderActivity.class);
                //Intent i = new Intent(getApplicationContext(), SplashActivity.class);
                //startActivity(i);

                Toast.makeText(FingerprintCheckSharedPreference.this, "Saved preferences for without fingerprint supported device!", Toast.LENGTH_SHORT).show();
                //SavePrefData();



            }
        });


    }





//    private boolean restorePrefData(){
//
//        SharedPreferences pref = getApplicationContext().getSharedPreferences("myFinger",Context.MODE_PRIVATE);
//        Boolean isFingerCheckOpenedBefore = pref.getBoolean("isFingerCheckOpenedBefore",false);
//        return isFingerCheckOpenedBefore;
//
//
//    }
//
//
//
//    private void SavePrefData(){
//
//        SharedPreferences pref = getApplicationContext().getSharedPreferences("myFinger", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = pref.edit();
//        editor.putBoolean("isFingerCheckOpenedBefore",true);
//        editor.commit();
//
//
//
//    }




}
