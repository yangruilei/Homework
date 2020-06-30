package com.example.watermelon;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.watermelon.adapter.HomePagerAdapter;
import com.example.watermelon.fragments.HomeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVpMain;
    private TabLayout mTabMain;
    private HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initStatusBar();
        initFragments();
    }

    private void initFragments() {
        homeFragment = new HomeFragment();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(R.id.main_vp,homeFragment)
                .show(homeFragment)
                        .commit();
    }

    private void initView() {
        mVpMain = (ViewPager) findViewById(R.id.main_vp);
        mTabMain = (TabLayout) findViewById(R.id.main_tab);
        mTabMain.addTab(mTabMain.newTab().setText("首页"));
        mTabMain.addTab(mTabMain.newTab().setText("我的"));
//        List<HomeFragment> fragments = getFragments();
//        HomePagerAdapter adapter = new HomePagerAdapter(getSupportFragmentManager(), fragments);
//        mVpMain.setAdapter(adapter);
        mTabMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                switch (position){
                    case 0:
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.show(homeFragment)
                                .commit();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "我的", Toast.LENGTH_SHORT).show();
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

    private List<HomeFragment> getFragments() {
        List<HomeFragment> list = new ArrayList<HomeFragment>();
        for (int i = 0; i < list.size(); i++) {
            list.add(new HomeFragment());
        }
        return list;
    }

    private void initStatusBar() {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { // >=6.0的系统
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 1.整个Activty占据整个屏幕(包含状态类栏) 2.状态栏中的字体和图标颜色为黑色
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {  // [5.0,6.0)的系统
            // 1.整个Activty占据整个屏幕(包含状态类栏) 2.状态栏中的字体和图标颜色为系统默认的颜色白色
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4 [4.4,5.0)的系统
            //Android 4.4 使用这个可以起作用
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }
}
