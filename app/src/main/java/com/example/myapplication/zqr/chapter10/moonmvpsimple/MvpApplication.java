package com.example.myapplication.zqr.chapter10.moonmvpsimple;

import android.app.Application;

import com.example.myapplication.zqr.chapter10.moonmvpsimple.net.DaggerNetTaskComponent;
import com.example.myapplication.zqr.chapter10.moonmvpsimple.net.NetTaskComponent;
import com.example.myapplication.zqr.chapter10.moonmvpsimple.net.NetTaskModule;


/**
 * Created by Administrator on 2016/12/25 0025.
 */

public class MvpApplication extends Application {
    private NetTaskComponent netTaskComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        netTaskComponent= DaggerNetTaskComponent.builder().netTaskModule(new NetTaskModule()).build();
    }

    public NetTaskComponent getTasksRepositoryComponent() {
        return netTaskComponent;
    }
}
