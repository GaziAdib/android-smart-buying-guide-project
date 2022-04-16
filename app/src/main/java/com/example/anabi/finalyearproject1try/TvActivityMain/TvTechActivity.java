package com.example.anabi.finalyearproject1try.TvActivityMain;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.anabi.finalyearproject1try.R;
import com.example.anabi.finalyearproject1try.TvTechnology.TvBasicsBlog;
import com.example.anabi.finalyearproject1try.TvTechnology.TvConnectivityBlog;
import com.example.anabi.finalyearproject1try.TvTechnology.TvDisplayTypesBlog;
import com.example.anabi.finalyearproject1try.TvTechnology.TvScreenSizeBlog;
import com.example.anabi.finalyearproject1try.TvTechnology.TvSmartTvBlog;
import com.example.anabi.finalyearproject1try.TvTechnology.TvSoundQualityBlog;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;

public class TvTechActivity extends AppCompatActivity {

    SliderLayout sliderLayout;

    CardView tvBasic,tvDisplayType,tvScreenSize,tvSmartTv,tvSoundQuality,tvConnectivity;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_tech);

        sliderLayout = findViewById(R.id.imageSliderTvTech);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :

        setSliderViews();


        tvBasic = (CardView)findViewById(R.id.tv_basic_cardviewId);
        tvDisplayType = (CardView)findViewById(R.id.tv_displayTypes_cardviewId);
        tvScreenSize = (CardView)findViewById(R.id.tv_screenSize_cardviewId);
        tvSmartTv = (CardView)findViewById(R.id.tv_smartTv_cardviewId);
        tvSoundQuality = (CardView)findViewById(R.id.tv_soundQuality_cardviewId);
        tvConnectivity = (CardView)findViewById(R.id.tv_connectivity_cardviewId);


        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);


        tvBasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);

                Intent intent = new Intent(getApplicationContext(),TvBasicsBlog.class);
                startActivity(intent);
            }
        });


        tvDisplayType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);

                Intent intent = new Intent(getApplicationContext(),TvDisplayTypesBlog.class);
                startActivity(intent);
            }
        });


        tvScreenSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);

                Intent intent = new Intent(getApplicationContext(),TvScreenSizeBlog.class);
                startActivity(intent);
            }
        });



        tvSmartTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);

                Intent intent = new Intent(getApplicationContext(),TvSmartTvBlog.class);
                startActivity(intent);
            }
        });



        tvSoundQuality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);

                Intent intent = new Intent(getApplicationContext(),TvSoundQualityBlog.class);
                startActivity(intent);
            }
        });



        tvConnectivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);

                Intent intent = new Intent(getApplicationContext(),TvConnectivityBlog.class);
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
                    Toast.makeText(TvTechActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            sliderLayout.addSliderView(sliderView);


        }
    }




























}
