package com.example.anabi.finalyearproject1try.DesktopKeyboardActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;



public class DesktopKeyboardViewPagerAdapter extends FragmentStatePagerAdapter {


    int mNoOfTabs;

    public DesktopKeyboardViewPagerAdapter(FragmentManager fm,int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){

            case 0:
                DesktopKeyboardTechTab desktopKeyboardTechTab = new DesktopKeyboardTechTab();
                return desktopKeyboardTechTab;

            case 1:
                DesktopKeyboardA4TechTab desktopKeyboardA4TechTab = new DesktopKeyboardA4TechTab();
                return desktopKeyboardA4TechTab;

            case 2:
                DesktopKeyboardLogitechTab desktopKeyboardLogitechTab = new DesktopKeyboardLogitechTab();
                return desktopKeyboardLogitechTab;

            case 3:
                DesktopKeyboardCorsairTab desktopKeyboardCorsairTab = new DesktopKeyboardCorsairTab();
                return desktopKeyboardCorsairTab;


        }
        return null;
    }


    @Override
    public int getCount() {
        return mNoOfTabs;
    }

}
