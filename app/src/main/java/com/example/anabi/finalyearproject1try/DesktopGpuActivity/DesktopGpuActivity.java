package com.example.anabi.finalyearproject1try.DesktopGpuActivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.anabi.finalyearproject1try.R;

public class DesktopGpuActivity extends AppCompatActivity implements DesktopGpuTechTab.OnFragmentInteractionListener,DesktopGpuNvidiaTab.OnFragmentInteractionListener,DesktopGpuAmdTab.OnFragmentInteractionListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desktop_gpu);


        TabLayout tab = (TabLayout) findViewById(R.id.tab_id);
        tab.addTab(tab.newTab().setText("Gpu Technology"));
        tab.addTab(tab.newTab().setText("Nvidia"));
        tab.addTab(tab.newTab().setText("AMD"));


        // for image tab.addTab(tab.newTab().setIcon(R.drawable.ic_gamepad));


        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager_id);
        final DesktopGpuViewPagerAdapter adapter = new DesktopGpuViewPagerAdapter(getSupportFragmentManager(),tab.getTabCount());
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
