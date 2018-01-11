package com.example.lyl.wandroid.view.ui.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lyl.wandroid.R;
import com.example.lyl.wandroid.adapter.HomeListAdapter;
import com.example.lyl.wandroid.adapter.HomePicAdapter;
import com.example.lyl.wandroid.modle.bean.HomeArticalBean;
import com.example.lyl.wandroid.presenter.HomeFragmentPresenter;
import com.example.lyl.wandroid.view.iview.IHomeFragment;
import com.hejunlin.superindicatorlibray.CircleIndicator;
import com.hejunlin.superindicatorlibray.LoopViewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements IHomeFragment {


    private HomeFragmentPresenter presenter;
    private HomeListAdapter adapter;

    private ProgressDialog progressDialog;
    private ListView listView;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        presenter = new HomeFragmentPresenter(this);
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {


        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("正在请求");

        listView = view.findViewById(R.id.lv);

        //初始化头布局
        View lvHeadView = LayoutInflater.from(getActivity()).inflate(R.layout.item_head_homelv,null );
        //初始化轮播图
        LoopViewPager lvp = lvHeadView.findViewById(R.id.looperviewpager);
        CircleIndicator indicator = lvHeadView.findViewById(R.id.indicator);
        lvp.setAdapter(new HomePicAdapter(getActivity()));
        lvp.setLooperPic(true);//5s自动轮播
        indicator.setViewPager(lvp); //indicator需要知道viewpager
        //添加完成
        listView.addHeaderView(lvHeadView);

        adapter = new HomeListAdapter();

        progressDialog.show();
        presenter.requestHomeList();
    }


    @Override
    public void response(HomeArticalBean bean) {
        progressDialog.dismiss();
        if (bean.getData().getDatas() != null) {
            adapter.setList(bean.getData().getDatas());
            listView.setAdapter(adapter);
        } else {
            Toast.makeText(getActivity(), "" + bean.getErrorMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void fail() {
        progressDialog.dismiss();
        Toast.makeText(getActivity(), "网络异常", Toast.LENGTH_SHORT).show();
    }
}
