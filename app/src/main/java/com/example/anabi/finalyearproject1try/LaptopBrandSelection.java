package com.example.anabi.finalyearproject1try;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.anabi.finalyearproject1try.AcerLaptopWeb.AcerLaptopMain;
import com.example.anabi.finalyearproject1try.AppleLaptopWeb.AppleLaptopMain;
import com.example.anabi.finalyearproject1try.AsusLaptopWeb.AsusLaptopMain;
import com.example.anabi.finalyearproject1try.DellLaptopWeb.DellLaptopMain;
import com.example.anabi.finalyearproject1try.HpLaptopWeb.HpLaptopMain;
import com.example.anabi.finalyearproject1try.MsiLaptopWeb.MsiLaptopMain;
import com.example.anabi.finalyearproject1try.RazerLaptopWeb.RazerLaptopMain;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;

public class LaptopBrandSelection extends AppCompatActivity {

    SliderLayout sliderLayout;

    private CardView appleCardView,razerCardView,acerCardView,asusCardView,msiCardView,dellCardView,hpCardView;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop_brand_selection);

        sliderLayout = findViewById(R.id.imageSliderLaptopBrands);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :

        setSliderViews();

        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        appleCardView = (CardView)findViewById(R.id.appleLaptopCardViewId);
        acerCardView = (CardView)findViewById(R.id.acerLaptopCardViewId);
        razerCardView = (CardView)findViewById(R.id.razorLaptopCardViewId);
        asusCardView = (CardView)findViewById(R.id.asusLaptopCardViewId);
        msiCardView  = (CardView)findViewById(R.id.msiLaptopCardViewId);
        dellCardView = (CardView)findViewById(R.id.dellLaptopCardViewId);
        hpCardView = (CardView)findViewById(R.id.hpLaptopCardViewId);


        appleCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);

                Intent intent = new Intent(getApplicationContext(),AppleLaptopMain.class);
                startActivity(intent);
            }
        });


        acerCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);

                Intent intent = new Intent(getApplicationContext(),AcerLaptopMain.class);
                startActivity(intent);
            }
        });


        razerCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);

                Intent intent = new Intent(getApplicationContext(),RazerLaptopMain.class);
                startActivity(intent);
            }
        });


        asusCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(50);

                Intent intent = new Intent(getApplicationContext(),AsusLaptopMain.class);
                startActivity(intent);
            }
        });



        msiCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(),MsiLaptopMain.class);
                startActivity(intent);


            }
        });

        dellCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(),DellLaptopMain.class);
                startActivity(intent);

            }
        });

        hpCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(),HpLaptopMain.class);
                startActivity(intent);
            }
        });



    }




    //slider
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
                    Toast.makeText(LaptopBrandSelection.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            sliderLayout.addSliderView(sliderView);


        }
    }













}
