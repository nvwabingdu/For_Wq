package com.example.myapplication.android.activity;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.android.global.BaseActivity;
import com.example.myapplication.zqr.chapter2.myrecyclerview.RecyclerViewActivity;


public class MainActivity extends BaseActivity{

    @Override
    public int LayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //RecyclerViewActivity
        this.findViewById(R.id.open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIntentClass(RecyclerViewActivity.class);
            }
        });
    }
}
