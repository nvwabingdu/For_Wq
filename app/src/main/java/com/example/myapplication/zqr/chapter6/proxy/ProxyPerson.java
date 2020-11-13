package com.example.myapplication.zqr.chapter6.proxy;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-10
 * Time: 14:38
 */
class ProxyPerson implements Shopping{
    private Shopping shopping;

    public ProxyPerson(Shopping shopping) {
        this.shopping = shopping;
    }

    @Override
    public void buy() {
        shopping.buy();
    }


}
