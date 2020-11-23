package com.example.myapplication.zqr.chapter10.moonmvpsimple.net;


import com.example.myapplication.zqr.chapter10.moonmvpsimple.LoadTasksCallBack;

import rx.Subscription;

/**
 * Created by Administrator on 2016/12/29 0029.
 */

public interface NetTask<T> {
    Subscription execute(T data , LoadTasksCallBack callBack);
}
