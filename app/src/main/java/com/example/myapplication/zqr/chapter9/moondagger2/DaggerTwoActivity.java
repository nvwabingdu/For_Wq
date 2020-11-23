package com.example.myapplication.zqr.chapter9.moondagger2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.zqr.chapter9.moondagger2.model.Car;
import com.example.myapplication.zqr.chapter9.moondagger2.model.Man;
import com.example.myapplication.zqr.chapter9.moondagger2.model.Watch;
import com.google.gson.Gson;


import javax.inject.Inject;

public class DaggerTwoActivity extends AppCompatActivity {
    private static final String TAG="Dagger2";
    private Button bt_jump;

    @Inject
    Watch watch;
    @Inject
    Gson gson;
    @Inject
    Gson gson1;
    @Inject
    Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
//        DaggerActivityComponent.builder().build().inject(this);
        App.get(DaggerTwoActivity.this).getActivityComponent().inject(this);
        onClick();
        watch.work();
        String jsonData = "{'name':'zhangwuji', 'age':20}";
        Man man = gson.fromJson(jsonData, Man.class);
        Log.d(TAG, "name---" + man.getName());
        String str = car.run();
        Log.d(TAG, "car---" + str);
        Log.d(TAG, gson.hashCode() + "---------" + gson1.hashCode());

    }

    private void onClick() {
        bt_jump = (Button) findViewById(R.id.bt_jump);
        bt_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DaggerTwoActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }


}
