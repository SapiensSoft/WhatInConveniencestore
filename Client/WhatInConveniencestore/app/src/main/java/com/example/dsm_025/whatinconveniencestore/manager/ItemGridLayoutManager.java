package com.example.dsm_025.whatinconveniencestore.manager;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

/**
 * Created by dsm_025 on 2017-07-03.
 */

public class ItemGridLayoutManager extends GridLayoutManager{
    private boolean isScrollEnabled = true;

    public void setScrollEnabled(boolean flag){
        this.isScrollEnabled = flag;
    }

    public ItemGridLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
    }

    @Override
    public boolean canScrollHorizontally() {
        return isScrollEnabled && super.canScrollHorizontally();
    }
}
