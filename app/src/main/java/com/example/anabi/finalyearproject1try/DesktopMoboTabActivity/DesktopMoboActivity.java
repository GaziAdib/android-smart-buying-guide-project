package com.example.anabi.finalyearproject1try.DesktopMoboTabActivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.anabi.finalyearproject1try.R;

public class DesktopMoboActivity extends AppCompatActivity implements DesktopMoboTechTab.OnFragmentInteractionListener,DesktopMoboAsusTab.OnFragmentInteractionListener,DesktopMoboGigabyteTab.OnFragmentInteractionListener,DesktopMoboMsiTab.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desktop_mobo);

        TabLayout tab = (TabLayout) findViewById(R.id.tab_id);
        tab.addTab(tab.newTab().setText("Motherboard Techhnologies"));
        tab.addTab(tab.newTab().setText("Asus"));
        tab.addTab(tab.newTab().setText("Gigabyte"));
        tab.addTab(tab.newTab().setText("Msi"));

        // for image tab.addTab(tab.newTab().setIcon(R.drawable.ic_gamepad));


        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager_id);
        final DesktopMoboViewPagerAdapter adapter = new DesktopMoboViewPagerAdapter(getSupportFragmentManager(),tab.getTabCount());
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
