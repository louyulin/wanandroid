package com.example.lyl.wandroid.presenter;

import android.content.Context;

import com.example.lyl.wandroid.modle.NetTool;
import com.example.lyl.wandroid.modle.bean.RegistResultBean;
import com.example.lyl.wandroid.util.BaseContent;
import com.example.lyl.wandroid.util.ShareUtils;
import com.example.lyl.wandroid.view.iview.IRegisterActivity;
import com.example.lyl.wandroid.view.ui.RegisterActivity;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dllo on 18/1/9.
 */

public class RegisterActivityPresenter {
    IRegisterActivity view;

    Map<String, Object> map;

    public RegisterActivityPresenter(IRegisterActivity view) {
        this.view = view;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void register() {
        NetTool.getInstance().getApi()
                .register(map).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegistResultBean>() {
                    @Override
                    public void accept(RegistResultBean registResultBean) throws Exception {
                        view.response(registResultBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        view.fail();
                    }
                });
    }

}
