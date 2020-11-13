package com.example.myapplication.zqr.chapter6.builder;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-10
 * Time: 14:21
 */
abstract class MyBuilder {
    public abstract void builderOne(String one);
    public abstract void builderTwo(String two);
    public abstract void builderThree(String three);
    public abstract Computer create();
}
