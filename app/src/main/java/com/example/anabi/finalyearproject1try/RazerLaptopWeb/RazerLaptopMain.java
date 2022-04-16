package com.example.anabi.finalyearproject1try.RazerLaptopWeb;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.anabi.finalyearproject1try.R;

public class RazerLaptopMain extends AppCompatActivity implements RazerBladeSeries.OnFragmentInteractionListener,RazerStealthSeries.OnFragmentInteractionListener,RazerProSeries.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razer_laptop_main);


        TabLayout tab = (TabLayout)findViewById(R.id.tab_id);
        tab.addTab(tab.newTab().setText("Razer Blade"));
        tab.addTab(tab.newTab().setText("Razer Stealth"));
        tab.addTab(tab.newTab().setText("Razer Pro"));


        final ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager_id);
        RazerLaptopViewPagerAdapter adapter = new RazerLaptopViewPagerAdapter(getSupportFragmentManager(),tab.getTabCount());
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
