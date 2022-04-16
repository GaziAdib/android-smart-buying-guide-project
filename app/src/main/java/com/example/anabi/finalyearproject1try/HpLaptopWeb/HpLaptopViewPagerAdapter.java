package com.example.anabi.finalyearproject1try.HpLaptopWeb;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class HpLaptopViewPagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public HpLaptopViewPagerAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {


        switch (i){

            case 0:
                HpEnvy hpEnvy = new HpEnvy();
                return hpEnvy;

            case 1:
                HpPavillion hpPavillion = new HpPavillion();
                return hpPavillion;

            case 2:
                HpElitBook hpElitBook = new HpElitBook();
                return hpElitBook;

            case 3:
                HpOmen hpOmen = new HpOmen();
                return hpOmen;

            case 4:
                HpProBook hpProBook = new HpProBook();
                return hpProBook;

            case 5:
                HpChromeBook hpChromeBook = new HpChromeBook();
                return hpChromeBook;

            case 6:
                HpEssential hpEssential = new HpEssential();
                return hpEssential;

            case 7:
                HpMobileThinClient hpMobileThinClient = new HpMobileThinClient();
                return hpMobileThinClient;

            case 8:
                HpSpectre hpSpectre = new HpSpectre();
                return hpSpectre;

            case 9:
                HpStream hpStream = new HpStream();
                return hpStream;

            case 10:
                HpZBook hpZBook = new HpZBook();
                return hpZBook;

            case 11:
                HpElit hpElit = new HpElit();
                return hpElit;



        }


        return null;
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
