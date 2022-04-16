package com.example.anabi.finalyearproject1try.DesktopGpuActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;



public class DesktopGpuViewPagerAdapter extends FragmentStatePagerAdapter {


    int mNoOfTabs;
    public DesktopGpuViewPagerAdapter(FragmentManager fm,int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){

            case 0:
                DesktopGpuTechTab desktopGpuTechTab = new DesktopGpuTechTab();
                return desktopGpuTechTab;

            case 1:
                DesktopGpuNvidiaTab desktopGpuNvidiaTab = new DesktopGpuNvidiaTab();
                return desktopGpuNvidiaTab;

            case 2:
                DesktopGpuAmdTab desktopGpuAmdTab = new DesktopGpuAmdTab();
                return desktopGpuAmdTab;


        }
        return null;
    }


    @Override
    public int getCount() {
        return mNoOfTabs;
    }

}
