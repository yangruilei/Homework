package com.example.watermelon.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.watermelon.R;
import com.example.watermelon.adapter.HFragmentPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements TabLayout.BaseOnTabSelectedListener {
    private TabLayout mTabFragment;
    private ViewPager mVpFrangment;
    private String[] mTabs = {"关注", "推荐", "影视", "电视剧", "电影", "小视频", "游戏"};
    private TextView mTvFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(@NonNull final View itemView) {
        mTabFragment = (TabLayout) itemView.findViewById(R.id.fragment_tab);
        mVpFrangment = (ViewPager) itemView.findViewById(R.id.frangment_vp);
        mTvFragment = (TextView) itemView.findViewById(R.id.fragment_tv);
        setTabTextSize();
        mTabFragment.addOnTabSelectedListener(this);
        List<SubHomeFragment> fragments=getSubFragment();
        HFragmentPagerAdapter adapter = new HFragmentPagerAdapter
                (getChildFragmentManager(), mTabs, fragments);
        mVpFrangment.setAdapter(adapter);
        mTabFragment.setupWithViewPager(mVpFrangment);
        //默认设置第0个tab被选中
        mVpFrangment.setCurrentItem(0);
        mTabFragment.getTabAt(0).select();
    }

    private void setTabTextSize() {
        for (int i = 0; i < mTabFragment.getTabCount(); i++) {
            TabLayout.Tab tab = mTabFragment.getTabAt(i);
            //自定义每个tab标签 然后设置给每个tab
            tab.setCustomView(getTabView(i));
        }
    }

        //自定义每个Tab标签
        private View getTabView(int i) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.tab_layout, null);
            TextView textView = view.findViewById(R.id.tab_tv);
            textView.setText(mTabs[i]);
            return view;
        }


    private List<SubHomeFragment> getSubFragment() {
        List<SubHomeFragment> fragments = new ArrayList<SubHomeFragment>();
        for (int i = 0; i < mTabs.length; i++) {
            fragments.add(new SubHomeFragment(i));
        }
        return fragments;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        View customView = tab.getCustomView();
        if (customView != null && customView instanceof TextView) {
            ((TextView) customView).setTextSize(23);
            ((TextView) customView).setTextColor(Color.RED);
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        View customView = tab.getCustomView();
        if (customView != null && customView instanceof TextView) {
            ((TextView) customView).setTextSize(18);
            ((TextView) customView).setTextColor(Color.BLACK);
        }
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


}
