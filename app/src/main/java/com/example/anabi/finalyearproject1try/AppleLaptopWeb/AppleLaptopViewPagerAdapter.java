package com.example.anabi.finalyearproject1try.AppleLaptopWeb;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class AppleLaptopViewPagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public AppleLaptopViewPagerAdapter(FragmentManager fm,int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {


        switch (i){

            case 0:
                AppleMacBookProSeries appleMacBookProSeries = new AppleMacBookProSeries();
                return appleMacBookProSeries;

            case 1:
                AppleMacBookAirSeries appleMacBookAirSeries= new AppleMacBookAirSeries();
                return appleMacBookAirSeries;

            case 2:
                AppleMacBookSeries appleMacBookSeries = new AppleMacBookSeries();
                return appleMacBookSeries;


        }

        return null;
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
