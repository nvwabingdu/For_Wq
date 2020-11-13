package com.example.myapplication.android.global;

import java.io.ObjectStreamException;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-10
 * Time: 13:40
 */
    //静态内部类的单例方式 静态内部类的方法 线程安全
public class Singleton {
    private Singleton() {
    }

    public static Singleton getInstance(){
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder{
        private static final Singleton sInstance=new Singleton();
    }

    //杜绝单例对象被反序列化时重新生成对象，必须加入下面方法
//    private Object readResolve() throws ObjectStreamException{
//        return singleton;
//    }
}
