package com.example.myapplication.zqr.chapter10.moonmvpsimple.ipinfo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.zqr.chapter10.moonmvpsimple.MvpApplication;
import com.example.myapplication.zqr.chapter10.moonmvpsimple.util.ActivityUtils;

import javax.inject.Inject;

public class IpInfoActivity extends AppCompatActivity {
    @Inject
    IpInfoPresenter ipInfoPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipinfo);
        IpInfoFragment ipInfoFragment = (IpInfoFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (ipInfoFragment == null) {
            ipInfoFragment = IpInfoFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    ipInfoFragment, R.id.contentFrame);
        }
//        IpInfoTask ipInfoTask = new IpInfoTask();
//        ipInfoPresenter = new IpInfoPresenter(ipInfoFragment, ipInfoTask);
//        ipInfoFragment.setPresenter(ipInfoPresenter);
        DaggerIpInfoComponent.builder().ipInfoModule(new IpInfoModule(ipInfoFragment)).netTaskComponent(((MvpApplication) getApplication()).getTasksRepositoryComponent()).build().inject(this);
    }
}
