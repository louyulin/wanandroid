package com.example.lyl.wandroid.presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.lyl.wandroid.modle.NetTool;
import com.example.lyl.wandroid.modle.bean.HomeArticalBean;
import com.example.lyl.wandroid.view.iview.IHomeFragment;
import com.example.lyl.wandroid.view.ui.MainActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dllo on 18/1/11.
 */

public class HomeFragmentPresenter {
    private IHomeFragment view;

    public HomeFragmentPresenter(IHomeFragment view) {
        this.view = view;
    }

    public void requestHomeList () {
        NetTool.getInstance().getApi()
                .getHomeList(0 + "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeArticalBean>() {
                    @Override
                    public void accept(HomeArticalBean homeArticalBean) throws Exception {
                      view.response(homeArticalBean);
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
