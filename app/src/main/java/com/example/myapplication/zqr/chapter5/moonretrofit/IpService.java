package com.example.myapplication.zqr.chapter5.moonretrofit;

import com.example.myapplication.zqr.chapter5.moonvolley.IpModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface IpService {
    @Headers({
            "Accept-Encoding: application/json",
            "User-Agent: MoonRetrofit"
    })
    @GET("getIpInfo.php?ip=59.108.54.37")
    Call<IpModel> getIpMsg();
}
