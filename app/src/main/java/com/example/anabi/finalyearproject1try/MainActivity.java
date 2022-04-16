package com.example.anabi.finalyearproject1try;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotodashboard(View view) {

        Intent intent = new Intent(MainActivity.this,DashboardActivity.class);
        startActivity(intent);

    }

    public void gotosmartphoneactivity(View view) {

        Intent intent = new Intent(MainActivity.this,SmartphoneActivity.class);
        startActivity(intent);

    }

    public void gotosmartphonebrandactivity(View view) {

        Intent intent = new Intent(MainActivity.this,Smartphone_brandList_activity.class);
        startActivity(intent);
    }

    public void gotoDesktopActivity(View view) {

        Intent intent = new Intent(MainActivity.this,DesktopActivity.class);
        startActivity(intent);

    }


    public void latopbrandguides(View view) {

        Intent intent = new Intent(MainActivity.this,LaptopActivity.class);
        startActivity(intent);




    }

    public void latopbrandselection(View view) {

        Intent intent = new Intent(MainActivity.this,LaptopBrandSelection.class);
        startActivity(intent);

    }
}
