package com.example.myapplication.zqr.chapter9.moondagger2.module;

import com.example.myapplication.zqr.chapter9.moondagger2.annotation.ApplicationScope;
import com.google.gson.Gson;


import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/12/18 0018.
 */

@Module
public class GsonModule {
    @ApplicationScope
    @Provides
    public Gson provideGson() {
        return new Gson();
    }

//@Module标注在类上，用来告诉component，可以从这个类中获取依赖对象，也就是Gson。
// @provodes标记在方法上，表示可以通过这个方法来获取依赖对象的实例，通俗来说，
// @module标注的类就是其实就是一个工厂，用来生成各种类，@provodes标记的方法，就是用来生成这些类的实例的。
}
