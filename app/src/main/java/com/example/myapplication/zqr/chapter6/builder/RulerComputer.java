package com.example.myapplication.zqr.chapter6.builder;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-10
 * Time: 14:27
 */
class RulerComputer {
    MyBuilder myBuilder;

    public RulerComputer(MyBuilder myBuilder) {
        this.myBuilder = myBuilder;
    }

    public Computer CreateCompter(String one,String two,String three){
        //规范建造的规则
        myBuilder.builderOne(one);
        myBuilder.builderTwo(two);
        myBuilder.builderThree(three);
        return myBuilder.create();
    }


}
