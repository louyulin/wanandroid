package com.example.lyl.wandroid.view.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lyl.wandroid.R;
import com.example.lyl.wandroid.presenter.ArticalDetialActivityPresenter;
import com.example.lyl.wandroid.util.BaseContent;
import com.example.lyl.wandroid.util.Event;
import com.example.lyl.wandroid.view.iview.IArticalDetialActivity;

import org.greenrobot.eventbus.EventBus;

public class ArticalDetialActivity extends AppCompatActivity implements IArticalDetialActivity {

    private Toolbar toolbar;
    private WebView webview;
    private ProgressBar mWebProgress;
    private String link;
    private boolean iscollect = false;
    private int articalId;
    private MenuItem collect;
    private ArticalDetialActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artical_detial);

        initData();

        initView();
    }


    private void initData() {
        presenter = new ArticalDetialActivityPresenter(this);
        Intent intent = getIntent();
        link = intent.getStringExtra(BaseContent.ARTICALLINK);
        iscollect = intent.getBooleanExtra(BaseContent.ISCOLLECT, false);
        articalId = intent.getIntExtra(BaseContent.ARTICALID, -1);
    }

    private void initView() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //是左上角按键出现
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mWebProgress = (ProgressBar) findViewById(R.id.web_progress);

        webview = (WebView) findViewById(R.id.webview);

        initWebView();

    }

    public void initWebView() {
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setLoadsImagesAutomatically(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);

        webview.setWebViewClient(new CusWebViewClient());
        webview.setWebChromeClient(new CusWebChromeClient());

        webview.loadUrl(link);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.webtoolbar, menu);
        if (iscollect) {
            collect = menu.findItem(R.id.collect);
            collect.setIcon(R.drawable.shoucangselected);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.collect:
                if (articalId == -1) {
                    Toast.makeText(this, "收藏失败", Toast.LENGTH_SHORT).show();
                } else {
                    if (!iscollect){
                        presenter.collect(articalId);
                    }else {
                        presenter.uncollect(articalId);
                    }
                }
                break;
            case R.id.share:
                Toast.makeText(this, "分享功能正在开发中", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (webview != null && webview.canGoBack()) {
            webview.goBack();
        } else {
            finish();
        }
    }

    public void increase() {
        supportInvalidateOptionsMenu();
    }

        @Override
    public void response(boolean collect) {
            if (collect == true){
                //如果之前没有收藏
                    iscollect = true;
                    increase();
                Toast.makeText(this, "收藏成功", Toast.LENGTH_SHORT).show();
            }else {
                iscollect = false;
                increase();
                Toast.makeText(this, "解除收藏", Toast.LENGTH_SHORT).show();
            }


    }

    @Override
    public void fail() {
        Toast.makeText(this, "收藏失败", Toast.LENGTH_SHORT).show();
    }

    private class CusWebViewClient extends WebViewClient {

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            //super.onReceivedSslError(view, handler, error);
            handler.proceed();
        }
    }

    private class CusWebChromeClient extends WebChromeClient {
        @Override
        public void onReceivedTitle(WebView view, String title) {
            toolbar.setTitle(title);
        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress >= 99) {
                mWebProgress.setVisibility(View.GONE);
            } else {
                mWebProgress.setVisibility(View.VISIBLE);
            }
            mWebProgress.setProgress(newProgress);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().post(new Event(BaseContent.REFRESHHOMEFRAGMENT));
    }
}
