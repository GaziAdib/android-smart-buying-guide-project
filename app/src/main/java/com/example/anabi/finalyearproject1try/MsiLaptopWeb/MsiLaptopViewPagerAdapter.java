package com.example.anabi.finalyearproject1try.MsiLaptopWeb;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MsiLaptopViewPagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public MsiLaptopViewPagerAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){

            case 0:
               MsiGTseries msiGTseries = new MsiGTseries();
                return msiGTseries;

            case 1:
                MsiGSseries msiGSseries = new MsiGSseries();
                return msiGSseries;

            case 2:
                MsiGEseries msiGEseries= new MsiGEseries();
                return msiGEseries;

            case 3:
                MsiGPseries msiGPseries = new MsiGPseries();
                return msiGPseries;

            case 4:
                MsiGLseries msiGLseries = new MsiGLseries();
                return msiGLseries;

            case 5:
                MsiGFseries msiGFseries = new MsiGFseries();
                return msiGFseries;

            case 6:
                MsiGVseries msiGVseries = new MsiGVseries();
                return msiGVseries;


        }


        return null;
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
