package com.example.lyl.wandroid.presenter;

import android.content.Intent;
import android.widget.Toast;

import com.example.lyl.wandroid.modle.NetTool;
import com.example.lyl.wandroid.modle.bean.AtricalListBean;
import com.example.lyl.wandroid.modle.bean.CollectListBean;
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

    public void setView(IAtricalListActivity view) {
        this.view = view;
    }

    public void getArticalList (int page , int id) {
        NetTool.getInstance()
                .getApi()
                .getAtricalList(page,id)
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
                        throwable.printStackTrace();

                    }
                });
    }


    public void getCollectList (int page) {
        NetTool.getInstance()
                .getApi().getCollectData(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CollectListBean>() {
                    @Override
                    public void accept(CollectListBean bean) throws Exception {
                        view.collectresponse(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.fail();
                        throwable.printStackTrace();

                    }
                });
    }

    public void search(int page , String k) {
        NetTool.getInstance().getApi()
                .search(page,k)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AtricalListBean>() {
                    @Override
                    public void accept(AtricalListBean bean) throws Exception {
                        view.response(bean);
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
