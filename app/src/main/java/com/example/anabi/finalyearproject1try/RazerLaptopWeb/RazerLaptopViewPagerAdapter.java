package com.example.anabi.finalyearproject1try.RazerLaptopWeb;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class RazerLaptopViewPagerAdapter extends FragmentStatePagerAdapter {

    int mNumberOfTabs;

    public RazerLaptopViewPagerAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNumberOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {


        switch (i){

            case 0:
                RazerBladeSeries razerBladeSeries = new RazerBladeSeries();
                return razerBladeSeries;

            case 1:
                RazerStealthSeries razerStealthSeries= new RazerStealthSeries();
                return razerStealthSeries;

            case 2:
                RazerProSeries razerProSeries = new RazerProSeries();
                return razerProSeries;

        }

        return null;
    }

    @Override
    public int getCount() {
        return mNumberOfTabs;
    }
}
