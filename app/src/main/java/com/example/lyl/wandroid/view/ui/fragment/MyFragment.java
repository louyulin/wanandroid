package com.example.lyl.wandroid.view.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lyl.wandroid.R;

/**
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

}
