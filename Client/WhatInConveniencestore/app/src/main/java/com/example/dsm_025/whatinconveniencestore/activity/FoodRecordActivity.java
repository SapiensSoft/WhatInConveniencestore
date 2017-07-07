package com.example.dsm_025.whatinconveniencestore.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dsm_025.whatinconveniencestore.R;
import com.example.dsm_025.whatinconveniencestore.adapter.MyRecyclerViewAdapter;
import com.example.dsm_025.whatinconveniencestore.data.FeedItem;
import com.example.dsm_025.whatinconveniencestore.utile.DividerItemDecoration;

import java.util.ArrayList;

public class FoodRecordActivity extends AppCompatActivity {
    private RecyclerView recordListView;
    private ArrayList<FeedItem> itemList;
    private MyRecyclerViewAdapter adapter;
    private LinearLayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_foodrecord);
        recordListView = (RecyclerView) findViewById(R.id.foodlist_recyclerview);
        recordListView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recordListView.setLayoutManager(mLayoutManager);


        recordListView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), 1));


        itemList = new ArrayList<FeedItem>(){{
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
            add(new FeedItem("first", "first"));
        }};

        adapter = new MyRecyclerViewAdapter(itemList, getApplicationContext());
        recordListView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MyRecyclerViewAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {

            }
        });
    }

}
