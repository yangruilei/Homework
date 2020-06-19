package com.example.huadongchongtu;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mFrame;
    private TabLayout mTab;
    private OneFragment oneFragment;
    private OneFragment twoFragment;
    private OneFragment threeFragment;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
        initTab();
    }



    private void initTab() {
        mTab.addTab(mTab.newTab().setText("FragmentOne"));
        mTab.addTab(mTab.newTab().setText("FragmentTwo"));
        mTab.addTab(mTab.newTab().setText("FragmentThree"));
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                int position = tab.getPosition();
                switch (position){
                    case 0:
                        transaction.show(oneFragment)
                                .hide(twoFragment)
                                .hide(threeFragment)
                                .commit();
                        break;
                    case 1:
                        transaction.show(twoFragment)
                                .hide(oneFragment)
                                .hide(threeFragment)
                                .commit();
                        break;
                    case 2:
                        transaction.show(threeFragment)
                                .hide(twoFragment)
                                .hide(oneFragment)
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

    private void initFragment() {
        oneFragment = new OneFragment();
        twoFragment = new OneFragment();
        threeFragment = new OneFragment();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame,oneFragment)
                .add(R.id.frame,twoFragment)
                .add(R.id.frame,threeFragment)
                .hide(twoFragment)
                .hide(threeFragment)
                .commit();

    }

    private void initView() {
        mFrame = (FrameLayout) findViewById(R.id.frame);
        mTab = (TabLayout) findViewById(R.id.tab);

    }
}
