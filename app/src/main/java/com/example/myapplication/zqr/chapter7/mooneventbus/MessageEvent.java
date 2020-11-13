package com.example.myapplication.zqr.chapter7.mooneventbus;

/**
 * Created by Administrator on 2016/8/15 0015.
 */
//第一部创建事件类
public class MessageEvent {

    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
