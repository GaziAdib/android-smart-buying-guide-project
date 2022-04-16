package com.example.anabi.finalyearproject1try.AcerLaptopWeb;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class AcerLaptopViewPagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;
    public AcerLaptopViewPagerAdapter(FragmentManager fm,int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){

            case 0:
                AcerAllLaptop acerAllLaptop = new AcerAllLaptop();
                return acerAllLaptop;

            case 1:
                AcerClassicLaptop acerClassicLaptop= new AcerClassicLaptop();
                return acerClassicLaptop;

            case 2:
                AcerUltraThinLaptop acerUltraThinLaptop = new AcerUltraThinLaptop();
                return acerUltraThinLaptop;

            case 3:
                AcerGamingLaptop acerGamingLaptop  = new AcerGamingLaptop();
                return acerGamingLaptop;

            case 4:
                AcerChromeBookLaptop acerChromeBookLaptop = new AcerChromeBookLaptop();
                return acerChromeBookLaptop;

            case 5:
                AcerDetachableLaptop acerDetachableLaptop = new AcerDetachableLaptop();
                return acerDetachableLaptop;

            case 6:
                AcerConvertibleLaptop acerConvertibleLaptop = new AcerConvertibleLaptop();
                return acerConvertibleLaptop;


        }


        return null;
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
