package com.example.dsm_025.whatinconveniencestore.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.dsm_025.whatinconveniencestore.R;
import com.example.dsm_025.whatinconveniencestore.data.FoodItem;
import com.example.dsm_025.whatinconveniencestore.util.ChooserController;

import java.util.ArrayList;

/**
 * Created by dsm_025 on 2017-06-21.
 */

public class GridImageAdapter extends BaseAdapter {
    private Context mContext;

    ArrayList<FoodItem> mThumbIds;

    public GridImageAdapter(Context context) {
        mContext = context;

        mThumbIds = new ArrayList<FoodItem>() {{
            add(new FoodItem(mContext.getResources().getDrawable(R.drawable.ic_android_black_24dp), true));
            add(new FoodItem(mContext.getResources().getDrawable(R.drawable.ic_home_outline_black_24dp), true));
            add(new FoodItem(mContext.getResources().getDrawable(R.drawable.ic_pot_mix_grey600_24dp), true));
            add(new FoodItem(mContext.getResources().getDrawable(R.drawable.ic_dish), true));
        }};

        ChooserController.setmOnMyItemUnSelected(new ChooserController.OnMyItemUnSelected() {
            @Override
            public void onItemClicked(FoodItem item) {
                item.setVisibleState(true);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getCount() {
        return mThumbIds.size();
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ImageView imageView = new ImageView(mContext);
        imageView.setImageDrawable(mThumbIds.get(position).getFoodImageDrawable());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setVisibility(mThumbIds.get(position).isVisibleState() ? View.VISIBLE : View.INVISIBLE);
        imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
        mThumbIds.get(position).setFoodImageDrawable(imageView.getDrawable());

        imageView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(final View v) {
                mThumbIds.get(position).setVisibleState(false);
                v.setVisibility(View.INVISIBLE);
//                v.animate().alpha(1).setDuration(1000).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() {
//                    @Override
//                    public void run() {
//                        v.animate().alpha(0).setDuration(1000).setInterpolator(new AccelerateInterpolator()).start();
//                    }
//                }).start();

                ChooserController.mOnFoodItemSelected.onItemClicked(mThumbIds.get(position));
                notifyDataSetChanged();

//                Animation fadeOut = new AlphaAnimation(1, 0);
//                fadeOut.setDuration(1000);
//
//                AnimationSet animation = new AnimationSet(true);
//                animation.addAnimation(fadeOut);
//                imageView.setAnimation(animation);
            }
        });
        return imageView;
    }

    private FoodItem getItemFromDrawable(Drawable drawable){
        for(FoodItem item : mThumbIds){
            if(item.getFoodImageDrawable().equals(drawable)){
                return item;
            }
        }
        return null;
    }
}
