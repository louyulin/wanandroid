package com.example.lyl.wandroid.modle;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Created by dllo on 18/1/10.
 */

public class WanAndroidCookieJar implements CookieJar {
    private static final String TAG = "WanAndroidCookieJar";

    private static HashMap<String, List<Cookie>> map = new HashMap<>();

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        Log.i(TAG, "saveFromResponse: " + url);
        Log.i(TAG, "saveFromResponse: " + cookies);
        map.put(url.host(), cookies);
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> cookies = map.get(url.host());
        Log.i(TAG, "loadForRequest: " + url);
        Log.i(TAG, "loadForRequest: " + cookies);
        return cookies != null ? cookies : new ArrayList<Cookie>();
    }

    public static void clearCookie() {
        map.clear();
    }
}
