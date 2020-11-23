package com.example.myapplication.zqr.chapter99;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-20
 * Time: 20:29
 */
class MActivity extends AppCompatActivity {
    @Inject
    Test test;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("",test.str);
        test.mmm();
    }
}
