package com.example.lyl.wandroid.modle;

import com.example.lyl.wandroid.modle.bean.CollectResultBean;
import com.example.lyl.wandroid.modle.bean.HomeArticalBean;
import com.example.lyl.wandroid.modle.bean.KnowladgeTxBean;
import com.example.lyl.wandroid.modle.bean.LoginResultBean;
import com.example.lyl.wandroid.modle.bean.RegistResultBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


/**
 * Created by dllo on 18/1/9.
 */

public interface  Api {

    @FormUrlEncoded
    @POST("user/register")
    Observable<RegistResultBean> register(@FieldMap Map<String, Object> map);

    @FormUrlEncoded
    @POST("user/login")
    Observable<LoginResultBean> login(@FieldMap Map<String, Object> map);

    @GET("article/list/{page}/json")
    Observable<HomeArticalBean> getHomeList(@Path("page") String page);

    @GET("tree/json")
    Observable<KnowladgeTxBean> getKnowladgeTx();

    @POST("lg/collect/{id}/json")
    Observable<CollectResultBean> collectArtical(@Path("id") int id);

    @POST("lg/uncollect_originId/{id}/json")
    Observable<CollectResultBean> unCollectArtical(@Path("id") int id);


}
