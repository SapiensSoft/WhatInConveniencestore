package com.example.dsm_025.whatinconveniencestore.util;

import com.example.dsm_025.whatinconveniencestore.data.FoodItem;

/**
 * Created by dsm_025 on 2017-06-22.
 */

public class ChooserController {
    public interface OnFoodItemSelected {
        void onItemClicked(FoodItem item);
    }
    public static OnFoodItemSelected mOnFoodItemSelected;

    public static void setmOnFoodItemSelected(OnFoodItemSelected onFoodItemSelected){
        mOnFoodItemSelected = onFoodItemSelected;
    }

    public interface OnMyItemUnSelected {
        void onItemClicked(FoodItem item);
    }
    public static OnMyItemUnSelected mOnMyItemUnSelected;

    public static void setmOnMyItemUnSelected(OnMyItemUnSelected onMyItemUnSelected){
        mOnMyItemUnSelected = onMyItemUnSelected;
    }
}
