package com.example.dsm_025.whatinconveniencestore.fragment;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.dsm_025.whatinconveniencestore.R;
import com.example.dsm_025.whatinconveniencestore.adapter.CombinationFoodItemAdapter;
import com.example.dsm_025.whatinconveniencestore.data.FoodItem;
import com.example.dsm_025.whatinconveniencestore.listener.RecyclerItemClickListener;
import com.example.dsm_025.whatinconveniencestore.manager.ItemGridLayoutManager;

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
    private ItemGridLayoutManager gridLayoutManager;
    private WindowManager wm;
    private WindowManager.LayoutParams wmParams;
    private ImageView dragView;
    private Drawable selectDrawable;
    private RelativeLayout rootLayout;
    private CombinationFoodItemAdapter adapter;
    private float dragOffsetX = -50;
    private float dragOffsetY = -50;
    private boolean longClickState;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        foodItemList = new ArrayList<>();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_combination, container, false);
        wm = getActivity().getWindowManager();
        wmParams = new WindowManager.LayoutParams();
        init();
        return rootView;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void init() {
        kindTab = (TabLayout) rootView.findViewById(R.id.tab_layout);
        mImgDish = (ImageView) rootView.findViewById(R.id.img_dish);

        gridLayoutManager = new ItemGridLayoutManager(getActivity(), 2);
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

        adapter = new CombinationFoodItemAdapter(getActivity(), new ArrayList<FoodItem>() {{
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_android_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_pot_mix_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_18dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_36dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_android_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_pot_mix_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_18dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_36dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_android_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_pot_mix_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_18dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_36dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_android_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_pot_mix_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_18dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_36dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_android_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_pot_mix_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_18dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_36dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_android_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_pot_mix_black_24dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_18dp), "햄버거", true));
            add(new FoodItem(getResources().getDrawable(R.drawable.ic_home_outline_black_36dp), "햄버거", true));
        }});

        foodItemRecyclerView.setAdapter(adapter);
        kindTab.setOnTabSelectedListener(kindTabSelectListener);
        mImgDish.setOnClickListener(dishClickListener);
        foodItemRecyclerView.setOnTouchListener(foodItemTouchListener);
        foodItemRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), foodItemRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onLongItemClick(View v, int position) {
                FoodItem item = adapter.getItem(position);
                adapter.setItemVisible(item, false);

                foodItemList.add(item);
                System.out.println("X : " + v.getX() + " Y : " + v.getY());
                selectDrawable = item.getFoodImageDrawable();

                wmParams = new WindowManager.LayoutParams();
                wmParams.gravity = Gravity.TOP | Gravity.LEFT;
                wmParams.x = (int) (v.getX());
                wmParams.y = (int) (v.getY());
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
                dragView.setX(v.getX());
                dragView.setY(v.getY());
//                dragView.setX((v.getX() * rootLayout.getWidth()) / foodItemRecyclerView.getWidth());
//                dragView.setY((v.getY() * rootLayout.getHeight()) / foodItemRecyclerView.getHeight());

            }

            @Override
            public void onItemReleased(View view, int position) {
                Bundle args = new Bundle();
                args.putString("name", "참치 마요 타코");
                args.putString("price", "5600원");
                args.putString("writer", "hangole");
                DialogFragment fragment = new FoodInformationDialogFragment();
                fragment.setArguments(args);
                fragment.show(getFragmentManager(), "Search Filter");

            }

            @Override
            public void onTouch(View view, int position, MotionEvent event) {

            }
        }));
    }

    private FoodItem getItemFromDrawable(Drawable drawable) {
        for (FoodItem foodItem : foodItemList) {
            if (foodItem.getFoodImageDrawable().equals(drawable)) {
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
            if (dragView != null) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        gridLayoutManager.setScrollEnabled(false);
                        Log.d("onTouch: ", foodItemRecyclerView.getScrollX() + ", " + foodItemRecyclerView.getScrollY());
                        wmParams.x = (int) (event.getRawX() + dragOffsetX);
                        wmParams.y = (int) (event.getRawY() + dragOffsetY);
                        dragView.setX(event.getX() - dragView.getWidth() / 2);
                        dragView.setY(event.getY() - dragView.getHeight() / 2);

                        if (Math.pow((itemX), 2) + Math.pow((itemY), 2) < Math.pow(mImgDish.getWidth() / 2, 2)) {
                            mImgDish.setImageDrawable(getResources().getDrawable(R.drawable.dish_selected));
                        } else {
                            mImgDish.setImageDrawable(getResources().getDrawable(R.drawable.ic_dish));
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        gridLayoutManager.setScrollEnabled(true);
                        if (Math.pow((itemX), 2) + Math.pow((itemY), 2) < Math.pow(mImgDish.getWidth() / 2, 2)) {
                            mImgDish.setImageDrawable(getResources().getDrawable(R.drawable.ic_dish));
//                        bottomLayout.addView();
                        } else {
                            FoodItem unSelectedItem = getItemFromDrawable(dragView.getDrawable());
                            adapter.setItemVisible(getItemFromDrawable(dragView.getDrawable()), true);
                            rootLayout.removeView(dragView);
                            foodItemList.remove(unSelectedItem);
                        }
                        dragView = null;
                        break;
                    default:
                        break;
                }
            } else {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:
                }
            }
            return false;
        }
    };

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
