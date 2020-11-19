package com.example.myapplication.zqr.chapter8.moonrxjava;

import com.example.myapplication.zqr.chapter8.moonrxjava.model.HttpResult;
import com.example.myapplication.zqr.chapter8.moonrxjava.model.IpData;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2016/10/31 0031.
 */

public interface IpServiceForPost{
    @FormUrlEncoded
    @POST("getIpInfo.php")
    Observable<HttpResult<IpData>> getIpMsg(@Field("ip") String first);
}
