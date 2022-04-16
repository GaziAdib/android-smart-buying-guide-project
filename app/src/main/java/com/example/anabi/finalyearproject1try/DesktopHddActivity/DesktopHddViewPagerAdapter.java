package com.example.anabi.finalyearproject1try.DesktopHddActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;



public class DesktopHddViewPagerAdapter extends FragmentStatePagerAdapter {


    int mNoOfTabs;

    public DesktopHddViewPagerAdapter(FragmentManager fm,int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){

            case 0:
                DesktopHddTechTab desktopHddTechTab = new DesktopHddTechTab();
                return desktopHddTechTab;

            case 1:
                DesktopHddWdTab desktopHddWdTab = new DesktopHddWdTab();
                return desktopHddWdTab;

            case 2:
                DesktopHddHitachiTab desktopHddHitachiTab = new DesktopHddHitachiTab();
                return desktopHddHitachiTab;




        }
        return null;
    }


    @Override
    public int getCount() {
        return mNoOfTabs;
    }

}
