package com.example.watermelon.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.watermelon.fragments.SubHomeFragment;

import java.util.List;

public class HFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTabs;
    private List<SubHomeFragment> list;

    public HFragmentPagerAdapter
            (@NonNull FragmentManager fm, String[] mTabs,
             List<SubHomeFragment> fragments) {
        super(fm);
        this.mTabs = mTabs;
        this.list = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabs[position];
    }
}
