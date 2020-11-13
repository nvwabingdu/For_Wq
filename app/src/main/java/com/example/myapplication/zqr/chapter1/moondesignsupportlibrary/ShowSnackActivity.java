package com.example.myapplication.zqr.chapter1.moondesignsupportlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.myapplication.R;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-08
 * Time: 16:47
 */
public class ShowSnackActivity extends AppCompatActivity{

    private Button bt_snackbar;
    private Button bt_textInputLayout;
    private RelativeLayout activity_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showsnackbar);
        activity_main = (RelativeLayout) this.findViewById(R.id.activity_main);
        bt_textInputLayout= (Button) this.findViewById(R.id.bt_textInputLayout);
        bt_snackbar = (Button) this.findViewById(R.id.bt_snackbar);
        bt_textInputLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ShowSnackActivity.this,TextInputLayoutActivity.class);
                startActivity(intent);
            }
        });

        bt_snackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSnackbar();
            }
        });
    }

    private void showSnackbar() {
        Snackbar.make(activity_main, "标题", Snackbar.LENGTH_LONG)
                .setAction("点击事件", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(
                                ShowSnackActivity.this,
                                "Toast",
                                Toast.LENGTH_SHORT).show();
                    }
                }).setDuration(Snackbar.LENGTH_LONG).show();
    }
}
