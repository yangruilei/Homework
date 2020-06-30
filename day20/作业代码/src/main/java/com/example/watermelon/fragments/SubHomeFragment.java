package com.example.watermelon.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.watermelon.R;

public class SubHomeFragment extends Fragment {
    private LayoutInflater mInflater;
    private ViewGroup mViewGroup;
    private int mType;

    public SubHomeFragment(int type) {
        this.mType = type;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.mInflater = inflater;
        this.mViewGroup = container;
        switch (mType) {
            case 0:
                return getView(R.layout.subfragment_guanzhu);
            case 1:
                return getView(R.layout.subfragment_tuijian);
            case 2:
                return getView(R.layout.subfragment_yingshi);
            case 3:
                return getView(R.layout.subfragment_dianshiju);
            case 4:
                return getView(R.layout.subfragment_movie);
            case 5:
                return getView(R.layout.subfragment_xiaodianying);
            case 6:
                return getView(R.layout.subfragment_youxi);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private View getView(int layoutId) {
        return mInflater.inflate(layoutId, mViewGroup, false);
    }
}
