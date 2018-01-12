package com.example.lyl.wandroid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lyl.wandroid.R;
import com.example.lyl.wandroid.modle.bean.HomeArticalBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 18/1/11.
 */

public class HomeListAdapter extends BaseAdapter {

    private List<HomeArticalBean.DataBean.DatasBean> list = new ArrayList<>();

    public void setList(List<HomeArticalBean.DataBean.DatasBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (list.size()==0){
            return 0;
        }else {
            return list.size();
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
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_homelv,parent,false);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }
        holder.titletv.setText(list.get(position).getTitle());
        holder.zuozhetv.setText(list.get(position).getNiceDate()+"  " +"来自" +"  " + list.get(position).getAuthor());
        return convertView;
    }

    class Holder{
        TextView titletv , zuozhetv;
        public Holder(View view) {
            titletv = view.findViewById(R.id.item_title_tv);
            zuozhetv = view.findViewById(R.id.item_zuozhe_tv);
        }
    }
}
