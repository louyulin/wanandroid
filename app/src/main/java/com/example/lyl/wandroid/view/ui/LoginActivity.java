package com.example.lyl.wandroid.view.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lyl.wandroid.R;
import com.example.lyl.wandroid.modle.bean.LoginResultBean;
import com.example.lyl.wandroid.presenter.LoginActivityPresenter;
import com.example.lyl.wandroid.util.ShareUtils;
import com.example.lyl.wandroid.view.iview.ILoginActivity;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener , ILoginActivity {

    private EditText user_et;
    private EditText psw_et;
    private TextView goto_regeist_tv;
    private Button login_btn;
    private LoginActivityPresenter presenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        String id = ShareUtils.getString(LoginActivity.this, "id", "id为空");

        if (!id.equals("id为空")){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }

        initView();

        initData();
    }



    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("登录");
        setSupportActionBar(toolbar);

        user_et = (EditText) findViewById(R.id.user_et);
        user_et.setOnClickListener(this);
        psw_et = (EditText) findViewById(R.id.psw_et);
        psw_et.setOnClickListener(this);

        goto_regeist_tv = (TextView) findViewById(R.id.goto_regeist_tv);
        goto_regeist_tv.setOnClickListener(this);

        login_btn = (Button) findViewById(R.id.login_btn);
        login_btn.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在请求");

    }

    private void initData() {
        presenter = new LoginActivityPresenter(this);
    }



    private void submit() {
        // validate
        String et = user_et.getText().toString().trim();
        if (TextUtils.isEmpty(et)) {
            Toast.makeText(this, "填写账户名", Toast.LENGTH_SHORT).show();
            return;
        }

        String et2 = psw_et.getText().toString().trim();
        if (TextUtils.isEmpty(et2)) {
            Toast.makeText(this, "填写密码", Toast.LENGTH_SHORT).show();
            return;
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //去注册页面
            case R.id.goto_regeist_tv:
                this.startActivityForResult(new Intent(LoginActivity.this , RegisterActivity.class),1);
                break;
            //登录请求
            case R.id.login_btn:

                submit();

                Map<String , Object> map = new HashMap<>();
                map.put("username",user_et.getText().toString().trim());
                map.put("password",psw_et.getText().toString().trim());
                presenter.setMap(map);
                presenter.login();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 99){
            switch (requestCode){
                case 1:
                    if (data != null){
                        user_et.setText(data.getStringExtra("username"));
                        psw_et.setText(data.getStringExtra("psw"));
                    }
                    break;
            }
        }
    }

    @Override
    public void loginResponse(LoginResultBean bean) {
        progressDialog.dismiss();
        if (bean.getData() == null){
            Toast.makeText(this, "" + bean.getErrorMsg(), Toast.LENGTH_SHORT).show();
        }else {

            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();

            presenter.putSheare(bean);

            startActivity(new Intent(LoginActivity.this , MainActivity.class));
            finish();
        }
    }

    @Override
    public void loginFail() {
        progressDialog.dismiss();
        Toast.makeText(this, "异常", Toast.LENGTH_SHORT).show();
    }
}
