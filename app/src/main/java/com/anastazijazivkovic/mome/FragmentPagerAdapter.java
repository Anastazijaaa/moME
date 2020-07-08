package com.anastazijazivkovic.mome;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 2;

    public FragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0: return LoginFragment.newInstance();
            default: return RegisterFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
