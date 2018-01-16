package com.example.lyl.wandroid.view.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lyl.wandroid.R;
import com.example.lyl.wandroid.modle.bean.AtricalListBean;
import com.example.lyl.wandroid.modle.bean.HotKeyBean;
import com.example.lyl.wandroid.modle.bean.RegistResultBean;
import com.example.lyl.wandroid.presenter.SearchActivityPresenter;
import com.example.lyl.wandroid.util.BaseContent;
import com.example.lyl.wandroid.view.iview.ISearchActivity;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements ISearchActivity {

    private Toolbar toolbar;
    private EditText search_et;
    private SearchActivityPresenter presenter;
    private TagFlowLayout tagFlowLayout;
    private List<HotKeyBean.DataBean> datas;
    private String hotkeyname;
    private boolean hotkeyisclick = false;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initView();
    }

    private void initView() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在请求");

        presenter = new SearchActivityPresenter(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //是左上角按键出现
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        search_et = (EditText) findViewById(R.id.search_et);


        search_et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    //完成自己的事件
                    if (search_et.getText().toString() != null){
                        presenter.search(search_et.getText().toString());
                    }
                }
                return false;
            }
        });


        presenter.hotKey();

        tagFlowLayout = (TagFlowLayout) findViewById(R.id.tagflowlayout);

        tagFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {


            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                progressDialog.show();
                if (datas != null){
                    hotkeyisclick = true;
                    hotkeyname = datas.get(position).getName();
                    presenter.search(hotkeyname);
                }
                return false;
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }


    @Override
    public void respones(AtricalListBean bean) {
        Intent intent = new Intent();
        intent.setClass(SearchActivity.this,SearchListActivity.class);
        intent.putExtra(BaseContent.BEANFLAG,bean);
        if (hotkeyisclick == true){
            progressDialog.dismiss();
            hotkeyisclick = false;
            intent.putExtra(BaseContent.SEARCHTITLE,hotkeyname);
        }else {
            intent.putExtra(BaseContent.SEARCHTITLE,search_et.getText().toString());
        }
        startActivity(intent);
    }

    @Override
    public void responesHotKey(final HotKeyBean bean) {
        datas = new ArrayList<>();
        datas = bean.getData();

        tagFlowLayout.setAdapter(new TagAdapter<HotKeyBean.DataBean>(datas) {
            @Override
            public View getView(FlowLayout parent, int position, HotKeyBean.DataBean dataBean) {
                TextView textView = (TextView) LayoutInflater.from(SearchActivity.this).inflate(R.layout.hot_key_item, parent, false);
                textView.setText(datas.get(position).getName());
                return textView;
            }
        });
    }

    @Override
    public void fail() {
        Toast.makeText(this, "搜索失败", Toast.LENGTH_SHORT).show();
    }
}
