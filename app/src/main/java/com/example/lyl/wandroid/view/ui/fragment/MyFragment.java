package com.example.lyl.wandroid.view.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lyl.wandroid.R;
import com.example.lyl.wandroid.modle.NetTool;
import com.example.lyl.wandroid.modle.WanAndroidCookieJar;
import com.example.lyl.wandroid.modle.bean.AtricalListBean;
import com.example.lyl.wandroid.modle.bean.CollectListBean;
import com.example.lyl.wandroid.util.BaseContent;
import com.example.lyl.wandroid.util.ShareUtils;
import com.example.lyl.wandroid.view.ui.ArticalListActivity;
import com.example.lyl.wandroid.view.ui.CollectListActivity;
import com.example.lyl.wandroid.view.ui.LoginActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**写不动了 这一页用mvc
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {


    public static MyFragment newInstance() {
        MyFragment myFragment = new MyFragment();
        return myFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView username_tv = (TextView) view.findViewById(R.id.username_tv);
        username_tv.setText(ShareUtils.getString(getActivity(),"username",null) == null ? "用户名" : ShareUtils.getString(getActivity(),"username",null));


        TextView exitTv = (TextView) view.findViewById(R.id.exit_tv);
        exitTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WanAndroidCookieJar.clearCookie();
                ShareUtils.deleAll(getActivity());
                startActivity(new Intent(getActivity(), LoginActivity.class));
                MyFragment.this.getActivity().finish();

            }
        });

        TextView collectTv = (TextView) view.findViewById(R.id.collect_tv);

        collectTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetTool.getInstance()
                        .getApi().getCollectData(0)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<CollectListBean>() {
                            @Override
                            public void accept(CollectListBean bean) throws Exception {
                                Log.d("MyFragment", "bean.getData().getDatas():" + bean.getData().getDatas());
                                Intent intent = new Intent(MyFragment.this.getActivity(), CollectListActivity.class);
                                intent.putExtra(BaseContent.BEANFLAG,bean);
                                intent.putExtra(BaseContent.COLLECTName,"我的收藏");
                                MyFragment.this.getActivity().startActivity(intent);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Toast.makeText(MyFragment.this.getActivity(), "检查网络", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
