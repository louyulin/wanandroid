package com.example.lyl.wandroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lyl.wandroid.R;
import com.example.lyl.wandroid.modle.bean.KnowladgeTxBean;
import com.example.lyl.wandroid.util.BaseContent;
import com.example.lyl.wandroid.view.ui.ArticalListActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 18/1/12.
 */

public class KnowladgeLvAdapter extends BaseAdapter {

    private List<KnowladgeTxBean.DataBean> firstDataList = new ArrayList<>();

    public void setFirstDataList(List<KnowladgeTxBean.DataBean> firstDataList) {
        this.firstDataList = firstDataList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (firstDataList.size() == 0) {
            return 0;
        } else {
            return firstDataList.size();
        }
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_knowladgelv, parent, false);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.tv.setText(firstDataList.get(position).getName());

        RvAdapter adapter = new RvAdapter();
        adapter.setSecondDatas(firstDataList.get(position).getChildren());
        GridLayoutManager manager = new GridLayoutManager(parent.getContext(), 3, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        holder.rv.setLayoutManager(manager);
        holder.rv.setAdapter(adapter);

        return convertView;
    }

    class Holder {

        TextView tv;
        RecyclerView rv;

        public Holder(View view) {
            tv = view.findViewById(R.id.item_knowladgelv_tv);
            rv = view.findViewById(R.id.item_knowladge_rv);
        }
    }

    class RvAdapter extends RecyclerView.Adapter<RvAdapter.Holder> {

        private Context context;

        private List<KnowladgeTxBean.DataBean.ChildrenBean> secondDatas = new ArrayList<>();

        public void setSecondDatas(List<KnowladgeTxBean.DataBean.ChildrenBean> secondDatas) {
            this.secondDatas = secondDatas;
            notifyDataSetChanged();
        }

        @Override
        public Holder onCreateViewHolder(final ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_konwladgelv_rv, parent, false);
            Holder holder = new Holder(view);
            RvAdapter.this.context = parent.getContext();
            return holder;
        }

        @Override
        public void onBindViewHolder(Holder holder, final int position) {
            holder.tv.setText(secondDatas.get(position).getName());

            holder.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(context, ArticalListActivity.class);
                    intent.putExtra(BaseContent.ARTICALID,secondDatas.get(position).getId());
                    intent.putExtra(BaseContent.ARTICALTITLE,secondDatas.get(position).getName());
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            if (secondDatas.size() == 0) {
                return 0;
            } else {
                return secondDatas.size();
            }
        }

        class Holder extends RecyclerView.ViewHolder {
            TextView tv;

            public Holder(View itemView) {
                super(itemView);
                tv = itemView.findViewById(R.id.item_knowladge_rv_tv);
            }
        }
    }
}
