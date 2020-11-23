package com.example.myapplication.zqr.chapter10.moonmvpsimple.ipinfo;



import com.example.myapplication.zqr.chapter10.moonmvpsimple.LoadTasksCallBack;
import com.example.myapplication.zqr.chapter10.moonmvpsimple.model.IpInfo;
import com.example.myapplication.zqr.chapter10.moonmvpsimple.net.NetTask;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


/**
 * Created by Administrator on 2016/12/29 0029.
 */

public class IpInfoPresenter implements IpInfoContract.Presenter, LoadTasksCallBack<IpInfo> {
    private NetTask netTask;
    private IpInfoContract.View addTaskView;
    private CompositeSubscription mSubscriptions;
    private Subscription subscription;
    @Inject
    public IpInfoPresenter(IpInfoContract.View addTaskView, NetTask netTask) {
        this.netTask = netTask;
        this.addTaskView = addTaskView;
        mSubscriptions = new CompositeSubscription();
    }
    @Inject
    void setPresenter() {
        addTaskView.setPresenter(this);
    }
    @Override
    public void getIpInfo(String ip) {
        subscription = netTask.execute(ip, this);
        subscribe();
    }

    @Override
    public void onSuccess(IpInfo ipInfo) {
        if (addTaskView.isActive()) {
            addTaskView.setIpInfo(ipInfo);
        }
    }

    @Override
    public void onStart() {
        if (addTaskView.isActive()) {
            addTaskView.showLoading();
        }
    }

    @Override
    public void onFailed() {
        if (addTaskView.isActive()) {
            addTaskView.showError();
            addTaskView.hideLoading();
        }
    }

    @Override
    public void onFinish() {
        if (addTaskView.isActive()) {
            addTaskView.hideLoading();
        }
    }


    @Override
    public void subscribe() {
        if(subscription!=null) {
            mSubscriptions.add(subscription);
        }
    }

    @Override
    public void unsubscribe() {
        if (mSubscriptions != null && mSubscriptions.hasSubscriptions()) {
            mSubscriptions.unsubscribe();
        }
    }
}
