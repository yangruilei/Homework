package com.example.huadongchongtu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

public class OneFragment extends Fragment {
    private TabLayout mTabTop;
    private FragmentTransaction fragmentTransaction;
    private FourFragment fourFragment;
    private FiveFragment fiveFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_one, container, false);
        initView(inflate);

        return inflate;
    }

    private void initView(@NonNull final View itemView) {
        mTabTop = (TabLayout) itemView.findViewById(R.id.top_tab);
        mTabTop.addTab(mTabTop.newTab().setText("Fragment4"));
        mTabTop.addTab(mTabTop.newTab().setText("Fragment5"));
        initFragments();
        initTab();
    }

    private void initTab() {
        mTabTop.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                switch (position){
                    case 0:
                        fragmentTransaction.show(fourFragment)
                                .hide(fiveFragment)
                                .commit();
                        break;
                    case 1:
                        fragmentTransaction.show(fiveFragment)
                                .hide(fourFragment)
                                .commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initFragments() {
        fourFragment = new FourFragment();
        fiveFragment = new FiveFragment();
        fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl,fourFragment)
                .add(R.id.fl,fiveFragment)
                .hide(fiveFragment)
                .commit();
    }
}
