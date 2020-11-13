package com.example.myapplication.zqr.chapter6.proxy;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-10
 * Time: 14:40
 */
class TestClass {
    {
        Wq wq=new Wq();
        ProxyPerson proxyPerson=new ProxyPerson(wq);//代理人帮我买锤子
        proxyPerson.buy();
    }
}
