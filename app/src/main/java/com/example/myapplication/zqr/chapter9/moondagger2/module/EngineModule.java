package com.example.myapplication.zqr.chapter9.moondagger2.module;



import com.example.myapplication.zqr.chapter9.moondagger2.annotation.Diesel;
import com.example.myapplication.zqr.chapter9.moondagger2.annotation.Gasoline;
import com.example.myapplication.zqr.chapter9.moondagger2.model.DieselEngine;
import com.example.myapplication.zqr.chapter9.moondagger2.model.Engine;
import com.example.myapplication.zqr.chapter9.moondagger2.model.GasolineEngine;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/12/18 0018.
 */
@Module
public class EngineModule {
    @Provides
    @Gasoline
    public Engine provideGasoline() {
        return new GasolineEngine();
    }

    @Provides
    @Diesel
    public Engine provideDiesel() {
        return new DieselEngine();
    }
}
