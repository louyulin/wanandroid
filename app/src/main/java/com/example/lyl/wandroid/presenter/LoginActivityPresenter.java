package com.example.lyl.wandroid.presenter;

import android.content.Context;

import com.example.lyl.wandroid.modle.NetTool;
import com.example.lyl.wandroid.modle.bean.LoginResultBean;
import com.example.lyl.wandroid.util.BaseContent;
import com.example.lyl.wandroid.util.ShareUtils;
import com.example.lyl.wandroid.view.iview.ILoginActivity;
import com.example.lyl.wandroid.view.ui.LoginActivity;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dllo on 18/1/10.
 */

public class LoginActivityPresenter {
    private ILoginActivity view;

    Map<String, Object> map;

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public LoginActivityPresenter(ILoginActivity view) {
        this.view = view;
    }

    public void login(){
        NetTool.getInstance().getApi()
                .login(map). subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginResultBean>() {
                    @Override
                    public void accept(LoginResultBean loginResultBean) throws Exception {
                        view.loginResponse(loginResultBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.loginFail();
                    }
                });
    }

        public void putSheare (LoginResultBean bean) {
        ShareUtils.putString((Context) view, "username" , bean.getData().getUsername() +"");
        ShareUtils.putString((Context) view, "password" , bean.getData().getPassword() +"");
        ShareUtils.putString((Context) view, "id" , bean.getData().getId() +"");
    }
}
