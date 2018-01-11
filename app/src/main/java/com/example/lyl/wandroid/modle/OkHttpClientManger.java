package com.example.lyl.wandroid.modle;

import com.example.lyl.wandroid.BuildConfig;
import com.example.lyl.wandroid.util.WanAndroidCookieJar;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by dllo on 18/1/11.
 */

public class OkHttpClientManger {
    private static OkHttpClient okHttpClient;

    public static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            synchronized (OkHttpClientManger.class) {
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(true ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

                if (okHttpClient == null) {
                    okHttpClient = new OkHttpClient.Builder()
                            .cookieJar(new WanAndroidCookieJar())
                            .addNetworkInterceptor(loggingInterceptor)
                            .retryOnConnectionFailure(true)
                            .build();
                }
            }
        }
        return okHttpClient;
    }
}
