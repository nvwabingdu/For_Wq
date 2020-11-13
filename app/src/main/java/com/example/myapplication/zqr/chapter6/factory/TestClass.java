package com.example.myapplication.zqr.chapter6.factory;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-10
 * Time: 14:09
 */
class TestClass {
    {
        ComputerFactory computerFactory=new WQCompterFctory();

        HPcomputer hPcomputer=computerFactory.createComputer(HPcomputer.class);

        hPcomputer.start();

    }
}
