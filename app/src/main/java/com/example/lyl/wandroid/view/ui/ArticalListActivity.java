package com.example.lyl.wandroid.view.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lyl.wandroid.R;
import com.example.lyl.wandroid.adapter.ArticalListAdapter;
import com.example.lyl.wandroid.modle.bean.AtricalListBean;
import com.example.lyl.wandroid.presenter.AtricalListActivityPresenter;
import com.example.lyl.wandroid.util.BaseContent;
import com.example.lyl.wandroid.util.Event;
import com.example.lyl.wandroid.view.iview.IAtricalListActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class ArticalListActivity extends AppCompatActivity implements IAtricalListActivity {
    private Toolbar toolbar;
    private ListView lv;
    private ArticalListAdapter adapter;
    private AtricalListActivityPresenter presenter;
    private int id;
    private String title;
    private ProgressDialog progressDialog;
    private Intent intent;
    private String searchTitle;
    private String collectTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowladge_list);

        EventBus.getDefault().register(this);

        initData();

        initView();
    }

    private void initData() {
        presenter = new AtricalListActivityPresenter(this);

        intent = getIntent();
        id = intent.getIntExtra(BaseContent.ARTICALID, -1);
        title = intent.getStringExtra(BaseContent.ARTICALTITLE);
        searchTitle = intent.getStringExtra(BaseContent.SEARCHTITLE);
        collectTitle = intent.getStringExtra(BaseContent.COLLECTName);
    }

    private void initView() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在请求");

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (title != null) {
            toolbar.setTitle(title);
        }else if(searchTitle != null){
            toolbar.setTitle(searchTitle);
        }else {
            toolbar.setTitle(collectTitle);
        }
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //是左上角按键出现
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        lv = (ListView) findViewById(R.id.lv);
        adapter = new ArticalListAdapter();

        lv.setAdapter(adapter);

        progressDialog.show();

        if (intent.getSerializableExtra(BaseContent.BEANFLAG) != null) {
            AtricalListBean bean = (AtricalListBean) intent.getSerializableExtra(BaseContent.BEANFLAG);
            adapter.setDatas(bean.getData().getDatas());
            progressDialog.dismiss();
        } else {
            presenter.getArticalList(id);
        }


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
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        finish();

    }

    @Override
    public void response(AtricalListBean bean) {
        progressDialog.dismiss();
        if (bean.getData() != null) {
            adapter.setDatas(bean.getData().getDatas());
        }
    }

    @Override
    public void fail() {
        progressDialog.dismiss();
        Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void collectresponse(AtricalListBean bean) {
        if (bean.getData() != null) {
            adapter.setDatas(bean.getData().getDatas());
        }
    }

    @Override
    public void searchresponse(AtricalListBean bean) {
        if (bean.getData() != null) {
            adapter.setDatas(bean.getData().getDatas());
        }
    }

    @Subscribe
    public void onEventMainThread(Event event) {
        if (event.getMsg().equals(BaseContent.REFRESHHOMEFRAGMENT)) {
            if (collectTitle != null){
                //执行收藏接口
                presenter.getCollectList();
            }else if (searchTitle != null){
                //执行搜索接口
                presenter.search(searchTitle);
            }else {
                presenter.getArticalList(id);
            }
        }
    }
}
