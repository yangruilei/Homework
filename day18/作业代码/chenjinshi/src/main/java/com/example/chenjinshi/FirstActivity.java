package com.example.chenjinshi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initState();
    }
    private void initState() {
        //透明状态栏，不会将时间电量等隐藏掉
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    //会将屏幕底部的导航栏隐藏掉，会将布局适配到屏幕底部，不受导航栏的出现隐藏而改变布局高度
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    ;
            decorView.setSystemUiVisibility(option);
            //将底部导航栏背景颜色设置为透明
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

//隐藏ActionBar
      //  getSupportActionBar().hide();
    }

}