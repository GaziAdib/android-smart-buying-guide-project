package com.example.anabi.finalyearproject1try;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class SmartphoneSelectionTechOrBrand extends AppCompatActivity {

    CardView smartphoneBrandSelectCardId,smartphoneTechSelectCardId;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartphone_selection_tech_or_brand);

        smartphoneBrandSelectCardId = (CardView)findViewById(R.id.smartphoneBrandSelectId);
        smartphoneTechSelectCardId =(CardView)findViewById(R.id.smartphoneTechnologySelectId);

        vibrator =(Vibrator) getSystemService(VIBRATOR_SERVICE);

        smartphoneTechSelectCardId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(),SmartphoneActivity.class);
                startActivity(intent);

            }
        });

        smartphoneBrandSelectCardId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(),Smartphone_brandList_activity.class);
                startActivity(intent);

            }
        });


    }
}
