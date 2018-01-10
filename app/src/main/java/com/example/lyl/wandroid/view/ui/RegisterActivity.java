package com.example.lyl.wandroid.view.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lyl.wandroid.R;
import com.example.lyl.wandroid.modle.bean.RegistResultBean;
import com.example.lyl.wandroid.presenter.RegisterActivityPresenter;
import com.example.lyl.wandroid.util.ShareUtils;
import com.example.lyl.wandroid.view.iview.IRegisterActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by dllo on 18/1/9.
 */

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener ,IRegisterActivity {

    private Toolbar toolbar;
    private EditText regist_user_et;
    private EditText regist_psw_et;
    private EditText regist_psw_agin_et;
    private Button register_btn;
    private ProgressDialog progressDialog;
    private RegisterActivityPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_rigister);
        initView();
        initData();
    }


    private void initData() {
        presenter = new RegisterActivityPresenter(this);
    }


    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("注册");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //是左上角按键出现
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        regist_user_et = (EditText) findViewById(R.id.regist_user_et);
        regist_psw_et = (EditText) findViewById(R.id.regist_psw_et);
        regist_psw_agin_et = (EditText) findViewById(R.id.regist_psw_agin_et);
        register_btn = (Button) findViewById(R.id.register_btn);
        register_btn.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在请求");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_btn:
                submit();
                progressDialog.show();
                Map<String, Object> map = new HashMap<>();
                map.put("username", regist_user_et.getText().toString().trim());
                map.put("password", regist_psw_et.getText().toString().trim());
                map.put("repassword", regist_psw_agin_et.getText().toString().trim());
                //进行注册请求
                presenter.setMap(map);
                presenter.register();
                break;
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }

        return  true;
    }


    private void submit() {
        // validate
        String et = regist_user_et.getText().toString().trim();
        if (TextUtils.isEmpty(et)) {
            Toast.makeText(this, "填写账户名", Toast.LENGTH_SHORT).show();
            return;
        }

        String et2 = regist_psw_et.getText().toString().trim();
        if (TextUtils.isEmpty(et2)) {
            Toast.makeText(this, "填写密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String et3 = regist_psw_agin_et.getText().toString().trim();
        if (TextUtils.isEmpty(et3)) {
            Toast.makeText(this, "确认密码", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!(regist_psw_et.getText().toString().trim().equals(regist_psw_agin_et.getText().toString().trim()))){
            Toast.makeText(this, "两次输入的密码不一样", Toast.LENGTH_SHORT).show();
            return;
        }

    }


    @Override
    public void response(RegistResultBean bean) {
        progressDialog.dismiss();
        if (bean.getData() == null){
            Toast.makeText(this, "" + bean.getErrorMsg(), Toast.LENGTH_SHORT).show();
        }else {

            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();

            Intent mIntent = new Intent();
            mIntent.putExtra("username",bean.getData().getUsername() +"");
            mIntent.putExtra("psw", bean.getData().getPassword() +"");
            // 设置结果，并进行传送
            this.setResult(99, mIntent);

            this.finish();
        }

    }

    @Override
    public void fail() {
        Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();
        progressDialog.dismiss();
    }
}
