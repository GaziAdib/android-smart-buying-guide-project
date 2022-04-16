package com.example.anabi.finalyearproject1try.DellLaptopWeb;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class DellLaptopViewPagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public DellLaptopViewPagerAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){

            case 0:
                DellInspiron dellInspiron = new DellInspiron();
                return dellInspiron;

            case 1:
                DellXPS dellXPS = new DellXPS();
                return dellXPS;

            case 2:
                DellGseries dellGseries = new DellGseries();
                return dellGseries;

            case 3:
                DellAlienwareGaming dellAlienwareGaming = new DellAlienwareGaming();
                return dellAlienwareGaming;

            case 4:
                DellVostro dellVostro = new DellVostro();
                return dellVostro;


            case 5:
                DellPrecision dellPrecision = new DellPrecision();
                return dellPrecision;

            case 6:
                DellLatitude dellLatitude = new DellLatitude();
                return dellLatitude;


        }

        return null;

    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
