package com.example.myapplication.zqr.chapter5.moonretrofit;


import com.example.myapplication.zqr.chapter5.moonretrofit.model.Ip;
import com.example.myapplication.zqr.chapter5.moonvolley.IpModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2016/11/1 0001.
 */

public interface IpServiceForPostBody {
    @POST("getIpInfo.php")
    Call<IpModel> getIpMsg(@Body Ip ip);
}
