package com.example.anabi.finalyearproject1try.DesktopProcessorTabActivity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
public class DesktopProcessorViewPagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public DesktopProcessorViewPagerAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int i) {

        switch (i){

            case 0:
                DesktopProcessorTechTab techTab = new DesktopProcessorTechTab();
                return techTab;

            case 1:
                DesktopProcessorIntelTab intelTab = new DesktopProcessorIntelTab();
                return intelTab;

            case 2:
                DesktopProcessorAmdTab amdTab = new DesktopProcessorAmdTab();
                return amdTab;


        }
        return null;
    }


    @Override
    public int getCount() {
        return mNoOfTabs;
    }

}
