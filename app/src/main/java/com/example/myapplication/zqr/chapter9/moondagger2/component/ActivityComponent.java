package com.example.myapplication.zqr.chapter9.moondagger2.component;



import com.example.myapplication.zqr.chapter9.moondagger2.DaggerTwoActivity;
import com.example.myapplication.zqr.chapter9.moondagger2.SecondActivity;
import com.example.myapplication.zqr.chapter9.moondagger2.annotation.ApplicationScope;
import com.example.myapplication.zqr.chapter9.moondagger2.module.EngineModule;
import com.example.myapplication.zqr.chapter9.moondagger2.module.GsonModule;


import dagger.Component;

/**
 * Created by Administrator on 2016/12/20 0020.
 */
@ApplicationScope
@Component(modules = {GsonModule.class, EngineModule.class},dependencies = SwordsmanComponent.class)
public interface ActivityComponent {
    void inject(DaggerTwoActivity activity);
    void inject(SecondActivity activity);
}
