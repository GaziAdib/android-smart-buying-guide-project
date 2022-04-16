package com.example.anabi.finalyearproject1try.DesktopRamActivity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;



public class DesktopRamViewPagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public DesktopRamViewPagerAdapter(FragmentManager fm,int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){

            case 0:
                DesktopRamTechTab desktopRamTechTab = new DesktopRamTechTab();
                return desktopRamTechTab;

            case 1:
                DesktopRamCorsairTab desktopRamCorsairTab = new DesktopRamCorsairTab();
                return desktopRamCorsairTab;

            case 2:
                DesktopRamGskillTab desktopRamGskillTab = new DesktopRamGskillTab();
                return desktopRamGskillTab;

            case 3:
                DesktopRamTranscendTab desktopRamTranscendTab = new DesktopRamTranscendTab();
                return desktopRamTranscendTab;


        }
        return null;
    }


    @Override
    public int getCount() {
        return mNoOfTabs;
    }

}
