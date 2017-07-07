package com.example.dsm_025.whatinconveniencestore.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dsm_025.whatinconveniencestore.R;
import com.example.dsm_025.whatinconveniencestore.data.FeedItem;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView
        .Adapter<MyRecyclerViewAdapter
        .FeedItemHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<FeedItem> mDataset;
    private static MyClickListener myClickListener;
    private Context context;

    public static class FeedItemHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView title;
        TextView description;
        ImageView foodImage;

        public FeedItemHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            description = (TextView) itemView.findViewById(R.id.tv_desc);
            foodImage = (ImageView) itemView.findViewById(R.id.iv_food);

            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public MyRecyclerViewAdapter(ArrayList<FeedItem> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;
    }

    @Override
    public FeedItemHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        FeedItemHolder FeedItemHolder = new FeedItemHolder(view);
        return FeedItemHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(FeedItemHolder holder, int position) {
        holder.title.setText(mDataset.get(position).getmText1());
        holder.description.setText(mDataset.get(position).getmText2());
        holder.foodImage.setImageDrawable(context.getDrawable(R.drawable.chicken_leg));
    }

    public void addItem(FeedItem dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}