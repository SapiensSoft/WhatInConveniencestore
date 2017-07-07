package com.example.dsm_025.whatinconveniencestore.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dsm_025.whatinconveniencestore.R;
import com.example.dsm_025.whatinconveniencestore.activity.FoodRecordActivity;
import com.example.dsm_025.whatinconveniencestore.activity.MainActivity;
import com.example.dsm_025.whatinconveniencestore.activity.PostingRecordActivity;
import com.example.dsm_025.whatinconveniencestore.activity.ReviewRecordActvity;


public class ProfileFragment extends Fragment {
    LinearLayout btn_FirstActivity;
    LinearLayout btn_SecondActivity;
    LinearLayout btn_ThirdActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        btn_FirstActivity = (LinearLayout) rootView.findViewById(R.id.btn_FirstActivity);
        btn_FirstActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FoodRecordActivity.class);
                Toast.makeText(getActivity(), "Move FoodRecordActivity", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        btn_SecondActivity = (LinearLayout) rootView.findViewById(R.id.btn_SecondActivity);
        btn_SecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PostingRecordActivity.class);
                Toast.makeText(getActivity(), "Move PostingRecordActivity", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        btn_ThirdActivity = (LinearLayout) rootView.findViewById(R.id.btn_ThirdActivity);
        btn_ThirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ReviewRecordActvity.class);
                Toast.makeText(getActivity(), "Move ReviewRecordActvity", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        return rootView;
    }
}









