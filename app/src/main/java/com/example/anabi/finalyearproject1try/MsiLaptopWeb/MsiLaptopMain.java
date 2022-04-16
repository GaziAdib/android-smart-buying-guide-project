package com.example.anabi.finalyearproject1try.MsiLaptopWeb;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.anabi.finalyearproject1try.R;

public class MsiLaptopMain extends AppCompatActivity implements MsiGTseries.OnFragmentInteractionListener,
MsiGSseries.OnFragmentInteractionListener,MsiGEseries.OnFragmentInteractionListener,MsiGPseries.OnFragmentInteractionListener,
MsiGLseries.OnFragmentInteractionListener,MsiGFseries.OnFragmentInteractionListener,MsiGVseries.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msi_laptop_main);

        TabLayout tab = (TabLayout)findViewById(R.id.tab_id);
        tab.addTab(tab.newTab().setText("GT Series"));
        tab.addTab(tab.newTab().setText("GS Series"));
        tab.addTab(tab.newTab().setText("GE series"));
        tab.addTab(tab.newTab().setText("GP series"));
        tab.addTab(tab.newTab().setText("GL series"));
        tab.addTab(tab.newTab().setText("GF series"));
        tab.addTab(tab.newTab().setText("GV series"));


        final ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager_id);
        MsiLaptopViewPagerAdapter adapter = new MsiLaptopViewPagerAdapter(getSupportFragmentManager(),tab.getTabCount());
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
