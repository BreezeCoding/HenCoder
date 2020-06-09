package com.breeze.custom.hencoder;

import android.app.Application;
import android.os.Handler;


public class App extends Application {
    private static Handler mHandler = new Handler();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static Handler getInstance() {
        return mHandler;
    }
}
