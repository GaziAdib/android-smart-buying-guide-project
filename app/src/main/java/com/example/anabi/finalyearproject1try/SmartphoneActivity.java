package com.example.anabi.finalyearproject1try;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class SmartphoneActivity extends AppCompatActivity {

    private CardView smartphoneProcessorCardView,smartphoneRamCardView,smartphoneRomCardView,smartphoneCameraCardView,smartphoneDisplayCardView,smartphoneBatteryCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartphone);


        smartphoneProcessorCardView = (CardView)findViewById(R.id.smartphoneActivityProcessorCardViewId);
        smartphoneRamCardView = (CardView)findViewById(R.id.smartphoneActivityRamCardViewId);
        smartphoneRomCardView = (CardView)findViewById(R.id.smartphoneActivityRomCardViewId);
        smartphoneCameraCardView = (CardView)findViewById(R.id.smartphoneActivityCameraCardViewId);
        smartphoneDisplayCardView = (CardView)findViewById(R.id.smartphoneActivityDisplayCardViewId);
        smartphoneBatteryCardView = (CardView)findViewById(R.id.smartphoneActivityBatteryCardViewId);


        smartphoneProcessorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),SmartphoneTechActivityProcessor.class);
                startActivity(intent);

            }
        });




        smartphoneRamCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),SmartphoneTechRamActivity.class);
                startActivity(intent);

            }
        });


        smartphoneRomCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),SmartphoneTechRomActivity.class);
                startActivity(intent);

            }
        });


        smartphoneCameraCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),SmartphoneTechCameraActivity.class);
                startActivity(intent);

            }
        });


        smartphoneDisplayCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),SmartphoneTechDisplayAcivity.class);
                startActivity(intent);

            }
        });

        smartphoneBatteryCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),SmartphoneTechBatteryActivity.class);
                startActivity(intent);

            }
        });



    }
}
