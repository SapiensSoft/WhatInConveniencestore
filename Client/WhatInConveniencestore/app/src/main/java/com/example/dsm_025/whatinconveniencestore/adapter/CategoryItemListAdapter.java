package com.example.dsm_025.whatinconveniencestore.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dsm_025.whatinconveniencestore.R;
import com.example.dsm_025.whatinconveniencestore.data.CategoryItem;
import com.example.dsm_025.whatinconveniencestore.data.FoodItem;

import java.util.ArrayList;

/**
 * Created by dsm2016 on 2017-07-02.
 */

public class CategoryItemListAdapter extends RecyclerView.Adapter<CategoryItemListAdapter.ViewHolder> {
    private ArrayList<CategoryItem> itemList;
    private Context context;


    public CategoryItemListAdapter(final Context context, final ArrayList itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  v= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final CategoryItem item = itemList.get(position);

        holder.imageView.setImageResource(itemList.get(position).getDrawable());
        holder.itemName.setText(itemList.get(position).getItemName());
        holder.itemView.setBackgroundColor(item.isState() ? Color.BLUE: Color.WHITE);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.setState(!item.isState());
                notifyDataSetChanged();
            }
        });
    }



    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView itemName;
        ImageView imageView;

        public ViewHolder(View v){
            super(v);
            imageView=(ImageView) v.findViewById(R.id.categoryItemImage);
            itemName=(TextView) v.findViewById(R.id.categoryItemName);
        }
    }
}
