package com.example.anabi.finalyearproject1try.SmartphoneXiomiWebTabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class XiomiSmartphoneWebTabViewPagerAdapter  extends FragmentStatePagerAdapter {



    int mNumberOfTabs;

    public XiomiSmartphoneWebTabViewPagerAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNumberOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){

            case 0:
                XiomiSmartphoneWebFragmentOne fragOne = new XiomiSmartphoneWebFragmentOne();
                return fragOne;

            case 1:
                XiomiSmartphoneWebFragmentTwo fragTwo = new XiomiSmartphoneWebFragmentTwo();
                return fragTwo;

            case 2:
                XiomiSmartphoneWebFragmentThree fragThree = new XiomiSmartphoneWebFragmentThree();
                return fragThree;
        }



        return null;
    }

    @Override
    public int getCount() {
        return mNumberOfTabs;
    }





}
