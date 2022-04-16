package com.example.anabi.finalyearproject1try.SmartphoneHuaweiWebTabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class HuaweiSmartphoneWebTabViewPagerAdapter extends FragmentStatePagerAdapter {


    int mNumberOfTabs;
    public HuaweiSmartphoneWebTabViewPagerAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNumberOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){

            case 0:
                HuaweiSmartphoneWebFragmentOne fragOne = new HuaweiSmartphoneWebFragmentOne();
                return fragOne;

            case 1:
                HuaweiSmartphoneWebFragmentTwo fragTwo = new HuaweiSmartphoneWebFragmentTwo();
                return fragTwo;

            case 2:
                HuaweiSmartphoneWebFragmentThree fragThree = new HuaweiSmartphoneWebFragmentThree();
                return fragThree;
        }



        return null;
    }

    @Override
    public int getCount() {
        return mNumberOfTabs;
    }



}
