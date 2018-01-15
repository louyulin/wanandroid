package com.example.lyl.wandroid.presenter;

import com.example.lyl.wandroid.modle.NetTool;
import com.example.lyl.wandroid.modle.bean.AtricalListBean;
import com.example.lyl.wandroid.modle.bean.HotKeyBean;
import com.example.lyl.wandroid.view.iview.ISearchActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dllo on 18/1/13.
 */

public class SearchActivityPresenter {
    ISearchActivity view;

    public SearchActivityPresenter(ISearchActivity view) {
        this.view = view;
    }

    public void search(String k) {
        NetTool.getInstance().getApi()
                .search(k)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AtricalListBean>() {
                    @Override
                    public void accept(AtricalListBean bean) throws Exception {
                        view.respones(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.fail();
                    }
                });
    }

    public void hotKey(){
        NetTool.getInstance().getApi()
                .getHotKey()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HotKeyBean>() {
                    @Override
                    public void accept(HotKeyBean hotKeyBean) throws Exception {
                        view.responesHotKey(hotKeyBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.fail();
                        throwable.printStackTrace();
                    }
                });
    }
}
