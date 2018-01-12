package com.example.lyl.wandroid.presenter;

import com.example.lyl.wandroid.modle.NetTool;
import com.example.lyl.wandroid.modle.bean.KnowladgeTxBean;
import com.example.lyl.wandroid.view.iview.IKnowladgeFragment;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dllo on 18/1/12.
 */

public class KnowladgeFragmentPresenter {
    private IKnowladgeFragment view;

    public KnowladgeFragmentPresenter(IKnowladgeFragment view) {
        this.view = view;
    }

    public void requestKnowladgeTx(){
        NetTool.getInstance().getApi()
                .getKnowladgeTx().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<KnowladgeTxBean>() {
                    @Override
                    public void accept(KnowladgeTxBean knowladgeTxBean) throws Exception {
                        view.response(knowladgeTxBean);
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
