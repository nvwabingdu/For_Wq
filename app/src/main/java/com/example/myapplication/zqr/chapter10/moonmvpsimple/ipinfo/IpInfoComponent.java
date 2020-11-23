package com.example.myapplication.zqr.chapter10.moonmvpsimple.ipinfo;

import com.example.myapplication.zqr.chapter10.moonmvpsimple.net.NetTaskComponent;
import com.example.myapplication.zqr.chapter10.moonmvpsimple.util.FragmentScoped;

import dagger.Component;

/**
 * Created by Administrator on 2017/1/2 0002.
 */
@FragmentScoped
@Component(dependencies = NetTaskComponent.class,modules = IpInfoModule.class)
public interface IpInfoComponent {
    void inject(IpInfoActivity ipInfoActivity);
}
