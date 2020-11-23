package com.example.myapplication.zqr.chapter99.pak1;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-21
 * Time: 15:15
 */
@Module
public interface SingleModule {
    @Singleton
    @Provides
    public  Single provideSingle();
}
