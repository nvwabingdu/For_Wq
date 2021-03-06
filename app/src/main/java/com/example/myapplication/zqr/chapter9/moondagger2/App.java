package com.example.myapplication.zqr.chapter9.moondagger2;

import android.app.Application;
import android.content.Context;

import com.example.myapplication.zqr.chapter9.moondagger2.component.ActivityComponent;
import com.example.myapplication.zqr.chapter9.moondagger2.component.DaggerActivityComponent;
import com.example.myapplication.zqr.chapter9.moondagger2.component.DaggerSwordsmanComponent;


/**
 * Created by Administrator on 2016/12/20 0020.
 */

public class App extends Application{
    ActivityComponent activityComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        activityComponent= DaggerActivityComponent.builder().swordsmanComponent(DaggerSwordsmanComponent.builder().build()).build();
    }
    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }
    ActivityComponent getActivityComponent(){
        return activityComponent;
    }
}
