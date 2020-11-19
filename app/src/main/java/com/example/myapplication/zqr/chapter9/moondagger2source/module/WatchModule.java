package com.example.myapplication.zqr.chapter9.moondagger2source.module;

import com.example.myapplication.zqr.chapter9.moondagger2source.model.Watch;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/12/22 0022.
 */
@Module
public class WatchModule {
    @Provides
    public Watch provideWatch() {
        return new Watch();
    }
}
