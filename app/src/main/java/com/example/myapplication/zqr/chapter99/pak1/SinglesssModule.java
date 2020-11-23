package com.example.myapplication.zqr.chapter99.pak1;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-21
 * Time: 15:16
 */
@Singleton
@Component(modules = Single.class)
public interface SinglesssModule {
    void injecet(Single single);
}
