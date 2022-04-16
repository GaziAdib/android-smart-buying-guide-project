package com.example.anabi.finalyearproject1try.DesktopMonitorActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;



public class DesktopMonitorViewPagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public DesktopMonitorViewPagerAdapter(FragmentManager fm,int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){

            case 0:
                DesktopMonitorTechTab monitorTechTab = new DesktopMonitorTechTab();
                return monitorTechTab;

            case 1:
                DesktopMonitorAsusTab monitorAsusTab = new DesktopMonitorAsusTab();
                return monitorAsusTab;

            case 2:
                DesktopMonitorLgTab monitorLgTab = new DesktopMonitorLgTab();
                return monitorLgTab;

            case 3:
                DesktopMonitorSamsungTab monitorSamsungTab = new DesktopMonitorSamsungTab();
                return monitorSamsungTab;


        }
        return null;
    }


    @Override
    public int getCount() {
        return mNoOfTabs;
    }

}
