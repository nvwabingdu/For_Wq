package com.example.myapplication.zqr.chapter9.moondagger2source.component;


import com.example.myapplication.zqr.chapter9.moondagger2source.DaActivity;
import com.example.myapplication.zqr.chapter9.moondagger2source.module.WatchModule;

import dagger.Component;

/**
 * Created by Administrator on 2016/12/23 0023.
 */

@Component(modules = WatchModule.class)
public interface ActivityComponent {
    void inject(DaActivity activity);
}

