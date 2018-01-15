package com.example.lyl.wandroid.presenter;

import android.content.Intent;
import android.widget.Toast;

import com.example.lyl.wandroid.modle.NetTool;
import com.example.lyl.wandroid.modle.bean.AtricalListBean;
import com.example.lyl.wandroid.util.BaseContent;
import com.example.lyl.wandroid.view.iview.IAtricalListActivity;
import com.example.lyl.wandroid.view.ui.ArticalListActivity;
import com.example.lyl.wandroid.view.ui.fragment.MyFragment;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dllo on 18/1/13.
 */

public class AtricalListActivityPresenter {
    private IAtricalListActivity view;

    public AtricalListActivityPresenter(IAtricalListActivity view) {
        this.view = view;
    }

    public void getArticalList (int id) {
        NetTool.getInstance()
                .getApi()
                .getAtricalList(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AtricalListBean>() {
                    @Override
                    public void accept(AtricalListBean atricalListBean) throws Exception {
                        view.response(atricalListBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.fail();
                    }
                });
    }

    public void getCollectList () {
        NetTool.getInstance()
                .getApi().getCollectData(0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AtricalListBean>() {
                    @Override
                    public void accept(AtricalListBean bean) throws Exception {
                        view.collectresponse(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.fail();
                    }
                });
    }

    public void search(String k) {
        NetTool.getInstance().getApi()
                .search(k)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AtricalListBean>() {
                    @Override
                    public void accept(AtricalListBean bean) throws Exception {
                        view.searchresponse(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.fail();
                    }
                });
    }
}
