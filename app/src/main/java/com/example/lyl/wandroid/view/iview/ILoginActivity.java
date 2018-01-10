package com.example.lyl.wandroid.view.iview;

import com.example.lyl.wandroid.modle.bean.LoginResultBean;

/**
 * Created by dllo on 18/1/10.
 */

public interface ILoginActivity {
    void loginResponse(LoginResultBean loginResultBean);
    void loginFail();
}
