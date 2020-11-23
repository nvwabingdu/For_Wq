package com.example.myapplication.zqr.chapter10.moondatabinding;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.R;
import com.example.myapplication.databinding.DataActivityRecyclerBinding;
import com.example.myapplication.zqr.chapter10.moondatabinding.adapter.SwordsmanAdapter;
import com.example.myapplication.zqr.chapter10.moondatabinding.model.Swordsman;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    private DataActivityRecyclerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.data_activity_recycler);
        initRecyclerView();
    }
    private void initRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(RecyclerActivity.this);
        binding.recycler.setLayoutManager(manager);
        SwordsmanAdapter adapter=new SwordsmanAdapter(getList());
        binding.recycler.setAdapter(adapter);
    }
    private List<Swordsman> getList(){
        List<Swordsman> list =new ArrayList<>();
        Swordsman swordman1=new Swordsman("杨影枫","SS");
        Swordsman swordman2=new Swordsman("月眉儿","A");
        list.add(swordman1);
        list.add(swordman2);
        return list;
    }
}
