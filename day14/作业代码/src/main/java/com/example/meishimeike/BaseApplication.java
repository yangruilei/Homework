package com.example.meishimeike;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.meishimeike.greendaodemo.db.DaoMaster;
import com.example.meishimeike.greendaodemo.db.DaoSession;


public class BaseApplication extends Application {
    public static BaseApplication baseApplication;
    private DaoMaster.DevOpenHelper mHelper;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
        setDatabase();
    }
    /**
     * 设置greenDao
     */
    private void setDatabase() {
        //通过DaoMaster内部类DevOpenHelper可以获取一个SQLiteOpenHelper 对象
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        // 此处MyDb表示数据库名称 可以任意填写
        mHelper = new DaoMaster.DevOpenHelper(this, "MyDb", null);    // MyDb是数据库的名字，更具自己的情况修改
        SQLiteDatabase db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }
    public static BaseApplication getInstance(){
        return baseApplication;
    }
    public DaoSession getDaoSession(){
        return mDaoSession;
    }

}

