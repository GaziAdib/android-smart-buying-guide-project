package com.example.anabi.finalyearproject1try;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.anabi.finalyearproject1try.DesktopGpuActivity.DesktopGpuActivity;
import com.example.anabi.finalyearproject1try.DesktopHddActivity.DesktopHddActivity;
import com.example.anabi.finalyearproject1try.DesktopKeyboardActivity.DesktopKeyboardActivity;
import com.example.anabi.finalyearproject1try.DesktopMoboTabActivity.DesktopMoboActivity;
import com.example.anabi.finalyearproject1try.DesktopMonitorActivity.DesktopMonitorTabActivity;
import com.example.anabi.finalyearproject1try.DesktopMouseActivity.DesktopMouseActivity;
import com.example.anabi.finalyearproject1try.DesktopProcessorTabActivity.DesktopProcessorActivity;
import com.example.anabi.finalyearproject1try.DesktopRamActivity.DesktopRamActivity;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;

public class DesktopActivity extends AppCompatActivity {

    SliderLayout sliderLayout;

    Vibrator vibrator;

   CardView desktopProcessorCard,desktopMotherboardCard,desktopMonitorCard,desktopRamButtonCard,desktopGpuButtonCard,desktopHddButtonCard,desktopKeyboardButtonCard,desktopMouseButtonCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desktop);

        desktopProcessorCard = (CardView) findViewById(R.id.desktopProcessorCardId);
        desktopMotherboardCard = (CardView) findViewById(R.id.desktopMoboCardId);
        desktopMonitorCard = (CardView)findViewById(R.id.desktopMonitorCardId);
        desktopRamButtonCard = (CardView)findViewById(R.id.desktopRamCardId);
        desktopGpuButtonCard = (CardView)findViewById(R.id.desktopGpuCardId);
        desktopHddButtonCard = (CardView)findViewById(R.id.desktopHddCardId);
        desktopKeyboardButtonCard = (CardView)findViewById(R.id.desktopKeyboardCardId);
        desktopMouseButtonCard = (CardView)findViewById(R.id.desktopMouseCardId);

         vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        sliderLayout = findViewById(R.id.imageSliderDesktopComponents);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :

        setSliderViews();


        desktopProcessorCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(50);

                Intent intent = new Intent(DesktopActivity.this,DesktopProcessorActivity.class);
                startActivity(intent);

            }
        });
        


        desktopMotherboardCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);

                Intent intent = new Intent(DesktopActivity.this,DesktopMoboActivity.class);
                startActivity(intent);

            }
        });



        desktopMonitorCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);

                Intent intent = new Intent(DesktopActivity.this,DesktopMonitorTabActivity.class);
                startActivity(intent);

            }
        });



        desktopRamButtonCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);

                Intent intent = new Intent(DesktopActivity.this,DesktopRamActivity.class);
                startActivity(intent);

            }
        });

        desktopGpuButtonCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(50);
                Intent intent = new Intent(DesktopActivity.this,DesktopGpuActivity.class);
                startActivity(intent);

            }
        });

        desktopHddButtonCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);

                Intent intent = new Intent(DesktopActivity.this,DesktopHddActivity.class);
                startActivity(intent);

            }
        });


        desktopKeyboardButtonCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(50);
                Intent intent = new Intent(DesktopActivity.this,DesktopKeyboardActivity.class);
                startActivity(intent);

            }
        });


        desktopMouseButtonCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);

                Intent intent = new Intent(DesktopActivity.this,DesktopMouseActivity.class);
                startActivity(intent);

            }
        });







    }






    // slider

    private void setSliderViews() {

        for (int i = 0; i <= 10; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.desktop_dummy_slider);
                    sliderView.setDescription("Desktop show");
                    //sliderView.setImageUrl("https://images.pexels.com/photos/547114/pexels-photo-547114.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.desktop_dummy_slider2);
                    sliderView.setDescription("Desktop show");
                    //sliderView.setImageUrl("https://images.pexels.com/photos/218983/pexels-photo-218983.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.smartphone_dummy_slider1);
                    sliderView.setDescription("Smartphone show");
                    //sliderView.setImageUrl("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
                    break;
                case 3:
                    sliderView.setImageDrawable(R.drawable.smartphone_dummy_slider2);
                    sliderView.setDescription("Smartphone show");
                    //sliderView.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;

                case 4:
                    sliderView.setImageDrawable(R.drawable.smartphone_dummy_slider3);
                    sliderView.setDescription("Smartphone show");
                    //sliderView.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;

                case 5:
                    sliderView.setImageDrawable(R.drawable.laptop_dummy_slider1);
                    sliderView.setDescription("Laptop show");
                    //sliderView.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;

                case 6:
                    sliderView.setImageDrawable(R.drawable.laptop_dummy_slider2);
                    sliderView.setDescription("Laptop show");
                    //sliderView.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;

                case 7:
                    sliderView.setImageDrawable(R.drawable.laptop_dummy_slider3);
                    sliderView.setDescription("Laptop show");
                    //sliderView.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;

                case 8:
                    sliderView.setImageDrawable(R.drawable.laptop_dummy_slider4);
                    sliderView.setDescription("Laptop show");
                    //sliderView.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;

                case 9:
                    sliderView.setImageDrawable(R.drawable.tv_dummy_slider1);
                    sliderView.setDescription("TV show");
                    //sliderView.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;

                case 10:
                    sliderView.setImageDrawable(R.drawable.tv_dummy_slider2);
                    sliderView.setDescription("TV show");
                    //sliderView.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            //sliderView.setDescription("setDescription " + (i + 1));
            final int finalI = i;
            sliderView.setOnSliderClickListener(new com.smarteist.autoimageslider.SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(com.smarteist.autoimageslider.SliderView sliderView) {
                    Toast.makeText(DesktopActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            sliderLayout.addSliderView(sliderView);


        }
    }


















}

//copyright to Gazi Monirul Islam (Adib id: 151-15-4716) for diu final year project in BSC in cse
