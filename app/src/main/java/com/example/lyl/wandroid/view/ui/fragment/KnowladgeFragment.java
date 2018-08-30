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
import com.example.lyl.wandroid.adapter.KnowladgeLvAdapter;
import com.example.lyl.wandroid.modle.bean.KnowladgeTxBean;
import com.example.lyl.wandroid.presenter.KnowladgeFragmentPresenter;
import com.example.lyl.wandroid.view.iview.IKnowladgeFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class KnowladgeFragment extends Fragment implements IKnowladgeFragment{


    private ListView knowladge_lv;
    private KnowladgeLvAdapter adapter;
    private ProgressDialog progressDialog;
    private KnowladgeFragmentPresenter presenter;

    public static KnowladgeFragment newInstance() {
        KnowladgeFragment knowladgeFragment = new KnowladgeFragment();
        return knowladgeFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_knowladge, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new KnowladgeFragmentPresenter(this);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("正在请求");

        knowladge_lv = (ListView) view.findViewById(R.id.knowladge_lv);
        adapter = new KnowladgeLvAdapter();
        knowladge_lv.setAdapter(adapter);

        progressDialog.show();

        presenter.requestKnowladgeTx();

    }

    @Override
    public void response(KnowladgeTxBean bean) {
        progressDialog.dismiss();
        if (bean.getData() != null){
            adapter.setFirstDataList(bean.getData());
        }else {
            Toast.makeText(getActivity(), "" + bean.getErrorMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void fail() {
        progressDialog.dismiss();
        Toast.makeText(getActivity(), "网络异常", Toast.LENGTH_SHORT).show();
    }
}
