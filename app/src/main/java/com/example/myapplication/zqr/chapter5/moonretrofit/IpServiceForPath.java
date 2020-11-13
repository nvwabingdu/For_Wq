package com.example.myapplication.zqr.chapter5.moonretrofit;


import com.example.myapplication.zqr.chapter5.moonvolley.IpModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2016/10/31 0031.
 */

public interface IpServiceForPath {
    @GET("{path}/getIpInfo.php?ip=59.108.54.37")
    Call<IpModel> getIpMsg(@Path("path") String path);
}
