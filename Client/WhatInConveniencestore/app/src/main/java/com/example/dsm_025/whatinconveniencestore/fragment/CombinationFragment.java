package com.example.dsm_025.whatinconveniencestore.fragment;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dsm_025.whatinconveniencestore.R;
import com.example.dsm_025.whatinconveniencestore.adapter.CombinationFoodItemAdapter;
import com.example.dsm_025.whatinconveniencestore.data.FoodItem;

import java.util.ArrayList;

/**
 * Created by dsm_025 on 2017-06-21.
 */

public class CombinationFragment extends Fragment {
    private ArrayList<FoodItem> foodItemList;
    private View rootView;
    private RecyclerView foodItemRecyclerView;
    private ImageView mImgDish;
    private TabLayout kindTab;
    private RelativeLayout topLayout;
    private RelativeLayout bottomLayout;
    private GridLayoutManager gridLayoutManager;
    private WindowManager wm;
    private WindowManager.LayoutParams wmParams;
    private ImageView dragView;
    private Drawable selectDrawable;
    private RelativeLayout rootLayout;
    private CombinationFoodItemAdapter adapter;
    private float dragOffsetX = -50;
    private float dragOffsetY = -50;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        foodItemList = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_combination, container, false);
        wm = getActivity().getWindowManager();
        wmParams = new WindowManager.LayoutParams();
        init();
        return rootView;
    }

    private void init() {
        kindTab = (TabLayout) rootView.findViewById(R.id.tab_layout);
        mImgDish = (ImageView) rootView.findViewById(R.id.img_dish);

        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        foodItemRecyclerView = (RecyclerView) rootView.findViewById(R.id.food_item_recycler);
        foodItemRecyclerView.setHasFixedSize(true);
        foodItemRecyclerView.setLayoutManager(gridLayoutManager);
        rootLayout = (RelativeLayout) rootView.findViewById(R.id.root_view);
        bottomLayout = (RelativeLayout) rootView.findViewById(R.id.bottom_layout);
        topLayout = (RelativeLayout) rootView.findViewById(R.id.top_layout);

        kindTab.addTab(kindTab.newTab().setText("Tab 1"));
        kindTab.addTab(kindTab.newTab().setText("Tab 2"));
        kindTab.setTabGravity(TabLayout.GRAVITY_FILL);

        adapter = new CombinationFoodItemAdapter(getActivity(), new ArrayList<FoodItem>(){{
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_android_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_pot_mix_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_18dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_36dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_android_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_pot_mix_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_18dp), "햄버거",true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_36dp), "햄버거", true));
        }});

        foodItemRecyclerView.setAdapter(adapter);

        kindTab.setOnTabSelectedListener(kindTabSelectListener);
        mImgDish.setOnClickListener(dishClickListener);
        adapter.setmOnItemClickListener(onItemClickListener);
        foodItemRecyclerView.setOnTouchListener(foodItemTouchListener);
    }

    private FoodItem getItemFromDrawable(Drawable drawable){
        for(FoodItem foodItem : foodItemList){
            if(foodItem.getFoodImageDrawable().equals(drawable)){
                return foodItem;
            }
        }
        return null;
    }

    View.OnTouchListener foodItemTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            float centerX = mImgDish.getX() + (mImgDish.getWidth() / 2);
            float centerY = mImgDish.getY() + (mImgDish.getHeight() / 2);
            float itemX = event.getX() - centerX;
            float itemY = (event.getY() - topLayout.getHeight()) - centerY;
            if(dragView != null) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dragView.setX(event.getX());
                        dragView.setY(event.getY());

                    case MotionEvent.ACTION_MOVE:
                        wmParams.x = (int) (event.getRawX() + dragOffsetX);
                        wmParams.y = (int) (event.getRawY() + dragOffsetY);
                        dragView.setX(event.getX() - dragView.getWidth() / 2);
                        dragView.setY(event.getY() - dragView.getHeight() / 2);

                        if (Math.pow((itemX), 2) + Math.pow((itemY), 2) < Math.pow(mImgDish.getWidth() / 2, 2)) {
                            mImgDish.setImageDrawable(getResources().getDrawable(R.drawable.dish_selected));
                        } else {
                            mImgDish.setImageDrawable(getResources().getDrawable(R.drawable.ic_dish));
                        }
//                    wm.updateViewLayout(dragView, wmParams);
                        break;
                    case MotionEvent.ACTION_UP:
                        if (Math.pow((itemX), 2) + Math.pow((itemY), 2) < Math.pow(mImgDish.getWidth() / 2, 2)) {
                            mImgDish.setImageDrawable(getResources().getDrawable(R.drawable.ic_dish));
//                        bottomLayout.addView();
                        } else {
                            FoodItem unSelectedItem = getItemFromDrawable(dragView.getDrawable());
                            adapter.unSelectItem(getItemFromDrawable(dragView.getDrawable()));
                            rootLayout.removeView(dragView);
                            foodItemList.remove(unSelectedItem);
                        }
                        dragView = null;
                        break;

                    default:
                        break;
                }
            }
            return false;
        }
    };

    CombinationFoodItemAdapter.OnItemClickListener onItemClickListener = new CombinationFoodItemAdapter.OnItemClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onItemClicked(FoodItem item, MotionEvent event) {
            foodItemList.add(item);
            System.out.println("X : " + event.getX() +  " Y : " + event.getY());
            selectDrawable = item.getFoodImageDrawable();

            wmParams = new WindowManager.LayoutParams();
            wmParams.gravity = Gravity.TOP | Gravity.LEFT;
            wmParams.x = (int) (event.getRawX() + dragOffsetX);
            wmParams.y = (int) (event.getRawY() + dragOffsetY);
            wmParams.width = 160;
            wmParams.height = 160;

            wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE// 不需获取焦点
                    | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE// 不需接受触摸事件
                    | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;// 保持设备常开，并保持亮度不变。

            wmParams.windowAnimations = 0;

            dragView = new ImageView(getActivity());
            dragView.setImageDrawable(selectDrawable);
            dragView.setBackgroundColor(Color.TRANSPARENT);
            dragView.setLayoutParams(wmParams);

            rootLayout.addView(dragView);
            dragView.setX((event.getX() * rootLayout.getWidth()) / foodItemRecyclerView.getWidth());
            dragView.setY((event.getY() * rootLayout.getHeight()) / foodItemRecyclerView.getHeight());
//            wm.addView(dragView, wmParams);
        }
    };

    private FoodItem getFoodItemFromDrawable(Drawable drawable) {
        for (FoodItem item : foodItemList) {
            if (item.getFoodImageDrawable().equals(drawable)) {
                return item;
            }
        }
        return null;
    }

    View.OnClickListener dishClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    TabLayout.OnTabSelectedListener kindTabSelectListener = new TabLayout.OnTabSelectedListener() {
        public void onTabSelected(TabLayout.Tab tab) {
            switch (tab.getPosition()) {
                case 0:
                    break;
                case 1:
                    break;
            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
            switch (tab.getPosition()) {
                case 0:
                    break;
                case 1:
                    break;
            }
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };
}
