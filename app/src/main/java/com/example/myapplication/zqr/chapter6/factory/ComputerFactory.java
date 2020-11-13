package com.example.myapplication.zqr.chapter6.factory;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-10
 * Time: 14:04
 */
public abstract class  ComputerFactory {
    public abstract <T extends Computer> T createComputer(Class<T> tClass);

}
