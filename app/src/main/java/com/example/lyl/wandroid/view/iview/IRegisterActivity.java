package com.example.lyl.wandroid.view.iview;

import com.example.lyl.wandroid.modle.bean.RegistResultBean;

import java.util.Map;
import java.util.Objects;

/**
 * Created by dllo on 18/1/9.
 */

public interface IRegisterActivity {
    void response (RegistResultBean bean);
    void fail ();

}
