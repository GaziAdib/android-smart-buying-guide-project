package com.example.anabi.finalyearproject1try;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.anabi.finalyearproject1try.SmartphoneAppleWebTabs.SmartphoneAppleWebTabMain;
import com.example.anabi.finalyearproject1try.SmartphoneAsusWebTabs.SmartphoneAsusWebTabMain;
import com.example.anabi.finalyearproject1try.SmartphoneHuaweiWebTabs.SmartphoneHuaweiWebTabMain;
import com.example.anabi.finalyearproject1try.SmartphoneOnePlusWebTabs.SmartphoneOnePlusWebTabMain;
import com.example.anabi.finalyearproject1try.SmartphoneSamsungWebTabs.SamsungSmartphoneWebTabMain;
import com.example.anabi.finalyearproject1try.SmartphoneXiomiWebTabs.SmartphoneXiomiWebTabMain;

public class Smartphone_brandList_activity extends AppCompatActivity {

    CardView appleCardView,samsungCardView,xiomiCardView,huaweiCardView,onePlusCardView,asusCardView;
    Vibrator vibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartphone_brand_list_activity);

        appleCardView = (CardView) findViewById(R.id.appleSmartphoneCardViewId);
        samsungCardView = (CardView) findViewById(R.id.samsungSmartphoneCardViewId);
        xiomiCardView = (CardView) findViewById(R.id.xiomiSmartphoneCardViewId);
        huaweiCardView = (CardView) findViewById(R.id.huaweiSmartphoneCardViewId);
        onePlusCardView = (CardView) findViewById(R.id.onePlusSmartphoneCardViewId);
        asusCardView = (CardView) findViewById(R.id.asusSmartphoneCardViewId);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        appleCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //final String myPackage = getPackageName();
                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.apple.com/iphone/?id=" +myPackage));
                //startActivity(intent);

                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(), SmartphoneAppleWebTabMain.class);
                startActivity(intent);

            }
        });

        samsungCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(), SamsungSmartphoneWebTabMain.class);
                startActivity(intent);

                //final String myPackage = getPackageName();
                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.samsung.com/global/galaxy/?id=" +myPackage));
               // startActivity(intent);
            }
        });

        xiomiCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(), SmartphoneXiomiWebTabMain.class);
                startActivity(intent);

                //final String myPackage = getPackageName();
                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mi.com/bd/?id=" +myPackage));
                //startActivity(intent);
            }
        });

        huaweiCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(), SmartphoneHuaweiWebTabMain.class);
                startActivity(intent);

                //final String myPackage = getPackageName();
                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://consumer.huawei.com/en/phones/?id=" +myPackage));
                //startActivity(intent);
            }
        });

        onePlusCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(), SmartphoneOnePlusWebTabMain.class);
                startActivity(intent);

                //final String myPackage = getPackageName();
                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nokia.com/phones/en_int/android-phones?id=" +myPackage));
                //startActivity(intent);
            }
        });

        asusCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(), SmartphoneAsusWebTabMain.class);
                startActivity(intent);

                //final String myPackage = getPackageName();
                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.asus.com/Phone/?id=" +myPackage));
                //startActivity(intent);
            }
        });


    }
}
