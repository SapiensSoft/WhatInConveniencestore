package com.example.dsm_025.whatinconveniencestore.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.dsm_025.whatinconveniencestore.R;
import com.example.dsm_025.whatinconveniencestore.adapter.GridImageAdapter;

/**
 * Created by dsm_025 on 2017-06-21.
 */

public class TabFragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.tab_fragment_1, container, false);
        GridView gridView = (GridView) rootView.findViewById(R.id.grid_view);
        GridImageAdapter adapter = new GridImageAdapter(getActivity());
        gridView.setAdapter(adapter);
        return rootView;
    }
}