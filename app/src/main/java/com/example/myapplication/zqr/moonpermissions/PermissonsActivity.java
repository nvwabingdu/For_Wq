package com.example.myapplication.zqr.moonpermissions;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.android.global.BaseActivity;

public class PermissonsActivity extends BaseActivity {

    private Button bt_call;
    private Button bt_permissionsdispatcher;
    private static final int PERMISSIONS_REQUEST_CALL_PHONE = 1;

    @Override
    public int LayoutId() {
        return R.layout.activity_permissons;
    }

    @Override
    public void initView() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bt_call = (Button) this.findViewById(R.id.bt_call);
        bt_permissionsdispatcher=(Button) this.findViewById(R.id.bt_permissionsdispatcher);
        bt_permissionsdispatcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PermissonsActivity.this,ThirdPartyActivity.class);
                startActivity(intent);
            }
        });
        bt_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();

            }
        });
    }

    public void call() {

            //检查App是否有permission.CALL_PHONE的权限
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                //如果没有permission.CALL_PHONE的权限的就申请该权限
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        PERMISSIONS_REQUEST_CALL_PHONE);
            } else {
                callPhone();
            }
        }



    public void callPhone() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + "10086");
        intent.setData(data);
        try {
            startActivity(intent);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    //申请权限的回调
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        if (requestCode == PERMISSIONS_REQUEST_CALL_PHONE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callPhone();
            } else {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
                    AlertDialog dialog = new AlertDialog.Builder(this)
                            .setMessage("该功能需要访问电话的权限，不开启将无法正常工作！")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            }).create();
                    dialog.show();
                }
                return;
            }
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}