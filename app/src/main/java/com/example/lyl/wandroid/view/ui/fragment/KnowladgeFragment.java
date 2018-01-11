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
public class KnowladgeFragment extends Fragment {


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

}
