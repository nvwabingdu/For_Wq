package com.example.myapplication.zqr.chapter3.mooncustomgroup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;

public class CostGrouppActivity extends Activity {
    private TitleBar mTitleBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupview);
        mTitleBar= (TitleBar) this.findViewById(R.id.title);
//      mTitleBar.setTitle("自定义组合控件");

        mTitleBar.setLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CostGrouppActivity.this, "点击左键", Toast.LENGTH_SHORT).show();
            }
        });

        mTitleBar.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CostGrouppActivity.this, "点击右键", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
