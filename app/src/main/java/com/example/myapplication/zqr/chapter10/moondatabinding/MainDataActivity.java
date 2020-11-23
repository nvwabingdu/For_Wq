package com.example.myapplication.zqr.chapter10.moondatabinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.R;
import com.example.myapplication.databinding.DataActivityMainBinding;
import com.example.myapplication.zqr.chapter10.moondatabinding.model.Swordsman;


public class MainDataActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.data_activity_main);
        Swordsman swordsman=new Swordsman("张无忌","S");
        binding.setSwordsman(swordsman);
        binding.btLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainDataActivity.this,LayoutActivity.class);
                startActivity(intent);
            }
        });

        binding.btUpdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainDataActivity.this,UpdateActivity.class);
                startActivity(intent);
            }
        });
        binding.btRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainDataActivity.this,RecyclerActivity.class);
                startActivity(intent);
            }
        });
    }
}
