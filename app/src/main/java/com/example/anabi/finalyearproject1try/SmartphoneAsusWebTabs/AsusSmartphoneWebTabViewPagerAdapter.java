package com.example.anabi.finalyearproject1try.SmartphoneAsusWebTabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class AsusSmartphoneWebTabViewPagerAdapter extends FragmentStatePagerAdapter {


    int mNumberOfTabs;
    public AsusSmartphoneWebTabViewPagerAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNumberOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){

            case 0:
                AsusSmartphoneWebFragmentOne fragOne = new AsusSmartphoneWebFragmentOne();
                return fragOne;

            case 1:
                AsusSmartphoneWebFragmentTwo fragTwo = new AsusSmartphoneWebFragmentTwo();
                return fragTwo;

            case 2:
                AsusSmartphoneWebFragmentThree fragThree = new AsusSmartphoneWebFragmentThree();
                return fragThree;
        }



        return null;
    }

    @Override
    public int getCount() {
        return mNumberOfTabs;
    }



}
