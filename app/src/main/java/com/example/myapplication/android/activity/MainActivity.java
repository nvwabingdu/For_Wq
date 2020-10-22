package com.example.myapplication.android.activity;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.R;
import com.example.myapplication.android.global.BaseActivity;


public class MainActivity extends BaseActivity {

    @Override
    public int LayoutId() {
        return 0;
    }

    @Override
    public void initView() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        byte b = (~5);
        short b1 = ~1;
        int b2 = ~1;
        long b3 = ~1;
//        b^=2;
        Log.e("TAG", "b=" + b);
        Log.e("TAG", "b1=" + b1);
        Log.e("TAG", "b2=" + b2);
        Log.e("TAG", "b3=" + b3);
    }


}
