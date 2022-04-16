package com.example.anabi.finalyearproject1try;

import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class SecurityPageContainer extends AppCompatActivity {


    CardView securitySmartphoneCard, securityDesktopCard, securityLaptopCard, securityTvCard;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_page_container);

        securitySmartphoneCard = (CardView)findViewById(R.id.security_smartphone_card_id);
        securityLaptopCard = (CardView)findViewById(R.id.security_laptop_card_id);
        securityDesktopCard = (CardView)findViewById(R.id.security_desktop_card_id);
        securityTvCard = (CardView)findViewById(R.id.security_tv_card_id);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);


        securitySmartphoneCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);
                Intent i = new Intent(getApplicationContext(),SecuritySmartphone.class);
                startActivity(i);

            }
        });


        securityLaptopCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);
                Intent i = new Intent(getApplicationContext(),SecurityLaptop.class);
                startActivity(i);

            }
        });


        securityDesktopCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);
                Intent i = new Intent(getApplicationContext(),SecurityDesktop.class);
                startActivity(i);

            }
        });


        securityTvCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);
                Intent i = new Intent(getApplicationContext(),SecurityTv.class);
                startActivity(i);

            }
        });

    }
}
