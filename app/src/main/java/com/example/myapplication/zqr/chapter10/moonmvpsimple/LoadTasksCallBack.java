package com.example.myapplication.zqr.chapter10.moonmvpsimple;

public interface LoadTasksCallBack<T> {
    void onSuccess(T t);
    void onStart();
    void onFailed();
    void onFinish();
}
