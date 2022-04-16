package com.example.anabi.finalyearproject1try.DesktopHddActivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.anabi.finalyearproject1try.R;

public class DesktopHddActivity extends AppCompatActivity implements DesktopHddTechTab.OnFragmentInteractionListener,DesktopHddWdTab.OnFragmentInteractionListener,DesktopHddHitachiTab.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desktop_hdd);

        TabLayout tab = (TabLayout) findViewById(R.id.tab_id);
        tab.addTab(tab.newTab().setText("HDD Technology"));
        tab.addTab(tab.newTab().setText("Western Digital"));
        tab.addTab(tab.newTab().setText("Hitachi"));


        // for image tab.addTab(tab.newTab().setIcon(R.drawable.ic_gamepad));


        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager_id);
        final DesktopHddViewPagerAdapter adapter = new DesktopHddViewPagerAdapter(getSupportFragmentManager(),tab.getTabCount());
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
