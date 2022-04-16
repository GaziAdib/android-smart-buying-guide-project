package com.example.anabi.finalyearproject1try.AsusLaptopWeb;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.anabi.finalyearproject1try.R;

public class AsusLaptopMain extends AppCompatActivity  implements AsusZenBookSeries.OnFragmentInteractionListener,AsusAllSeries.OnFragmentInteractionListener,
AsusVivoBookSeries.OnFragmentInteractionListener,AsusLaptopSeries.OnFragmentInteractionListener,AsusChromeBookSeries.OnFragmentInteractionListener,
AsusProSeries.OnFragmentInteractionListener,AsusGamingSeries.OnFragmentInteractionListener,AsusFxZxSeries.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asus_laptop_main);

        TabLayout tab = (TabLayout)findViewById(R.id.tab_id);
        tab.addTab(tab.newTab().setText("Asus All"));
        tab.addTab(tab.newTab().setText("ZenBook"));
        tab.addTab(tab.newTab().setText("VivoBook"));
        tab.addTab(tab.newTab().setText("Laptop"));
        tab.addTab(tab.newTab().setText("ChromeBook"));
        tab.addTab(tab.newTab().setText("Pro Series"));
        tab.addTab(tab.newTab().setText("Gaming"));
        tab.addTab(tab.newTab().setText("FX/ZX series"));





        final ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager_id);
        AsusLaptopViewPagerAdapter adapter = new AsusLaptopViewPagerAdapter(getSupportFragmentManager(),tab.getTabCount());
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
