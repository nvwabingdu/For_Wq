package com.example.myapplication.zqr.chapter6.factory;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-10
 * Time: 13:58
 */
public class WQCompterFctory extends ComputerFactory{
    @Override
    public <T extends Computer> T createComputer(Class<T> tClass) {
        Computer computer=null;
        String className=tClass.getName();
        try {
            //通过反射来生产不同厂家的计算机
            computer= (Computer) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) computer;
    }
}
