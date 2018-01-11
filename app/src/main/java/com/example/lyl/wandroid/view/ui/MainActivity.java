package com.example.lyl.wandroid.view.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lyl.wandroid.R;
import com.example.lyl.wandroid.adapter.MainVpAdapter;
import com.example.lyl.wandroid.view.ui.fragment.HomeFragment;
import com.example.lyl.wandroid.view.ui.fragment.KnowladgeFragment;
import com.example.lyl.wandroid.view.ui.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 18/1/9.
 */

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager main_vp;
    private TabLayout main_tablayout;
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private List<Integer> pics = new ArrayList<>();
    private TextView tab_tv;
    private ImageView tab_iv;
    private View tabView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFramentList();
        initView();
    }

    private void initFramentList() {
        fragmentList.add(HomeFragment.newInstance());
        fragmentList.add(KnowladgeFragment.newInstance());
        fragmentList.add(MyFragment.newInstance());

        titles.add("首页");
        titles.add("知识体系");
        titles.add("个人");

        pics.add(R.drawable.sy_selecter);
        pics.add(R.drawable.zstx_selecter);
        pics.add(R.drawable.grzx_selector);
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("玩Android");
        setSupportActionBar(toolbar);

        main_vp = (ViewPager) findViewById(R.id.main_vp);
        main_vp.setAdapter(new MainVpAdapter(getSupportFragmentManager(), fragmentList));
        main_tablayout = (TabLayout) findViewById(R.id.main_tablayout);

        main_tablayout.setupWithViewPager(main_vp);

        for (int i = 0; i < fragmentList.size(); i++) {
            View tabView = getTabView(i);
             TabLayout.Tab tab = main_tablayout.getTabAt(i);
             tab.setCustomView(tabView);
        }

        main_vp.setCurrentItem(1);
        main_vp.setCurrentItem(0);


    }

    public View  getTabView(int i) {
        tabView = LayoutInflater.from(this).inflate(R.layout.item_tabl, null);
        tab_tv = (TextView) tabView.findViewById(R.id.tab_tv);
        tab_iv = (ImageView) tabView.findViewById(R.id.tab_iv);
        tab_iv.setImageResource(pics.get(i));
        tab_tv.setText(titles.get(i));
        return tabView;
    }
}
