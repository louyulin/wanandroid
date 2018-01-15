package com.example.lyl.wandroid.view.iview;

import com.example.lyl.wandroid.modle.bean.AtricalListBean;
import com.example.lyl.wandroid.modle.bean.HotKeyBean;

/**
 * Created by dllo on 18/1/13.
 */

public interface ISearchActivity {
    void respones(AtricalListBean bean);
    void responesHotKey(HotKeyBean bean);
    void fail();
}
