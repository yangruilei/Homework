package com.example.zhidingyiview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Mybut mBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBut = (Mybut) findViewById(R.id.but);
        mBut.setTranslationX(SharedPrefHelper.getInstance().getTranslationX());
        mBut.setTranslationY(SharedPrefHelper.getInstance().getTranslationY());
    }

    @Override
    protected void onPause() {
        super.onPause();
        float lastX = mBut.getLastX();
        float lastY = mBut.getLastY();
        SharedPrefHelper.getInstance().setTranslationX(lastX);
        SharedPrefHelper.getInstance().setTranslationY(lastY);
    }
}
