package com.example.myapplication.zqr.chapter5.moonretrofit;

import com.example.myapplication.zqr.chapter5.moonretrofit.model.Ip;
import com.example.myapplication.zqr.chapter5.moonvolley.IpModel;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-12-01
 * Time: 23:18
 */
public class MyRetrofit {

    public interface IpService {
        //headers为消息报头处理，此处为静态
        @Headers({
                "Accept-Encoding: application/json",
                "User-Agent: zqr"
        })
        @GET("getIpInfo.php?ip=59.108.54.37")
        Call<IpModel> getIpMsg();
    }

    //动态配置添加消息报头
//    interface Someservice{
//        @GET("some/endpoint")
//        Call<ResponseBody> getCarType(@Headers("Location") String location;);
//    }


    public interface IpServiceForPath {
        @GET("{path}/getIpInfo.php?ip=59.108.54.37")
        Call<IpModel> getIpMsg(@Path("path") String path);
    }

    public interface IpServiceForPost {
        @FormUrlEncoded
        @POST("getIpInfo.php")
        Call<IpModel> getIpMsg(@Field("ip") String first);
    }

    public interface IpServiceForPostBody {
        @POST("getIpInfo.php")
        Call<IpModel> getIpMsg(@Body Ip ip);
    }

    public interface IpServiceForQuery{
        @GET("getIpInfo.php")
        Call<IpModel> getIpMsg(@Query("ip")String ip);
    }

    public  interface IpServiceForQueryMap {
        @GET("getIpInfo.php")
        Call<IpModel> getIpMsg(@QueryMap Map<String, String> options);
    }


}
