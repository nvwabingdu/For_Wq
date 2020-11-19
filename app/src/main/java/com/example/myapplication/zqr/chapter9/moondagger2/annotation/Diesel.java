package com.example.myapplication.zqr.chapter9.moondagger2.annotation;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Administrator on 2016/12/19 0019.
 */
@Qualifier
@Retention(RUNTIME)
public @interface Diesel {
}
