package com.example.dsm_025.whatinconveniencestore.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.dsm_025.whatinconveniencestore.R;
import com.example.dsm_025.whatinconveniencestore.adapter.CategoryItemListAdapter;
import com.example.dsm_025.whatinconveniencestore.data.CategoryItem;
import com.example.dsm_025.whatinconveniencestore.data.FoodItem;

import java.util.ArrayList;

/**
 * Created by dsm_025 on 2017-06-16.
 */

public class CategoryFragment extends Fragment {
    private TabLayout kindTab;
    private View rootView;
    private RecyclerView recyclerView;
    private WindowManager wm;
    private WindowManager.LayoutParams wmParams;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<CategoryItem> itemList;
    private CategoryItemListAdapter categoryItemListAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemList=new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_category, container, false);
        wm = getActivity().getWindowManager();
        wmParams = new WindowManager.LayoutParams();
        init();
        return rootView;
    }

    private void init() {
        kindTab = (TabLayout) rootView.findViewById(R.id.tab_layout);

        kindTab.addTab(kindTab.newTab().setText("Tab 1"));
        kindTab.addTab(kindTab.newTab().setText("Tab 2"));
        kindTab.addTab(kindTab.newTab().setText("Tab 3"));
        kindTab.setTabGravity(TabLayout.GRAVITY_FILL);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.categoryRecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);

        categoryItemListAdapter=new CategoryItemListAdapter(getActivity(),new ArrayList(){{
            add(new CategoryItem("김밥류",R.drawable.rice_ball_with_seaweed));
            add(new CategoryItem("육류",R.drawable.chicken_leg));
            add(new CategoryItem("면류",R.drawable.noodles));
            add(new CategoryItem("아이스크림류",R.drawable.ice_cream));
            add(new CategoryItem("과자류",R.drawable.biscuit));
            add(new CategoryItem("음료류",R.drawable.orange_juice));
        }});

        recyclerView.setAdapter(categoryItemListAdapter);
        kindTab.setOnTabSelectedListener(kindTabSelectListener);
    }

    CategoryItemListAdapter.OnItemClickListener clickListener= new CategoryItemListAdapter.OnItemClickListener() {
        @Override
        public void onItemClicked(FoodItem item, MotionEvent event) {

        }
    };

    private CategoryItem getItemFromDrawable(int image){
        for(CategoryItem categoryItem :itemList ){
            if(categoryItem.getDrawable()==image){ //int 라서 숫자비교
                return categoryItem;
            }
        }
        return null;
    }

    TabLayout.OnTabSelectedListener kindTabSelectListener = new TabLayout.OnTabSelectedListener() {
        public void onTabSelected(TabLayout.Tab tab) {
            switch (tab.getPosition()) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
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
                case 2:
                    break;
            }
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };
}
