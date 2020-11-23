package com.example.myapplication.zqr.chapter10.moonmvpsimple.net;


import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/1/2 0002.
 */
@Singleton
@Component(modules =NetTaskModule.class)
public interface NetTaskComponent {
    NetTask getNetTask();
}
