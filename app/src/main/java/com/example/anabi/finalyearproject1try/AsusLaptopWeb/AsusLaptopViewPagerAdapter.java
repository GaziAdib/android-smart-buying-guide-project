package com.example.anabi.finalyearproject1try.AsusLaptopWeb;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class AsusLaptopViewPagerAdapter extends FragmentStatePagerAdapter {


    int mNoOfTabs;

    public AsusLaptopViewPagerAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){

            case 0:
                AsusAllSeries asusAllSeries = new AsusAllSeries();
                return asusAllSeries;

            case 1:
                AsusZenBookSeries asusZenBookSeries = new AsusZenBookSeries();
                return asusZenBookSeries;

            case 2:
                AsusVivoBookSeries asusVivoBookSeries = new AsusVivoBookSeries();
                return asusVivoBookSeries;


            case 3:
                AsusLaptopSeries asusLaptopSeries = new AsusLaptopSeries();
                return asusLaptopSeries;

            case 4:
                AsusChromeBookSeries asusChromeBookSeries = new AsusChromeBookSeries();
                return asusChromeBookSeries;

            case 5:
                AsusProSeries asusProSeries = new AsusProSeries();
                return asusProSeries;

            case 6:
                AsusGamingSeries asusGamingSeries = new AsusGamingSeries();
                return asusGamingSeries;

            case 7:
                AsusFxZxSeries asusFxZxSeries = new AsusFxZxSeries();
                return asusFxZxSeries;


        }

        return null;

    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }


}
