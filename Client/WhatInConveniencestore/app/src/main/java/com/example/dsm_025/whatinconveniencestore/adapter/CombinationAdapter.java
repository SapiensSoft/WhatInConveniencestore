package com.example.dsm_025.whatinconveniencestore.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dsm_025.whatinconveniencestore.fragment.TabFragment1;
import com.example.dsm_025.whatinconveniencestore.fragment.TabFragment2;

/**
 * Created by dsm_025 on 2017-06-21.
 */

public class CombinationAdapter extends FragmentPagerAdapter {
    int mNumOfTabs;

    public CombinationAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                TabFragment1 tab1 = new TabFragment1();
                return tab1;
            case 1:
                TabFragment2 tab2 = new TabFragment2();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
