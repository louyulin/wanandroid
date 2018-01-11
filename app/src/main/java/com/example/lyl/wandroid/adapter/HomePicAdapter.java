package com.example.lyl.wandroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lyl.wandroid.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 18/1/11.
 */

public class HomePicAdapter extends PagerAdapter {

    private Context context;

    private List<String> piclist = new ArrayList<>();
    private List<String> titlelist = new ArrayList<>();

    public HomePicAdapter(Context context) {

        this.context = context;

        piclist.add("http://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png");
        piclist.add("http://www.wanandroid.com/blogimgs/ffb61454-e0d2-46e7-bc9b-4f359061ae20.png");
        piclist.add("http://www.wanandroid.com/blogimgs/fb0ea461-e00a-482b-814f-4faca5761427.png");
        piclist.add("http://www.wanandroid.com/blogimgs/ab17e8f9-6b79-450b-8079-0f2287eb6f0f.png");

        titlelist.add("我们新增了一个常用导航Tab~");
        titlelist.add("送你一个暖心的Mock API工具");
        titlelist.add("兄弟,要挑个项目学习下?");
        titlelist.add("看看别人的面试经,搞定面试");

    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_pic_item, null);
        TextView textView = (TextView) view.findViewById(R.id.tv_dec);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_img);
        textView.setText(titlelist.get(position));
        Glide.with(context).load(piclist.get(position)).into(imageView);
        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return piclist.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}


