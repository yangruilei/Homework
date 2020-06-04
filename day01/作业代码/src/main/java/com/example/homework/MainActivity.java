package com.example.homework;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.homework.adapter.MainPageAdapter;
import com.example.homework.base.BaseActivity;
import com.example.homework.base.BasePre;
import com.example.homework.fragment.ContactPersonFragment;
import com.example.homework.fragment.DynamicStateFragment;
import com.example.homework.fragment.NewsFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private Toolbar mToolMain;
    private ViewPager mVpMain;
    private TabLayout mTabMain;
    private LinearLayout mLinear;
    private NavigationView mNavigation;
    private DrawerLayout mDrawer;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> tabs;
    private ImageView mBarImgMain;
    private TextView mBarTextMain;
    private TextView mBarRightMain;
    private ArrayList<Integer> images;

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    private void initTabs() {
        tabs = new ArrayList<>();
        tabs.add("消息");
        tabs.add("联系人");
        tabs.add("动态");

    }

    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new NewsFragment());
        fragments.add(new ContactPersonFragment());
        fragments.add(new DynamicStateFragment());

    }

    protected void initView() {
        mBarImgMain = (ImageView) findViewById(R.id.main_bar_img);
        mBarTextMain = (TextView) findViewById(R.id.main_bar_text);
        mBarRightMain = (TextView) findViewById(R.id.main_bar_right);
        mToolMain = (Toolbar) findViewById(R.id.main_tool);
        mVpMain = (ViewPager) findViewById(R.id.main_vp);
        mTabMain = (TabLayout) findViewById(R.id.main_tab);
        mLinear = (LinearLayout) findViewById(R.id.linear);
        mNavigation = (NavigationView) findViewById(R.id.navigation);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer);
        initFragments();
        initTabs();
        initImages();
        setSupportActionBar(mToolMain);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, mToolMain, R.string.open, R.string.close);
        mDrawer.addDrawerListener(actionBarDrawerToggle);
        mNavigation.setItemIconTintList(null);

        MainPageAdapter adapter = new MainPageAdapter(getSupportFragmentManager(), fragments, tabs);
        mVpMain.setAdapter(adapter);
        mTabMain.setupWithViewPager(mVpMain);
        for (int i = 0; i < tabs.size(); i++) {
            TabLayout.Tab tab = mTabMain.getTabAt(i);
            tab.setCustomView(getTabView(i));
        }
        mVpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 0) {
                    mBarTextMain.setText("消息");
                    mBarRightMain.setText("＋");
                } else if (position == 1) {
                    mBarTextMain.setText("联系人");
                    mBarRightMain.setText("添加");
                } else {
                    mBarTextMain.setText("动态");
                    mBarRightMain.setText("更多");
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mDrawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                int right = mNavigation.getRight();
                mLinear.setX(right);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });



    }

    private View getTabView(int i) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.tab, null);
        TextView textViewv = inflate.findViewById(R.id.tv);
        ImageView imageView = inflate.findViewById(R.id.iv);
        textViewv.setText(tabs.get(i));
        imageView.setImageResource(images.get(i));
        return inflate;
    }

    private void initImages() {
        images = new ArrayList<>();
        images.add(R.drawable.newsselect);
        images.add(R.drawable.contactselect);
        images.add(R.drawable.dynamicselect);
    }

    @Override
    protected BasePre initPre() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showToast(String msg) {

    }
}
