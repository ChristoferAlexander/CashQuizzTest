package com.tg.alex.cashquizztest;

import android.app.Application;
import android.content.res.Configuration;

import org.androidannotations.annotations.EApplication;

/**
 * Created by Alex on 10/25/2017.
 */

@EApplication
public class CashQuizzApplication extends Application {

    private static CashQuizzApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

    }

    public static CashQuizzApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

}
