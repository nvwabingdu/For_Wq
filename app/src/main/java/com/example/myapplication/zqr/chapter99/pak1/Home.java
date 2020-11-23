package com.example.myapplication.zqr.chapter99.pak1;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-21
 * Time: 14:53
 */
public class Home {
    private Child child;

    @Inject
    public Home(@Named("Child") Child child){
        this.child=child;
    }

    public String walk(){
        return child.walk();
    }


}
