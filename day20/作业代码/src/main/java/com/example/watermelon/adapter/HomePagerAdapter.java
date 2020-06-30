package com.example.watermelon.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.watermelon.fragments.HomeFragment;

import java.util.List;

public class HomePagerAdapter extends FragmentPagerAdapter {
    private List<HomeFragment> mList;

    public HomePagerAdapter(@NonNull FragmentManager fm,
                            List<HomeFragment> fragments) {
        super(fm);
        this.mList = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
