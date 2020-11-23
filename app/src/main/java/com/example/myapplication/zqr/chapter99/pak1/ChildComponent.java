package com.example.myapplication.zqr.chapter99.pak1;

import javax.inject.Inject;

import dagger.Component;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-21
 * Time: 14:40
 */
@Component(modules = PersonModule.class)
public interface ChildComponent {
    void inject();
}
