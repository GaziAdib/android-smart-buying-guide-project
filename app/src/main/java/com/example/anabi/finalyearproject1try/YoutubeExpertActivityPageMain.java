package com.example.anabi.finalyearproject1try;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.anabi.finalyearproject1try.YoutubeExperReviewDesktopThree.ExpertDesktopThreeMain;
import com.example.anabi.finalyearproject1try.YoutubeExpertReviewDesktopFive.ExpertDesktopFiveMain;
import com.example.anabi.finalyearproject1try.YoutubeExpertReviewDesktopFour.ExpertDesktopFourMain;
import com.example.anabi.finalyearproject1try.YoutubeExpertReviewDesktopOne.ExpertDesktopOneMain;
import com.example.anabi.finalyearproject1try.YoutubeExpertReviewDesktopSix.ExpertDesktopSixMain;
import com.example.anabi.finalyearproject1try.YoutubeExpertReviewDesktopTwo.ExpertDesktopTwoMain;
import com.example.anabi.finalyearproject1try.YoutubeExpertReviewLaptopFour.ExpertLaptopFourMain;
import com.example.anabi.finalyearproject1try.YoutubeExpertReviewLaptopOne.ExpertLaptopOneMain;
import com.example.anabi.finalyearproject1try.YoutubeExpertReviewLaptopThree.ExpertLaptopThreeMain;
import com.example.anabi.finalyearproject1try.YoutubeExpertReviewLaptopTwo.ExpertLaptopTwoMain;
import com.example.anabi.finalyearproject1try.YoutubeExpertReviewSmartphoneFour.ExpertSmartphoneFourMain;
import com.example.anabi.finalyearproject1try.YoutubeExpertReviewSmartphoneOne.ExpertSmartphoneOneMain;
import com.example.anabi.finalyearproject1try.YoutubeExpertReviewSmartphoneThree.ExpertSmartphoneThreeMain;
import com.example.anabi.finalyearproject1try.YoutubeExpertReviewSmartphoneTwo.ExpertSmartphoneTwoMain;
import com.example.anabi.finalyearproject1try.YoutubeExpertReviewTvFour.ExpertTvFourMain;
import com.example.anabi.finalyearproject1try.YoutubeExpertReviewTvOne.ExpertTvOneMain;
import com.example.anabi.finalyearproject1try.YoutubeExpertReviewTvThree.ExpertTvThreeMain;
import com.example.anabi.finalyearproject1try.YoutubeExpertReviewTvTwo.ExpertTvTwoMain;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;

//import com.example.anabi.finalyearproject1try.YoutubeExpertReviewSmartphoneOne.ExpertSmartphoneChannelOneMainActivity;

public class YoutubeExpertActivityPageMain extends AppCompatActivity {

    private SliderLayout sliderLayout;
    private CardView expertSmartChannel1,expertSmartChannel2,expertSmartChannel3,expertSmartChannel4;
    private CardView expertDesktopChannel1,expertDesktopChannel2, expertDesktopChannel3, expertDesktopChannel4, expertDesktopChannel5, expertDesktopChannel6,
    expertLaptopChannel1,expertLaptopChannel2,expertLaptopChannel3,expertLaptopChannel4;
    private CardView expertTvChannel1, expertTvChannel2, expertTvChannel3, expertTvChannel4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_expert_page_main);

        expertSmartChannel1 = (CardView)findViewById(R.id.ExpertReviewSmartphoneChannel1Id);
        expertSmartChannel2 = (CardView)findViewById(R.id.ExpertReviewSmartphoneChannel2Id);
        expertSmartChannel3= (CardView)findViewById(R.id.ExpertReviewSmartphoneChannel3Id);
        expertSmartChannel4 = (CardView)findViewById(R.id.ExpertReviewSmartphoneChannel4Id);

        expertDesktopChannel1 = (CardView)findViewById(R.id.ExpertReviewDesktopChannel1Id);
        expertDesktopChannel2 = (CardView)findViewById(R.id.ExpertReviewDesktopChannel2Id);
        expertDesktopChannel3 = (CardView)findViewById(R.id.ExpertReviewDesktopChannel3Id);
        expertDesktopChannel4 = (CardView)findViewById(R.id.ExpertReviewDesktopChannel4Id);
        expertDesktopChannel5 = (CardView)findViewById(R.id.ExpertReviewDesktopChannel5Id);
        expertDesktopChannel6 = (CardView)findViewById(R.id.ExpertReviewDesktopChannel6Id);


        expertLaptopChannel1 = (CardView)findViewById(R.id.ExpertReviewLaptopChannel1Id);
        expertLaptopChannel2 = (CardView)findViewById(R.id.ExpertReviewLaptopChannel2Id);
        expertLaptopChannel3 = (CardView)findViewById(R.id.ExpertReviewLaptopChannel3Id);
        expertLaptopChannel4 = (CardView)findViewById(R.id.ExpertReviewLaptopChannel4Id);


        expertTvChannel1 = (CardView)findViewById(R.id.expertTvReviewCardOneId);
        expertTvChannel2 = (CardView)findViewById(R.id.expertTvReviewCardTwoId);
        expertTvChannel3 = (CardView)findViewById(R.id.expertTvReviewCardThreeId);
        expertTvChannel4 = (CardView)findViewById(R.id.expertTvReviewCardFourId);




        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :

        setSliderViews();

        expertSmartChannel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ExpertSmartphoneOneMain.class);
                startActivity(intent);

            }
        });

        expertSmartChannel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ExpertSmartphoneTwoMain.class);
                startActivity(intent);

            }
        });

        expertSmartChannel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ExpertSmartphoneThreeMain.class);
                startActivity(intent);

            }
        });

        expertSmartChannel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ExpertSmartphoneFourMain.class);
                startActivity(intent);

            }
        });





        expertDesktopChannel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ExpertDesktopOneMain.class);
                startActivity(intent);

            }
        });

        expertDesktopChannel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ExpertDesktopTwoMain.class);
                startActivity(intent);

            }
        });

        expertDesktopChannel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ExpertDesktopThreeMain.class);
                startActivity(intent);

            }
        });

        expertDesktopChannel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ExpertDesktopFourMain.class);
                startActivity(intent);

            }
        });

        expertDesktopChannel5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ExpertDesktopFiveMain.class);
                startActivity(intent);

            }
        });

        expertDesktopChannel6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ExpertDesktopSixMain.class);
                startActivity(intent);

            }
        });



        expertLaptopChannel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ExpertLaptopOneMain.class);
                startActivity(intent);

            }
        });

        expertLaptopChannel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ExpertLaptopTwoMain.class);
                startActivity(intent);

            }
        });

        expertLaptopChannel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ExpertLaptopThreeMain.class);
                startActivity(intent);

            }
        });

        expertLaptopChannel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ExpertLaptopFourMain.class);
                startActivity(intent);

            }
        });



        expertTvChannel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ExpertTvOneMain.class);
                startActivity(intent);

            }
        });


        expertTvChannel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ExpertTvTwoMain.class);
                startActivity(intent);

            }
        });

        expertTvChannel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ExpertTvThreeMain.class);
                startActivity(intent);

            }
        });

        expertTvChannel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ExpertTvFourMain.class);
                startActivity(intent);

            }
        });




    }






    private void setSliderViews() {

        for (int i = 0; i <= 10; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(getApplicationContext());

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
                    Toast.makeText(getApplicationContext(), "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            sliderLayout.addSliderView(sliderView);


        }
    }











}
