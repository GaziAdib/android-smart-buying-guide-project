package com.example.anabi.finalyearproject1try.DesktopMoboTabActivity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;



public class DesktopMoboViewPagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public DesktopMoboViewPagerAdapter(FragmentManager fm,int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){

            case 0:
                DesktopMoboTechTab moboTechTab = new DesktopMoboTechTab();
                return moboTechTab;

            case 1:
                DesktopMoboAsusTab moboAsusTab = new DesktopMoboAsusTab();
                return moboAsusTab;

            case 2:
                DesktopMoboGigabyteTab moboGigabyteTab = new DesktopMoboGigabyteTab();
                return moboGigabyteTab;

            case 3:
                DesktopMoboMsiTab moboMsiTab = new DesktopMoboMsiTab();
                return moboMsiTab;


        }
        return null;
    }


    @Override
    public int getCount() {
        return mNoOfTabs;
    }

}
