package com.example.anabi.finalyearproject1try;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anabi.finalyearproject1try.FingerPrintAuthentication.FingerPrintAuthActivity;

public class SplashActivity extends AppCompatActivity {

    //SharedPreferences sharedPreferences;
    //Boolean firstTime;

    ImageView imageView;
    TextView textView;
    Animation image_anim,text_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        imageView = (ImageView)findViewById(R.id.splash_image_view_id);
        textView = (TextView)findViewById(R.id.splash_text_view_id);


        image_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splash_animation_1);
        text_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splash_animation_1);

        imageView.setAnimation(image_anim);
        textView.setAnimation(text_anim);



        //sharedPreferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);

        // firstTime = sharedPreferences.getBoolean("firstTime",true);

        //if(firstTime){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //SharedPreferences.Editor editor = sharedPreferences.edit();
                //firstTime = false;
                //editor.putBoolean("firstTime",firstTime);
                //editor.apply();

                Intent i = new Intent(getApplicationContext(), FingerPrintAuthActivity.class); // after splash go to Fingerprint
                //Intent i = new Intent(getApplicationContext(), FingerprintCheckSharedPreference.class);
                startActivity(i);
                finish();

            }
        }, 2200);


        //}else {

        // Intent i = new Intent(getApplicationContext(),MainActivity.class);
        //startActivity(i);
        //finish();


        // }



    }
}
