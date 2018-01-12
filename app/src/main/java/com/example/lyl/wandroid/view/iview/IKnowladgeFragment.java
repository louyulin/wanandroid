package com.example.lyl.wandroid.view.iview;

import com.example.lyl.wandroid.modle.bean.KnowladgeTxBean;

/**
 * Created by dllo on 18/1/12.
 */

public interface IKnowladgeFragment {
    void response(KnowladgeTxBean bean);
    void fail();
}
