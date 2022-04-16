package com.example.anabi.finalyearproject1try.SmartphoneOnePlusWebTabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class OnePlusSmartphoneWebTabViewPagerAdapter extends FragmentStatePagerAdapter {


    int mNumberOfTabs;

    public OnePlusSmartphoneWebTabViewPagerAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNumberOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){

            case 0:
                OnePlusSmartphoneWebFragmentOne fragOne = new OnePlusSmartphoneWebFragmentOne();
                return fragOne;

            case 1:
                OnePlusSmartphoneWebFragmentTwo fragTwo = new OnePlusSmartphoneWebFragmentTwo();
                return fragTwo;

            case 2:
                OnePlusSmartphoneWebFragmentThree fragThree = new OnePlusSmartphoneWebFragmentThree();
                return fragThree;
        }



        return null;
    }

    @Override
    public int getCount() {
        return mNumberOfTabs;
    }




}
