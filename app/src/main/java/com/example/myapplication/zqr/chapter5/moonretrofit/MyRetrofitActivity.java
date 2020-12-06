package com.example.myapplication.zqr.chapter5.moonretrofit;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.zqr.chapter5.moonretrofit.model.Ip;
import com.example.myapplication.zqr.chapter5.moonvolley.IpModel;
import java.lang.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofitActivity extends AppCompatActivity {
    private Button bt_request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit2);
        bt_request = (Button) findViewById(R.id.bt_request);
        bt_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getIpInformationForQuery("59.108.54.37");
                  getIpInformation();
//                getIpInformationForPath("service");
//                postIpInformation("59.108.54.37");
//                postIpInformationForBody("59.108.54.37");


            }
        });
    }

    /**
     * 普通GET请求
     */
    private void getIpInformation() {
        String url = "http://ip.taobao.com/service/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                //增加返回值为jsoon的支持，还有其他格式
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyRetrofit.IpService ipService = retrofit.create(MyRetrofit.IpService.class);
        //通过之前的定义接口，获得call
        Call<IpModel> call = ipService.getIpMsg();
//        call.execute()//同步请求网络？
//        call.cancel();//取消请求
        //请求并处理回调
        call.enqueue(new Callback<IpModel>() {
            @Override
            public void onResponse(Call<IpModel> call, Response<IpModel> response) {
                String country = response.body().getData().getCountry();
                Log.i("wangshu", "country" + country);
                Toast.makeText(getApplicationContext(), country, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<IpModel> call, Throwable t) {

            }
        });
    }

    /**
     * @param path
     * @Path方式GET请求
     */
    private void getIpInformationForPath(String path) {
        String url = "http://ip.taobao.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyRetrofit.IpServiceForPath ipService = retrofit.create( MyRetrofit.IpServiceForPath.class);
        Call<IpModel> call = ipService.getIpMsg(path);
        call.enqueue(new Callback<IpModel>() {
            @Override
            public void onResponse(Call<IpModel> call, Response<IpModel> response) {
                String country = response.body().getData().getCountry();
                Log.i("wangshu", "country" + country);
                Toast.makeText(getApplicationContext(), country, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<IpModel> call, Throwable t) {

            }
        });
    }


    /**
     * @param ip
     * @Query方式GET请求
     */
    private void getIpInformationForQuery(String ip) {
        String url = "http://ip.taobao.com/service/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyRetrofit.IpServiceForQuery ipService = retrofit.create( MyRetrofit.IpServiceForQuery.class);
        Call<IpModel> call = ipService.getIpMsg(ip);
        call.enqueue(new Callback<IpModel>() {
            @Override
            public void onResponse(Call<IpModel> call, Response<IpModel> response) {
                String country = response.body().getData().getCountry();
                Log.i("wangshu", "country" + country);
                Toast.makeText(getApplicationContext(), country, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<IpModel> call, Throwable t) {

            }
        });
    }

    /**
     * 传输数据类型为键值对的POST请求
     *
     * @param ip
     */
    private void postIpInformation(String ip) {
        String url = "http://ip.taobao.com/service/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyRetrofit.IpServiceForPost ipService = retrofit.create( MyRetrofit.IpServiceForPost.class);
        Call<IpModel> call = ipService.getIpMsg(ip);
        call.enqueue(new Callback<IpModel>() {
            @Override
            public void onResponse(Call<IpModel> call, Response<IpModel> response) {
                String country = response.body().getData().getCountry();
                Log.i("wangshu", "country" + country);
                Toast.makeText(getApplicationContext(), country, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<IpModel> call, Throwable t) {

            }
        });
    }

    /**
     * 传输数据类型Json字符串的POST请求
     *
     * @param ip
     */
    private void postIpInformationForBody(String ip) {
        String url = "http://ip.taobao.com/service/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyRetrofit.IpServiceForPostBody ipService = retrofit.create( MyRetrofit.IpServiceForPostBody.class);
        Call<IpModel> call = ipService.getIpMsg(new Ip(ip));
        call.enqueue(new Callback<IpModel>() {
            @Override
            public void onResponse(Call<IpModel> call, Response<IpModel> response) {
                String country = response.body().getData().getCountry();
                Log.i("wangshu", "country" + country);
                Toast.makeText(getApplicationContext(), country, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<IpModel> call, Throwable t) {

            }
        });
    }
}
