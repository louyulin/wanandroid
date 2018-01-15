package com.example.lyl.wandroid.view.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lyl.wandroid.R;
import com.example.lyl.wandroid.modle.NetTool;
import com.example.lyl.wandroid.modle.bean.LoginResultBean;
import com.example.lyl.wandroid.util.ShareUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SplashActivity extends AppCompatActivity {

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            String id = ShareUtils.getString(SplashActivity.this, "id", "id为空");

            if (id.equals("id为空")){
                startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                finish();
            }else {
                if (!id.equals("id为空")){
                    Map<String,Object> map = new HashMap<>();
                    map.put("username",ShareUtils.getString(SplashActivity.this,"username",""));
                    map.put("password",ShareUtils.getString(SplashActivity.this,"password",""));
                    NetTool.getInstance().getApi()
                            .login(map). subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<LoginResultBean>() {
                                @Override
                                public void accept(LoginResultBean loginResultBean) throws Exception {
                                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                                    finish();
                                }
                            }, new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    Toast.makeText(SplashActivity.this, "网络未连接", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                                    finish();
                                }
                            });
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splash);


        handler.sendEmptyMessageDelayed(1,2500);

    }
}
