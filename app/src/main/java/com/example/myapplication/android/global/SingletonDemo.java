package com.example.myapplication.android.global;

import org.jetbrains.annotations.NotNull;

/**
 * Created by jack on 2017/7/3.   陈光剑
 */
public class SingletonDemo {
    private static SingletonDemo instance;

    private SingletonDemo() {} // private

    public static SingletonDemo getInstance() {
        if (instance == null) {
            instance = new SingletonDemo();
        }
        return instance;
    }
}


