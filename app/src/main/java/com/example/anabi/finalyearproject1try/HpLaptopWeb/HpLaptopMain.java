package com.example.anabi.finalyearproject1try.HpLaptopWeb;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.anabi.finalyearproject1try.R;

public class HpLaptopMain extends AppCompatActivity implements HpEnvy.OnFragmentInteractionListener,HpPavillion.OnFragmentInteractionListener,HpElitBook.OnFragmentInteractionListener,
HpOmen.OnFragmentInteractionListener,HpProBook.OnFragmentInteractionListener,HpChromeBook.OnFragmentInteractionListener,HpEssential.OnFragmentInteractionListener,
HpMobileThinClient.OnFragmentInteractionListener,HpSpectre.OnFragmentInteractionListener,HpStream.OnFragmentInteractionListener,HpZBook.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hp_laptop_main);


        TabLayout tab = (TabLayout)findViewById(R.id.tab_id);
        tab.addTab(tab.newTab().setText("HP Envy"));
        tab.addTab(tab.newTab().setText("HP Pavillion"));
        tab.addTab(tab.newTab().setText("HP ElitBook"));
        tab.addTab(tab.newTab().setText("HP OMEN"));
        tab.addTab(tab.newTab().setText("HP ProBook"));
        tab.addTab(tab.newTab().setText("HP ChromeBook"));
        tab.addTab(tab.newTab().setText("HP Essential"));
        tab.addTab(tab.newTab().setText("HP MobileClient"));
        tab.addTab(tab.newTab().setText("HP Spectre"));
        tab.addTab(tab.newTab().setText("HP Stream"));
        tab.addTab(tab.newTab().setText("HP ZBook"));
        tab.addTab(tab.newTab().setText("HP Elit"));




        final ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager_id);
        HpLaptopViewPagerAdapter adapter = new HpLaptopViewPagerAdapter(getSupportFragmentManager(),tab.getTabCount());
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
