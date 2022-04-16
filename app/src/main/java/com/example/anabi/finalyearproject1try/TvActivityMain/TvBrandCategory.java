package com.example.anabi.finalyearproject1try.TvActivityMain;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.anabi.finalyearproject1try.LgTv.Lg4kWebView;
import com.example.anabi.finalyearproject1try.LgTv.LgAllTvWebView;
import com.example.anabi.finalyearproject1try.LgTv.LgLedTvWebView;
import com.example.anabi.finalyearproject1try.LgTv.LgOledTvWebView;
import com.example.anabi.finalyearproject1try.LgTv.LgSmartTvWebView;
import com.example.anabi.finalyearproject1try.R;
import com.example.anabi.finalyearproject1try.SamsungTv.SamsungAllTvWebView;
import com.example.anabi.finalyearproject1try.SamsungTv.SamsungFullHdOrHdTvWebView;
import com.example.anabi.finalyearproject1try.SamsungTv.SamsungPremiumUhdTvWebView;
import com.example.anabi.finalyearproject1try.SamsungTv.SamsungQled4kTvWebView;
import com.example.anabi.finalyearproject1try.SamsungTv.SamsungQled8kTvWebView;
import com.example.anabi.finalyearproject1try.SamsungTv.SamsungSmartTvWebView;
import com.example.anabi.finalyearproject1try.SamsungTv.SamsungUhdTvWebView;
import com.example.anabi.finalyearproject1try.SonyTv.Sony4kTvWebView;
import com.example.anabi.finalyearproject1try.SonyTv.Sony8kTvWebView;
import com.example.anabi.finalyearproject1try.SonyTv.SonyAllTvWebView;
import com.example.anabi.finalyearproject1try.SonyTv.SonyHdrTvWebView;
import com.example.anabi.finalyearproject1try.SonyTv.SonyLedTvWebView;
import com.example.anabi.finalyearproject1try.SonyTv.SonyOledTvWebView;
import com.example.anabi.finalyearproject1try.SonyTv.SonySmartTvWebView;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;

public class TvBrandCategory extends AppCompatActivity {

    SliderLayout sliderLayout;

    CardView sony4kTv,sonySmartTv,sonyOledTv,sonyHdrTv,sonyLedTv,sony8kTv,sonyAllTv;
    CardView samsungQled4kTv,samsungQled8kTv,samsungSmartTv,samsungUhdTv,samsungPremiumUhdTv,samsungFullHd_hd_Tv,samsungAllTv;
    CardView lg4kTv,lgOledTv,lgLedTv,lgSmartTv,lgAllTv;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_brand_category);

        sliderLayout = findViewById(R.id.imageSliderTvBrands);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :

        setSliderViews();


        //lg tv

        lg4kTv = (CardView)findViewById(R.id.lg_4k_tv_cardviewId);
        lgSmartTv =(CardView)findViewById(R.id.lg_smart_tv_cardviewId);
        lgLedTv =(CardView)findViewById(R.id.lg_led_tv_cardviewId);
        lgOledTv = (CardView)findViewById(R.id.lg_oled_tv_cardviewId);
        lgAllTv = (CardView)findViewById(R.id.lg_all_tv_cardviewId);




        //sony tv

        sony4kTv = (CardView)findViewById(R.id.tv_sony_4k_cardViewId);
        sonySmartTv =(CardView)findViewById(R.id.tv_sony_smart_cardViewId);
        sonyOledTv =(CardView)findViewById(R.id.tv_sony_oled_cardViewId);
        sonyHdrTv =(CardView)findViewById(R.id.tv_sony_hdr_cardViewId);
        sonyLedTv =(CardView)findViewById(R.id.tv_sony_led_cardViewId);
        sony8kTv =(CardView)findViewById(R.id.tv_sony_8k_cardViewId);
        sonyAllTv =(CardView)findViewById(R.id.tv_sony_all_cardViewId);

        //samsung tv>>

        samsungFullHd_hd_Tv = (CardView)findViewById(R.id.tv_samsung_fhd_hd_cardviewId);

        samsungQled8kTv = (CardView)findViewById(R.id.tv_samsung_qled8k_cardviewId);

        samsungQled4kTv = (CardView)findViewById(R.id.tv_samsung_qled4k_cardviewId);

        samsungSmartTv = (CardView)findViewById(R.id.tv_samsung_smart_cardviewId);

        samsungPremiumUhdTv = (CardView)findViewById(R.id.tv_samsung_premium_uhd_cardviewId);

        samsungAllTv = (CardView)findViewById(R.id.tv_samsung_all_cardviewId);

        samsungUhdTv = (CardView)findViewById(R.id.tv_samsung_uhd_4k_cardviewId);



        vibrator =(Vibrator)getSystemService(VIBRATOR_SERVICE);


        sony4kTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(),Sony4kTvWebView.class);
                startActivity(intent);
            }
        });


        sonySmartTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(),SonySmartTvWebView.class);
                startActivity(intent);
            }
        });


        sonyOledTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(),SonyOledTvWebView.class);
                startActivity(intent);
            }
        });


        sonyHdrTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(),SonyHdrTvWebView.class);
                startActivity(intent);
            }
        });


        sonyLedTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(),SonyLedTvWebView.class);
                startActivity(intent);
            }
        });



        sony8kTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(),Sony8kTvWebView.class);
                startActivity(intent);
            }
        });


        sonyAllTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(),SonyAllTvWebView.class);
                startActivity(intent);
            }
        });


        //samsung tvs


        samsungAllTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);

                Intent intent = new Intent(getApplicationContext(),SamsungAllTvWebView.class);
                startActivity(intent);
            }
        });

        samsungQled4kTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);

                Intent intent = new Intent(getApplicationContext(),SamsungQled4kTvWebView.class);
                startActivity(intent);
            }
        });


        samsungQled8kTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);

                Intent intent = new Intent(getApplicationContext(),SamsungQled8kTvWebView.class);
                startActivity(intent);
            }
        });


        samsungSmartTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);

                Intent intent = new Intent(getApplicationContext(),SamsungSmartTvWebView.class);
                startActivity(intent);
            }
        });


        samsungPremiumUhdTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);

                Intent intent = new Intent(getApplicationContext(),SamsungPremiumUhdTvWebView.class);
                startActivity(intent);
            }
        });

        samsungUhdTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);

                Intent intent = new Intent(getApplicationContext(),SamsungUhdTvWebView.class);
                startActivity(intent);
            }
        });

        samsungFullHd_hd_Tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);

                Intent intent = new Intent(getApplicationContext(),SamsungFullHdOrHdTvWebView.class);
                startActivity(intent);
            }
        });


        //LG tv::::


        lgAllTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(),LgAllTvWebView.class);
                startActivity(intent);
            }
        });

        lg4kTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(),Lg4kWebView.class);
                startActivity(intent);
            }
        });


        lgSmartTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(),LgSmartTvWebView.class);
                startActivity(intent);
            }
        });


        lgLedTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(),LgLedTvWebView.class);
                startActivity(intent);
            }
        });


        lgOledTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);
                Intent intent = new Intent(getApplicationContext(),LgOledTvWebView.class);
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
                    Toast.makeText(TvBrandCategory.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            sliderLayout.addSliderView(sliderView);


        }
    }








}
