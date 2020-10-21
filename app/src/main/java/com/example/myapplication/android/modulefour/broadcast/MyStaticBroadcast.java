package com.example.myapplication.android.modulefour.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.myapplication.android.utils.Tools;

/**
 * Created by wangqi on 2017/12/15.
 */

public class MyStaticBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_SCREEN_ON.equals(intent.getAction())) {
            Tools.showLog("我收到了");
        }
    }
}
