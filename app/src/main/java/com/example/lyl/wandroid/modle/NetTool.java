package com.example.lyl.wandroid.modle;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dllo on 18/1/9.
 */

public class NetTool {
    public static NetTool instance;
    private Retrofit retrofit;
    private final Api api;


    public Api getApi() {
        return api;
    }


    private NetTool(String baseurl) {



        //初始化Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .client(OkHttpClientManger.getOkHttpClient())
                //给Retrofit添加Gson解析功能
                .addConverterFactory(GsonConverterFactory.create())
                //给Retrofit添加Rxjava功能
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        //初始化Retrofit的Api接口
        api = retrofit.create(Api.class);
    }

    //线程锁单例
    public static NetTool getInstance(String baseurl ) {
        if (instance == null) {
            synchronized (NetTool.class) {
                if (instance == null) {
                    instance = new NetTool(baseurl);
                }
            }
        }
        return instance;
    }
}
