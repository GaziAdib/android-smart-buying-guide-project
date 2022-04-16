package com.example.anabi.finalyearproject1try.DellLaptopWeb;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.anabi.finalyearproject1try.R;

public class DellLaptopMain extends AppCompatActivity implements DellInspiron.OnFragmentInteractionListener,DellXPS.OnFragmentInteractionListener,
DellGseries.OnFragmentInteractionListener,DellAlienwareGaming.OnFragmentInteractionListener,DellVostro.OnFragmentInteractionListener,DellPrecision.OnFragmentInteractionListener,
DellLatitude.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dell_laptop_main);

        TabLayout tab = (TabLayout)findViewById(R.id.tab_id);
        tab.addTab(tab.newTab().setText("Inspiron"));
        tab.addTab(tab.newTab().setText("XPS"));
        tab.addTab(tab.newTab().setText("G-Series"));
        tab.addTab(tab.newTab().setText("Alienware"));
        tab.addTab(tab.newTab().setText("Vostro"));
        tab.addTab(tab.newTab().setText("Precision"));
        tab.addTab(tab.newTab().setText("Dell Latitude"));


        final ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager_id);
        DellLaptopViewPagerAdapter adapter = new DellLaptopViewPagerAdapter(getSupportFragmentManager(),tab.getTabCount());
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
