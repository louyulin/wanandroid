package com.example.lyl.wandroid.presenter;

import com.example.lyl.wandroid.modle.NetTool;
import com.example.lyl.wandroid.modle.bean.CollectResultBean;
import com.example.lyl.wandroid.util.BaseContent;
import com.example.lyl.wandroid.view.iview.IArticalDetialActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dllo on 18/1/12.
 */

public class ArticalDetialActivityPresenter {
    private IArticalDetialActivity view;

    public ArticalDetialActivityPresenter(IArticalDetialActivity view) {
        this.view = view;
    }

    public void collect(int id){
        NetTool.getInstance().getApi()
                .collectArtical(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CollectResultBean>() {
                    @Override
                    public void accept(CollectResultBean collectResultBean) throws Exception {
                        view.response(BaseContent.collect);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        view.fail();
                    }
                });
    }

    public void uncollect(int id){
        NetTool.getInstance().getApi()
                .unCollectArtical(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CollectResultBean>() {
                    @Override
                    public void accept(CollectResultBean collectResultBean) throws Exception {
                        view.response(!BaseContent.collect);
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
