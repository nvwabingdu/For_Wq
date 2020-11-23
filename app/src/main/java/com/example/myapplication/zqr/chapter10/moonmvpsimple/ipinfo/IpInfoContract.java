package com.example.myapplication.zqr.chapter10.moonmvpsimple.ipinfo;


import com.example.myapplication.zqr.chapter10.moonmvpsimple.BasePresenter;
import com.example.myapplication.zqr.chapter10.moonmvpsimple.BaseView;
import com.example.myapplication.zqr.chapter10.moonmvpsimple.model.IpInfo;

public interface IpInfoContract {
    interface Presenter extends BasePresenter {
        void getIpInfo(String ip);
    }

    interface View extends BaseView<Presenter> {
        void setIpInfo(IpInfo ipInfo);
        void showLoading();
        void hideLoading();
        void showError();
        boolean isActive();
    }
}
