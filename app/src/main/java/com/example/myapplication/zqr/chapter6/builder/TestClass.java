package com.example.myapplication.zqr.chapter6.builder;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-10
 * Time: 14:23
 */
class TestClass {
    {
        MyBuilder myBuilder=new WqComputer();
        RulerComputer rulerComputer=new RulerComputer(myBuilder);
        //感觉没啥用  东一截西一截
        rulerComputer.CreateCompter("","","");


    }
}
