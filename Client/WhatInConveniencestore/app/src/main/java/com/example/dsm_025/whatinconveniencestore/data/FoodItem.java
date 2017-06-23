package com.example.dsm_025.whatinconveniencestore.data;

import android.graphics.drawable.Drawable;

/**
 * Created by dsm_025 on 2017-06-23.
 */

public class FoodItem {
    private String name;
    private int price;
    private String description;
    private String storeName;
    private String kind;
    private boolean visibleState;
    private Drawable foodImageDrawable;

    public FoodItem(Drawable foodImageResource, boolean visibleState) {
        this.foodImageDrawable = foodImageResource;
        this.visibleState = visibleState;

    }

    public boolean isVisibleState() {
        return visibleState;
    }

    public void setVisibleState(boolean visibleState) {
        this.visibleState = visibleState;
    }

    public Drawable getFoodImageDrawable() {
        return foodImageDrawable;
    }

    public void setFoodImageDrawable(Drawable foodImageDrawable) {
        this.foodImageDrawable = foodImageDrawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
