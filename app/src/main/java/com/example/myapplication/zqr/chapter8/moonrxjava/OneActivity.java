package com.example.myapplication.zqr.chapter8.moonrxjava;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.android.global.BaseActivity;
import com.example.myapplication.android.utils.Tools;


import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-14
 * Time: 9:40
 */
public class OneActivity extends BaseActivity {


    @Override
    public int LayoutId() {
        return R.layout.activity_main;
    }
    TextView textView;
    StringBuffer stringBuffer;
    @Override
    public void initView() {
        this.findViewById(R.id.open).setVisibility(View.GONE);
        textView=this.findViewById(R.id.lv_one);
        textView.setVisibility(View.VISIBLE);
        stringBuffer=new StringBuffer();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        test2();
    }


    /**
     * 简单的rxjava方法-----------第一种
     */
    private void test1(){
        /*步骤一：创建观察者*/
        //用订阅创建观察者
        Subscriber subscriber=new Subscriber<String>(){
            @Override
            public void onCompleted() {
                //事件队列完结
                textView.setText(stringBuffer);
            }

            @Override
            public void onError(Throwable e) {
                //异常，队列终止，不允许再有事件发出
            }

            @Override
            public void onNext(String s) {
                stringBuffer.append(s+"\r\n");
                Tools.showToast(OneActivity.this,"订阅事件成功",1000);
                //普通的事件  将要处理的事件添加事件队列中
            }

            @Override
            public void onStart() {
                super.onStart();
                //事件未发送之前调用，一般不用  上面三个方法必须实现
            }
        };
        //用观察者创建 观察者
        Observer<String> observer=new Observer<String>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };

        /*步骤二：创建被观察者，三种方法*/
        //被观察者方法一
        Observable observable=Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                //
                subscriber.onNext("第一次订阅了四川日报");
                subscriber.onNext("第一次订阅了新华日报");
                subscriber.onNext("第一次订阅了中国日报");
                //结束
                subscriber.onCompleted();
            }
        });
        //第二种just方法
        Observable observable1=Observable.just("111","222","333");
        //第三种from方法
        Observable observable2=Observable.from(new String[]{"111","222","333"});

        /*步骤三：用被观察者  订阅  观察者，，*/
        //订阅方法
        //订阅第一个人
        observable.subscribe(subscriber);

        //订阅第二个人
//        observable1.subscribe(observer);

    }


    /**
     * 实现通过Action实现订阅-------------第二种
     */
    private void test2(){

        Action1<String> action1=new Action1<String>() {
            @Override
            public void call(String s) {
                stringBuffer.append(s+"\r\n");
                Tools.showToast(OneActivity.this,"订阅事件成功",1000);
            }
        };

        Action1<Throwable> throwableAction1=new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                stringBuffer.append(""+throwable);
            }
        };

        Action0 action=new Action0(){
            @Override
            public void call() {
                //事件队列完结
                textView.setText(stringBuffer);
            }
        };


      Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                //
                subscriber.onNext("你");
                subscriber.onNext("知道");
                subscriber.onNext("吗？");
                //结束
                subscriber.onCompleted();

            }
        }).subscribe(action1,throwableAction1,action);//这里启用了三个，也可以只用定义一个



    }


}
