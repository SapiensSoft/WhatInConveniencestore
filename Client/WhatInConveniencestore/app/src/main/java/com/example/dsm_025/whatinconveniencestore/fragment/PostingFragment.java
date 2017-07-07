package com.example.dsm_025.whatinconveniencestore.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dsm_025.whatinconveniencestore.R;
import com.example.dsm_025.whatinconveniencestore.activity.CategorySelectActivity;
import com.example.dsm_025.whatinconveniencestore.activity.MaterialSelectActivity;

import java.util.ArrayList;

public class PostingFragment extends Fragment {
    ImageView imageView1;
    ImageView imageView2;
    Button button1;
    Button button2;
    LinearLayout orderLayout;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posting, container, false);
        Button.OnClickListener Listener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        Toast.makeText(getActivity(), "버튼이 눌렸습니다2", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(getActivity(), CategorySelectActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.button2:
                        Toast.makeText(getActivity(), "버튼이 눌렸습니다3", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(getActivity(), MaterialSelectActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.imageView:
                        Toast.makeText(getActivity(), "버튼이 눌렸습니다4", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.imageView2:
                        LinearLayout paretLL = new LinearLayout(getActivity());
                        paretLL.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                        EditText editText = new EditText(getActivity());
                        editText.setHint((orderLayout.getChildCount()) + ".");
                        paretLL.addView(editText, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                        orderLayout.addView(paretLL);
                        Toast.makeText(getActivity(), "버튼이 눌렸습니다1", Toast.LENGTH_SHORT).show();
                }
            }
        };
        orderLayout = (LinearLayout) view.findViewById(R.id.orderLayout);
        imageView1 = (ImageView) view.findViewById(R.id.imageView);
        imageView2 = (ImageView) view.findViewById(R.id.imageView2);
        button1 = (Button) view.findViewById(R.id.button1);
        button2 = (Button) view.findViewById(R.id.button2);
        button1.setOnClickListener(Listener);
        button2.setOnClickListener(Listener);
        imageView1.setOnClickListener(Listener);
        imageView2.setOnClickListener(Listener);
        return view;
    }
}
