package com.example.dsm_025.whatinconveniencestore.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.dsm_025.whatinconveniencestore.R;
import com.example.dsm_025.whatinconveniencestore.adapter.CombinationAdapter;
import com.example.dsm_025.whatinconveniencestore.data.FoodItem;
import com.example.dsm_025.whatinconveniencestore.handler.SendSelectInfoHandler;
import com.example.dsm_025.whatinconveniencestore.util.ChooserController;

import java.util.ArrayList;

/**
 * Created by dsm_025 on 2017-06-21.
 */

public class CombinationFragment extends Fragment {
    ArrayList<FoodItem> foodItemList;
    View rootView;
    ViewPager firstPager;
    ViewPager secondPager;
    Handler mHandler;
    ImageView mImgDish;
    TabLayout kindTab;
    RelativeLayout bottomLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new SendSelectInfoHandler();
        foodItemList = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_combination, container, false);
        init();
        return rootView;
    }

    private void init() {
        kindTab = (TabLayout) rootView.findViewById(R.id.tab_layout);
        mImgDish = (ImageView) rootView.findViewById(R.id.img_dish);
        firstPager = (ViewPager) rootView.findViewById(R.id.firstPager);
        secondPager = (ViewPager) rootView.findViewById(R.id.secondPager);
        bottomLayout = (RelativeLayout) rootView.findViewById(R.id.bottom_layout);

        kindTab.addTab(kindTab.newTab().setText("Tab 1"));
        kindTab.addTab(kindTab.newTab().setText("Tab 2"));
        kindTab.setTabGravity(TabLayout.GRAVITY_FILL);

        final CombinationAdapter adapter = new CombinationAdapter
                (getActivity().getSupportFragmentManager(), kindTab.getTabCount());

        firstPager.setAdapter(adapter);
        secondPager.setAdapter(adapter);

        ChooserController.setmOnFoodItemSelected(onFoodItemSelected);
        kindTab.setOnTabSelectedListener(kindTabSelectListener);
        mImgDish.setOnClickListener(dishClickListener);
    }

    private FoodItem getFoodItemFromDrawable(Drawable drawable) {
        for (FoodItem item : foodItemList) {
            if (item.getFoodImageDrawable().equals(drawable)) {
                return item;
            }
        }
        return null;
    }

    ChooserController.OnFoodItemSelected onFoodItemSelected = new ChooserController.OnFoodItemSelected() {
        @Override
        public void onItemClicked(FoodItem item) {
            //TODO 접시에 이미지 띄우기
            foodItemList.add(item);
            LinearLayout parentLayout = new LinearLayout(getContext());

            RelativeLayout.LayoutParams imageWrapParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            imageWrapParams.addRule(RelativeLayout.CENTER_IN_PARENT, 1);
            parentLayout.setLayoutParams(imageWrapParams);

            ImageView imageView = new ImageView(getContext());
            imageView.setImageDrawable(item.getFoodImageDrawable());
            parentLayout.addView(imageView);
            bottomLayout.addView(parentLayout);
        }
    };

    View.OnClickListener dishClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LinearLayout linearLayout = (LinearLayout) bottomLayout.getChildAt(bottomLayout.getChildCount() - 1);
            bottomLayout.removeView(linearLayout);
            ImageView imageView = (ImageView) linearLayout.getChildAt(0);
            FoodItem item = getFoodItemFromDrawable(imageView.getDrawable());
            ChooserController.mOnMyItemUnSelected.onItemClicked(item);
            foodItemList.remove(item);
        }
    };

    TabLayout.OnTabSelectedListener kindTabSelectListener = new TabLayout.OnTabSelectedListener() {
        public void onTabSelected(TabLayout.Tab tab) {
            switch (tab.getPosition()) {
                case 0:
                    firstPager.setVisibility(View.VISIBLE);
                    break;
                case 1:
                    secondPager.setVisibility(View.VISIBLE);
                    break;
            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
            switch (tab.getPosition()) {
                case 0:
                    firstPager.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    secondPager.setVisibility(View.INVISIBLE);
                    break;
            }
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };
}
