package com.example.anabi.finalyearproject1try.SmartphoneAsusWebTabs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.anabi.finalyearproject1try.R;

public class SmartphoneAsusWebTabMain extends AppCompatActivity implements AsusSmartphoneWebFragmentOne.OnFragmentInteractionListener,
AsusSmartphoneWebFragmentTwo.OnFragmentInteractionListener,AsusSmartphoneWebFragmentThree.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartphone_asus_web_tab_main);


        TabLayout tab = (TabLayout)findViewById(R.id.tab_id);
        tab.addTab(tab.newTab().setText("Asus official"));
        tab.addTab(tab.newTab().setText("Asus Local BD"));
        tab.addTab(tab.newTab().setText("Asus Local IND"));


        final ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager_id);
        AsusSmartphoneWebTabViewPagerAdapter adapter = new AsusSmartphoneWebTabViewPagerAdapter(getSupportFragmentManager(),tab.getTabCount());
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



