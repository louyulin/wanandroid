package com.example.lyl.wandroid.view.iview;

import com.example.lyl.wandroid.modle.bean.AtricalListBean;
import com.example.lyl.wandroid.modle.bean.CollectListBean;
import com.example.lyl.wandroid.modle.bean.CollectResultBean;

/**
 * Created by dllo on 18/1/13.
 */

public interface IAtricalListActivity {
    void response(AtricalListBean bean);
    void collectresponse(CollectListBean bean);
    void fail();
}
