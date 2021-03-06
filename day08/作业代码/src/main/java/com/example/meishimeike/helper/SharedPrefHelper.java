package com.example.meishimeike.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.meishimeike.BaseApplication;




public class SharedPrefHelper {
    private static SharedPrefHelper sharedPrefHelper = null;
    private static SharedPreferences sharedPreferences;

    public static synchronized SharedPrefHelper getInstance() {
        if (null == sharedPrefHelper) {
            sharedPrefHelper = new SharedPrefHelper();
        }
        return sharedPrefHelper;
    }

    private SharedPrefHelper() {
        sharedPreferences = BaseApplication.baseApplication
                .getSharedPreferences("SPH_NAME", Context.MODE_PRIVATE);
    }



    public void isFirst(boolean isFirst) {
        sharedPreferences.edit().putBoolean("isFirst",isFirst).commit();
    }

    public boolean getIsFirst() {
        return sharedPreferences.getBoolean("isFirst", true);
    }

}
