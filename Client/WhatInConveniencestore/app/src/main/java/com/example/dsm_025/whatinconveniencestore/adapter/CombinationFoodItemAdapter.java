package com.example.dsm_025.whatinconveniencestore.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dsm_025.whatinconveniencestore.R;
import com.example.dsm_025.whatinconveniencestore.data.FoodItem;

import java.util.List;

/**
 * Created by dsm_025 on 2017-06-21.
 */

public class CombinationFoodItemAdapter extends RecyclerView.Adapter<CombinationFoodItemAdapter.CombinationFoodItemViewHolder> {

    private List<FoodItem> itemList;
    private Context context;


    public CombinationFoodItemAdapter(Context context, List<FoodItem> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public CombinationFoodItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_list_item, null);
        CombinationFoodItemViewHolder rcv = new CombinationFoodItemViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(CombinationFoodItemViewHolder holder, int position) {
        final FoodItem item = itemList.get(position);
        holder.foodImage.setImageDrawable(item.getFoodImageDrawable());
        holder.foodName.setText(item.getName());
        holder.foodImage.setVisibility(item.isVisibleState() ? View.VISIBLE : View.INVISIBLE);
        holder.foodName.setVisibility(item.isVisibleState() ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class CombinationFoodItemViewHolder extends RecyclerView.ViewHolder{
        public ImageView foodImage;
        public TextView foodName;

        public CombinationFoodItemViewHolder(View itemView) {
            super(itemView);
            foodImage = (ImageView) itemView.findViewById(R.id.food_image);
            foodName = (TextView) itemView.findViewById(R.id.food_name);
        }
    }

    public FoodItem getItem(int position){
        return itemList.get(position);
    }

    public void setItemVisible(FoodItem item, boolean state){
        item.setVisibleState(state);
        notifyDataSetChanged();
    }
}
