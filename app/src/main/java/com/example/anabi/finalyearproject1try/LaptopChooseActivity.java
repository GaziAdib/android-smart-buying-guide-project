package com.example.anabi.finalyearproject1try;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class LaptopChooseActivity extends AppCompatActivity {

    private CardView laptopBrands,laptopGuide;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop_choose);

        laptopBrands = (CardView)findViewById(R.id.laptopBrandsCardView);
        laptopGuide = (CardView)findViewById(R.id.laptopGuideCardView);

        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);


        laptopGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(50);

                Intent intent = new Intent(getApplicationContext(),LaptopActivity.class);
                startActivity(intent);

            }
        });


        laptopBrands.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(50);


                Intent intent = new Intent(getApplicationContext(),LaptopBrandSelection.class);
                startActivity(intent);


            }
        });
    }
}
