package com.example.myapplication.zqr.chapter8.moonrxjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.zqr.chapter8.moonrxjava.bus.RxBusActivity;
import com.example.myapplication.zqr.chapter8.moonrxjava.net.OkhttpActivity;
import com.example.myapplication.zqr.chapter8.moonrxjava.net.RetrofitActivity;

public class RxMainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_okhttp;
    private Button bt_create;
    private Button bt_filter;
    private Button bt_transform;
    private Button bt_combine;
    private Button bt_utility;
    private Button bt_error;
    private Button bt_conditional;
    private Button bt_conversion;
    private Button bt_retrofit;
    private Button bt_rxbus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_main);
        initView();
    }

    private void initView() {
        bt_create = (Button) this.findViewById(R.id.bt_create);
        bt_transform = (Button) this.findViewById(R.id.bt_conversion);
        bt_filter = (Button) this.findViewById(R.id.bt_filter);
        bt_combine = (Button) this.findViewById(R.id.bt_combine);
        bt_utility = (Button) this.findViewById(R.id.bt_utility);
        bt_error = (Button) this.findViewById(R.id.bt_error);
        bt_conditional = (Button) this.findViewById(R.id.bt_conditional);
        bt_conversion = (Button) this.findViewById(R.id.bt_conversion);
        bt_okhttp = (Button) this.findViewById(R.id.bt_okhttp);
        bt_retrofit= (Button) this.findViewById(R.id.bt_retrofit);
        bt_rxbus= (Button) this.findViewById(R.id.bt_rxbus);
        bt_filter.setOnClickListener(this);
        bt_create.setOnClickListener(this);
        bt_transform.setOnClickListener(this);
        bt_combine.setOnClickListener(this);
        bt_utility.setOnClickListener(this);
        bt_error.setOnClickListener(this);
        bt_conditional.setOnClickListener(this);
        bt_conversion.setOnClickListener(this);
        bt_okhttp.setOnClickListener(this);
        bt_retrofit.setOnClickListener(this);
        bt_rxbus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_okhttp:
                Intent okhttpIntent = new Intent(RxMainActivity.this, OkhttpActivity.class);
                startActivity(okhttpIntent);
                break;
            case R.id.bt_retrofit:
                Intent retrofitIntent = new Intent(RxMainActivity.this, RetrofitActivity.class);
                startActivity(retrofitIntent);
                break;
            case R.id.bt_rxbus:
                Intent rxbusIntent = new Intent(RxMainActivity.this, RxBusActivity.class);
                startActivity(rxbusIntent);
                break;
        }
    }
}
