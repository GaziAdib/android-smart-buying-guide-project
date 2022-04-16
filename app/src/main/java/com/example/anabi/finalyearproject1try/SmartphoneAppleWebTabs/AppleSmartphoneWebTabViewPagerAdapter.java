package com.example.anabi.finalyearproject1try.SmartphoneAppleWebTabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;



public class AppleSmartphoneWebTabViewPagerAdapter extends FragmentStatePagerAdapter {

    int mNumberOfTabs;

    public AppleSmartphoneWebTabViewPagerAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNumberOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){

            case 0:
                AppleSmartphoneWebFragmentOne fragOne = new AppleSmartphoneWebFragmentOne();
                return fragOne;

            case 1:
                AppleSmartphoneWebFragmentTwo fragTwo = new AppleSmartphoneWebFragmentTwo();
                return fragTwo;

            case 2:
                AppleSmartphoneWebFragmentThree fragThree = new AppleSmartphoneWebFragmentThree();
                return fragThree;
        }



        return null;
    }

    @Override
    public int getCount() {
        return mNumberOfTabs;
    }




}
