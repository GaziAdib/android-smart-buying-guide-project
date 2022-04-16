package com.example.anabi.finalyearproject1try.AcerLaptopWeb;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.anabi.finalyearproject1try.R;

public class AcerLaptopMain extends AppCompatActivity implements AcerAllLaptop.OnFragmentInteractionListener,AcerClassicLaptop.OnFragmentInteractionListener,AcerUltraThinLaptop.OnFragmentInteractionListener,
AcerGamingLaptop.OnFragmentInteractionListener,AcerChromeBookLaptop.OnFragmentInteractionListener,AcerDetachableLaptop.OnFragmentInteractionListener,AcerConvertibleLaptop.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acer_laptop_main);

        TabLayout tab = (TabLayout)findViewById(R.id.tab_id);
        tab.addTab(tab.newTab().setText("Acer ALL"));
        tab.addTab(tab.newTab().setText("Acer Classic"));
        tab.addTab(tab.newTab().setText("Acer UltraThin"));
        tab.addTab(tab.newTab().setText("Acer Gaming"));
        tab.addTab(tab.newTab().setText("Acer Chromebook"));
        tab.addTab(tab.newTab().setText("Acer Detachable"));
        tab.addTab(tab.newTab().setText("Acer Convertible"));




        final ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager_id);
        AcerLaptopViewPagerAdapter adapter = new AcerLaptopViewPagerAdapter(getSupportFragmentManager(),tab.getTabCount());
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
