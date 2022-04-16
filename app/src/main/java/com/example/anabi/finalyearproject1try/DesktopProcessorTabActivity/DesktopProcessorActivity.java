package com.example.anabi.finalyearproject1try.DesktopProcessorTabActivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.anabi.finalyearproject1try.R;

public class DesktopProcessorActivity extends AppCompatActivity implements DesktopProcessorTechTab.OnFragmentInteractionListener,DesktopProcessorIntelTab.OnFragmentInteractionListener,DesktopProcessorAmdTab.OnFragmentInteractionListener {

    //Toolbar toolbar;
    //TabLayout tabLayout;
    //ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desktop_processor);

        TabLayout tab = (TabLayout) findViewById(R.id.tab_id);
        tab.addTab(tab.newTab().setText("Techhnologies"));
        tab.addTab(tab.newTab().setText("Intel"));
        tab.addTab(tab.newTab().setText("AMD"));

       // for image tab.addTab(tab.newTab().setIcon(R.drawable.ic_gamepad));


        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager_id);
        final DesktopProcessorViewPagerAdapter adapter = new DesktopProcessorViewPagerAdapter(getSupportFragmentManager(),tab.getTabCount());
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
