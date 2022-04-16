package com.example.anabi.finalyearproject1try.DesktopRamActivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.anabi.finalyearproject1try.R;

public class DesktopRamActivity extends AppCompatActivity implements DesktopRamTechTab.OnFragmentInteractionListener,DesktopRamCorsairTab.OnFragmentInteractionListener,DesktopRamGskillTab.OnFragmentInteractionListener,DesktopRamTranscendTab.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desktop_ram);

        TabLayout tab = (TabLayout) findViewById(R.id.tab_id);
        tab.addTab(tab.newTab().setText("Ram Technologies"));
        tab.addTab(tab.newTab().setText("Corsair"));
        tab.addTab(tab.newTab().setText("Adata"));
        tab.addTab(tab.newTab().setText("Transcend"));

        // for image tab.addTab(tab.newTab().setIcon(R.drawable.ic_gamepad));


        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager_id);
        final DesktopRamViewPagerAdapter adapter = new DesktopRamViewPagerAdapter(getSupportFragmentManager(),tab.getTabCount());
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
