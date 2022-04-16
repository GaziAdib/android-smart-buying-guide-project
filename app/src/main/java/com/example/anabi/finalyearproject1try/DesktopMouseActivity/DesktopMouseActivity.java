package com.example.anabi.finalyearproject1try.DesktopMouseActivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.anabi.finalyearproject1try.R;

public class DesktopMouseActivity extends AppCompatActivity implements DesktopMouseTechTab.OnFragmentInteractionListener,DesktopMouseA4techTab.OnFragmentInteractionListener,DesktopMouseLogitechTab.OnFragmentInteractionListener,DesktopMouseRazorTab.OnFragmentInteractionListener,DesktopMouseCorsairTab.OnFragmentInteractionListener,DesktopMouseSteelSeriesTab.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desktop_mouse);

        TabLayout tab = (TabLayout) findViewById(R.id.tab_id);
        tab.addTab(tab.newTab().setText("Mouse Technologies"));
        tab.addTab(tab.newTab().setText("A4Tech"));
        tab.addTab(tab.newTab().setText("Logitech"));
        tab.addTab(tab.newTab().setText("Razer"));
        tab.addTab(tab.newTab().setText("Corsair"));
        tab.addTab(tab.newTab().setText("SteelSeries"));

        // for image tab.addTab(tab.newTab().setIcon(R.drawable.ic_gamepad));


        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager_id);
        final DesktopMouseViewPagerAdapter adapter = new DesktopMouseViewPagerAdapter(getSupportFragmentManager(),tab.getTabCount());
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
