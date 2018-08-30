package com.example.lyl.wandroid.adapter;

import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lyl.wandroid.R;
import com.example.lyl.wandroid.modle.bean.AtricalListBean;
import com.example.lyl.wandroid.modle.bean.CollectListBean;
import com.example.lyl.wandroid.util.BaseContent;
import com.example.lyl.wandroid.view.ui.ArticalDetialActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 18/1/13.
 */

public class ArticalListAdapter extends BaseAdapter {
    private List<AtricalListBean.DataBean.DatasBean> datas = new ArrayList<>();


    public void setDatas(List<AtricalListBean.DataBean.DatasBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        if (datas.size() == 0) {
            return 0;
        } else {
            return datas.size();
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
    public View getView(final int position, View convertView, final ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_homelv, parent, false);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        String newArticleTitle = datas.get(position).getTitle().replaceAll("<em.+?>", "<font color=\"#f0717e\">").replaceAll("</em>", "</font>");
        holder.titletv.setText(Html.fromHtml(newArticleTitle));
        holder.zuozhetv.setText(datas.get(position).getNiceDate() + "  " + "来自" + "  " + datas.get(position).getAuthor());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent.getContext(), ArticalDetialActivity.class);
                intent.putExtra(BaseContent.ARTICALTITLE, datas.get(position).getTitle());
                intent.putExtra(BaseContent.ARTICALLINK, datas.get(position).getLink());
                intent.putExtra(BaseContent.ISCOLLECT, datas.get(position).isCollect());
                intent.putExtra(BaseContent.ARTICALID, datas.get(position).getId());
                intent.putExtra(BaseContent.POSITION,position);
                parent.getContext().startActivity(intent);
            }
        });
        return convertView;
    }

    class Holder {
        TextView titletv, zuozhetv;

        public Holder(View view) {
            titletv = (TextView) view.findViewById(R.id.item_title_tv);
            zuozhetv = (TextView) view.findViewById(R.id.item_zuozhe_tv);
        }
    }
}
