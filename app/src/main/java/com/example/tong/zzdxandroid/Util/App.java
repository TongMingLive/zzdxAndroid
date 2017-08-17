package com.example.tong.zzdxandroid.Util;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;
import com.example.tong.zzdxandroid.bean.Users;

/**
 * Created by flytoyou on 2017/3/1.
 */

public class App extends Application {
    public static Users user;
    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
    }
}
