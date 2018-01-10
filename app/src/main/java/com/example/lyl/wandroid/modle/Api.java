package com.example.lyl.wandroid.modle;

import com.example.lyl.wandroid.modle.bean.LoginResultBean;
import com.example.lyl.wandroid.modle.bean.RegistResultBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;


/**
 * Created by dllo on 18/1/9.
 */

public interface  Api {

    @FormUrlEncoded
    @POST("register")
    Observable<RegistResultBean> register(@FieldMap Map<String, Object> map);

    @FormUrlEncoded
    @POST("login")
    Observable<LoginResultBean> login(@FieldMap Map<String, Object> map);
}
