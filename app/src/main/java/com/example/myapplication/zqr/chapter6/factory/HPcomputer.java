package com.example.myapplication.zqr.chapter6.factory;

import android.util.Log;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-10
 * Time: 14:11
 */
class HPcomputer extends Computer{
    @Override
    public void start() {
        Log.e("","生产了一台惠普电脑");
    }

}
