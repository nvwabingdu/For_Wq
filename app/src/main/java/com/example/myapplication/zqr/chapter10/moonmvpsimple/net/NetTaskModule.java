package com.example.myapplication.zqr.chapter10.moonmvpsimple.net;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/1/2 0002.
 */
@Module
public class NetTaskModule {
    @Singleton
    @Provides
    NetTask provideIpInfoTask() {
        return new IpInfoTask();
    }
}
