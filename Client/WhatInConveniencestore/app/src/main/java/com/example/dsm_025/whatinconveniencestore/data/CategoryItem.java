package com.example.dsm_025.whatinconveniencestore.data;

import android.graphics.drawable.Drawable;

/**
 * Created by dsm2016 on 2017-07-02.
 */

public class CategoryItem {
    private String itemName;
    private int drawable;

    public CategoryItem(String name,int drawable){
        this.drawable=drawable;
        this.itemName=name;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

}
