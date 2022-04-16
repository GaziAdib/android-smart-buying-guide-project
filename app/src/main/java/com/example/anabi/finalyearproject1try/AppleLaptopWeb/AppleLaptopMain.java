package com.example.anabi.finalyearproject1try.AppleLaptopWeb;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.anabi.finalyearproject1try.R;

public class AppleLaptopMain extends AppCompatActivity implements AppleMacBookProSeries.OnFragmentInteractionListener, AppleMacBookAirSeries.OnFragmentInteractionListener,AppleMacBookSeries.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple_laptop_main);


        TabLayout tab = (TabLayout)findViewById(R.id.tab_id);
        tab.addTab(tab.newTab().setText("Macbook Pro"));
        tab.addTab(tab.newTab().setText("Macbook Air"));
        tab.addTab(tab.newTab().setText("Macbook"));


        final ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager_id);
        AppleLaptopViewPagerAdapter adapter = new AppleLaptopViewPagerAdapter(getSupportFragmentManager(),tab.getTabCount());
        viewPager.setAdapter(adapter);


        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
