package com.example.lyl.wandroid.view.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lyl.wandroid.R;
import com.example.lyl.wandroid.adapter.ArticalListAdapter;
import com.example.lyl.wandroid.adapter.CollectListAdapter;
import com.example.lyl.wandroid.modle.bean.AtricalListBean;
import com.example.lyl.wandroid.modle.bean.CollectListBean;
import com.example.lyl.wandroid.presenter.AtricalListActivityPresenter;
import com.example.lyl.wandroid.util.BaseContent;
import com.example.lyl.wandroid.util.Event;
import com.example.lyl.wandroid.view.customview.RefreshLayout;
import com.example.lyl.wandroid.view.iview.IAtricalListActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class CollectListActivity extends AppCompatActivity implements IAtricalListActivity, SwipeRefreshLayout.OnRefreshListener, RefreshLayout.OnLoadListener {

    //// TODO: 18/1/15 适配器重写

    private Toolbar toolbar;
    private ListView lv;

    private AtricalListActivityPresenter presenter;
    private String searchtitle;
    private ProgressDialog progressDialog;
    private Intent intent;
    private RefreshLayout refreshLayout;
    private boolean isRefreshing = false;
    private boolean isLoading = false;
    private int page = 0;
    private List<CollectListBean.DataBean.DatasBean> articalListData;
    private CollectListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowladge_list);

        EventBus.getDefault().register(this);

        initData();

        initView();
    }
    private void initData() {
        presenter = new AtricalListActivityPresenter();
        presenter.setView(this);

        articalListData = new ArrayList<>();

        intent = getIntent();

        searchtitle = intent.getStringExtra(BaseContent.COLLECTName);
        CollectListBean bean = (CollectListBean) intent.getSerializableExtra(BaseContent.BEANFLAG);
        articalListData = bean.getData().getDatas();
    }

    private void initView() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在请求");

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle(searchtitle);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            //是左上角按键出现
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        lv = (ListView) findViewById(R.id.lv);

        adapter = new CollectListAdapter();

        adapter.setDatas(articalListData);

        lv.setAdapter(adapter);




        refreshLayout = (RefreshLayout) findViewById(R.id.swipRefreshLayout);
        refreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent, R.color.colorAccent, R.color.colorPrimaryDark);

        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setOnLoadListener(this);

        progressDialog.show();

        presenter.getCollectList(page);


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
    }

    @Override
    public void response(AtricalListBean bean) {

    }

    @Override
    public void collectresponse(CollectListBean bean) {
        if (isRefreshing) {
            refreshLayout.setRefreshing(false);
            isRefreshing = false;
        }
        if (isLoading) {
            refreshLayout.setLoading(false);
            isLoading = false;
        }

        progressDialog.dismiss();

        if (bean.getData().getDatas() != null) {
            for (int i = 0; i <bean.getData().getDatas().size() ; i++) {
                articalListData.add(bean.getData().getDatas().get(i));
            }
            adapter.setDatas(articalListData);
        } else {
            Toast.makeText(this, "" + bean.getErrorMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void fail() {

        if (page >= 1) {
            page--;
        }

        progressDialog.dismiss();
        if (isRefreshing) {
            refreshLayout.setRefreshing(false);
            isRefreshing = false;
        }
        if (isLoading) {
            refreshLayout.setLoading(false);
            isLoading = false;
        }
        Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();
    }


    @Subscribe
    public void onEventMainThread(Event event) {

        if (event.getMsg().equals(BaseContent.REFRESHHOMEFRAGMENT)) {
            articalListData.remove(event.getPosition());
            adapter.setDatas(articalListData);
        }
    }

    @Override
    public void onRefresh() {
        page = 0;
        isRefreshing = true;
        articalListData.clear();
        presenter.getCollectList(0);
    }

    @Override
    public void onLoad() {
        isLoading = true;
        ++page;
        presenter.getCollectList(page);
    }
}
