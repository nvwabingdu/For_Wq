package com.example.myapplication.zqr.chapter9.moondagger2source;

import android.os.Bundle;
import android.util.Log;


import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.zqr.chapter9.moondagger2source.component.DaggerActivityComponent;
import com.example.myapplication.zqr.chapter9.moondagger2source.model.Watch;

import javax.inject.Inject;

public class DaActivity extends AppCompatActivity {
    @Inject
    Watch watch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerActivityComponent.create().inject(this);
        String sr=watch.work();
        Log.i("wangshu",sr);
    }
}
