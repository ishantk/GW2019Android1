package com.auribises.gw2019android1.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.auribises.gw2019android1.AnotherFragment;
import com.auribises.gw2019android1.LowerFragment;
import com.auribises.gw2019android1.R;
import com.auribises.gw2019android1.UpperFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    String[] titles = {"Home", "About", "Contact"};
    private final Context mContext;

    UpperFragment upperFragment;
    LowerFragment lowerFragment;
    AnotherFragment anotherFragment;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;

        upperFragment = new UpperFragment();
        lowerFragment = new LowerFragment();
        anotherFragment = new AnotherFragment();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return upperFragment;
            case 1:
                return lowerFragment;
            case 2:
                return anotherFragment;
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position]; // 0 to 2
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3; // 3 positions : from 0 to 2
    }
}