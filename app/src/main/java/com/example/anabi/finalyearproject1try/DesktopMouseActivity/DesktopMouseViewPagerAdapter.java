package com.example.anabi.finalyearproject1try.DesktopMouseActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class DesktopMouseViewPagerAdapter extends FragmentStatePagerAdapter {


    int mNoOfTabs;

    public DesktopMouseViewPagerAdapter(FragmentManager fm,int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }



    @Override
    public Fragment getItem(int i) {

        switch (i){

            case 0:
                DesktopMouseTechTab desktopMouseTechTab = new DesktopMouseTechTab();
                return desktopMouseTechTab;


            case 1:
                DesktopMouseA4techTab desktopMouseA4techTab = new DesktopMouseA4techTab();
                return desktopMouseA4techTab;

            case 2:
                DesktopMouseLogitechTab desktopMouseLogitechTab = new DesktopMouseLogitechTab();
                return desktopMouseLogitechTab;

            case 3:
                DesktopMouseRazorTab desktopMouseRazorTab= new DesktopMouseRazorTab();
                return desktopMouseRazorTab;

            case 4:
                DesktopMouseCorsairTab desktopMouseCorsairTab = new DesktopMouseCorsairTab();
                return desktopMouseCorsairTab;

            case 5:
                DesktopMouseSteelSeriesTab desktopMouseSteelSeriesTab = new DesktopMouseSteelSeriesTab();
                return desktopMouseSteelSeriesTab;


        }
        return null;
    }


    @Override
    public int getCount() {
        return mNoOfTabs;
    }

}
