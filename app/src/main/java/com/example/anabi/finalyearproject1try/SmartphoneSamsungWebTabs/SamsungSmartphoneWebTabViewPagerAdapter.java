package com.example.anabi.finalyearproject1try.SmartphoneSamsungWebTabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class SamsungSmartphoneWebTabViewPagerAdapter extends FragmentStatePagerAdapter {

    int mNumberOfTabs;
    public SamsungSmartphoneWebTabViewPagerAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNumberOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){

            case 0:
                SamsungSmartphoneWebTabFragmentOne fragOne = new SamsungSmartphoneWebTabFragmentOne();
                return fragOne;

            case 1:
                SamsungSmartphoneWebTabFragmentTwo fragTwo = new SamsungSmartphoneWebTabFragmentTwo();
                return fragTwo;

            case 2:
                SamsungSmartphoneWebTabFragmentThree fragThree = new SamsungSmartphoneWebTabFragmentThree();
                return fragThree;
        }



        return null;
    }

    @Override
    public int getCount() {
        return mNumberOfTabs;
    }
}
