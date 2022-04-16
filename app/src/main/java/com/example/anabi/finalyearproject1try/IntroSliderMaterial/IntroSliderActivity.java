package com.example.anabi.finalyearproject1try.IntroSliderMaterial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.anabi.finalyearproject1try.FireBaseBackend.registration.LoginActivity;
import com.example.anabi.finalyearproject1try.R;

import java.util.ArrayList;
import java.util.List;

public class IntroSliderActivity extends AppCompatActivity {


    private ViewPager screenPager;
    IntroSliderViewPagerAdapter adapter;
    TabLayout tabIndicator;
    Button btnNext;
    int position = 0;
    Button btnGetStarted;
    Animation btnAnim;
    TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //make this activity full screen

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // when this activity is about to launch we need to check weather it is opened before or not

        if (restorePrefData()){

            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(i);
            finish();

        }



        setContentView(R.layout.activity_intro_slider);

        // Hide action bar

        //getSupportActionBar().hide();

        // ini views

        btnNext = (Button)findViewById(R.id.btn_next);
        btnGetStarted = (Button)findViewById(R.id.btn_get_started);
        tabIndicator = (TabLayout)findViewById(R.id.tab_indicator);
        skip = (TextView)findViewById(R.id.tv_skip);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation_for_intro_slider);




        // fill list screen

        final List<IntroScreenItem> mList = new ArrayList<>();

        mList.add(new IntroScreenItem("Fresh Food","Get Latest Post Latest Websites to view and Help community by posting on blog!",R.drawable.intro_slide_img_1));
        mList.add(new IntroScreenItem("Fast Delivery","Get Latest Post Latest Websites to view and Help community by posting on blog!",R.drawable.intro_slide_img_2));
        mList.add(new IntroScreenItem("Easy Payment","Get Latest Post Latest Websites to view and Help community by posting on blog!",R.drawable.intro_slide_img_3));

        // setup viewpager

        screenPager =(ViewPager)findViewById(R.id.screen_viewpager);
        adapter = new IntroSliderViewPagerAdapter(this,mList);
        screenPager.setAdapter(adapter);

        //setup tablayout with viewpager

        tabIndicator.setupWithViewPager(screenPager);

        // next button click listener

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                position = screenPager.getCurrentItem();

                if(position < mList.size()){

                    position++;
                    screenPager.setCurrentItem(position);

                }

                if(position == mList.size()){ // when we reach last screen

                    loadLastScreen();

                }

            }
        });

        // tablayout add change listener

        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if(tab.getPosition() == mList.size()-1){

                    loadLastScreen();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        // skip Textview onclick

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
            }
        });



        // Get started button click listener

        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);

                // also need to save boolean value to storage to not to see it again and again

                savePrefData();
                finish();

            }
        });



    }

    private boolean restorePrefData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpenedBefore = pref.getBoolean("isIntroOpened",false);

        return isIntroActivityOpenedBefore;

    }


    private void loadLastScreen() {

        btnNext.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);

        // let's create the buton animation

        btnGetStarted.setAnimation(btnAnim);

    }

    private void savePrefData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);

        SharedPreferences.Editor editor = pref.edit();

        editor.putBoolean("isIntroOpened",true);
        editor.commit();

    }


}
