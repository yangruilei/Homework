package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.Vitamio;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!LibsChecker.checkVitamioLibs(this)) return;
        Vitamio.isInitialized(getApplicationContext());
    }
}