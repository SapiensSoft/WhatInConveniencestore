package com.example.dsm_025.whatinconveniencestore.activity;

import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.example.dsm_025.whatinconveniencestore.ContentFragment;
import com.example.dsm_025.whatinconveniencestore.R;
import com.example.dsm_025.whatinconveniencestore.databinding.ActivityMainBinding;
import com.example.dsm_025.whatinconveniencestore.fragment.CategoryFragment;
import com.example.dsm_025.whatinconveniencestore.fragment.CombinationFragment;
import com.example.dsm_025.whatinconveniencestore.fragment.PostingFragment;
import com.example.dsm_025.whatinconveniencestore.fragment.ProfileFragment;

import java.util.ArrayList;
import java.util.List;

import yalantis.com.sidemenu.interfaces.Resourceble;
import yalantis.com.sidemenu.interfaces.ScreenShotable;
import yalantis.com.sidemenu.model.SlideMenuItem;
import yalantis.com.sidemenu.util.ViewAnimator;

public class MainActivity extends
        ActionBarActivity implements ViewAnimator.ViewAnimatorListener{
    ActivityMainBinding binding;
    private ActionBarDrawerToggle drawerToggle;
    private List<SlideMenuItem> list = new ArrayList<>();
    private ContentFragment contentFagment;
    private ViewAnimator viewAnimator;
    private int res = R.drawable.music;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        contentFagment = ContentFragment.newInstance(R.drawable.music);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, contentFagment)
                .commit();
        binding.drawerLayout.setScrimColor(Color.TRANSPARENT);
        binding.leftDrawer.setDrawingCacheBackgroundColor(Color.RED);
        binding.leftDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.drawerLayout.closeDrawers();
            }
        });

        setActionBar();
        createMenuList();
        viewAnimator = new ViewAnimator<>(this, list, contentFagment, binding.drawerLayout, this);

        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));
    }

    private void createMenuList(){
        SlideMenuItem menuItem0 = new SlideMenuItem(ContentFragment.CLOSE, R.drawable.ic_close_white_48dp, true);
        list.add(menuItem0);
        SlideMenuItem menuItem1 = new SlideMenuItem(ContentFragment.HOME, R.drawable.ic_home_outline_white_48dp, true);
        list.add(menuItem1);
        SlideMenuItem menuItem2 = new SlideMenuItem(ContentFragment.POT, R.drawable.ic_pot_mix_white_48dp, true);
        list.add(menuItem2);
        SlideMenuItem menuItem3 = new SlideMenuItem(ContentFragment.SEARCH, R.drawable.ic_magnify_white_48dp, true);
        list.add(menuItem3);
        SlideMenuItem menuItem4 = new SlideMenuItem(ContentFragment.CASE, R.drawable.ic_format_list_numbers_white_48dp, true);
        list.add(menuItem4);
        SlideMenuItem menuItem5 = new SlideMenuItem(ContentFragment.SHOP, R.drawable.ic_account_white_48dp, true);
        list.add(menuItem5);
        SlideMenuItem menuItem6 = new SlideMenuItem(ContentFragment.PARTY, R.drawable.item_up, false);
        list.add(menuItem6);
        SlideMenuItem menuItem7 = new SlideMenuItem(ContentFragment.MOVIE, R.drawable.item_up, false);
        list.add(menuItem7);
    }

    private void setActionBar(){
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        drawerToggle = new ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                binding.toolbar,
                R.string.open,
                R.string.close
        ){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                binding.leftDrawer.removeAllViews();
                binding.leftDrawer.invalidate();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                if(slideOffset > 0.6 && binding.leftDrawer.getChildCount() == 0){
                    viewAnimator.showMenuContent();
                }
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        binding.drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        switch (item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private ScreenShotable replaceFragment(ScreenShotable screenShotable, int topPosition){
//        View view = findViewById(R.id.content_frame);
//        int finalRadius = Math.max(view.getWidth(), view.getHeight());
//        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(view, 0,topPosition, 0, finalRadius);
//        animator.setInterpolator(new AccelerateDecelerateInterpolator());
//        animator.setDuration(ViewAnimator.CIRCULAR_REVEAL_ANIMATION_DURATION);
//
//        findViewById(R.id.content_overlay).setBackgroundDrawable(new BitmapDrawable(getResources(), screenShotable.getBitmap()));
//        animator.start();
//        ContentFragment contentFagment = ContentFragment.newInstance(this.res);
//        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFagment).addToBackStack(null).commit();
        return contentFagment;
    }

    @Override
    public ScreenShotable onSwitch(Resourceble slideMenuItem, ScreenShotable screenShotable, int position) {
        //TODO 여기서 Fragment 전환 작업 하기
        switch (slideMenuItem.getName()){
            case ContentFragment.CLOSE:
                return screenShotable;
            case ContentFragment.POT:
                CombinationFragment fragment = new CombinationFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).addToBackStack(null).commit();
                return screenShotable;
            case ContentFragment.SEARCH:
                CategoryFragment categoryFragment=new CategoryFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,categoryFragment).addToBackStack(null).commit();
                return screenShotable;
            case ContentFragment.SHOP:
                ProfileFragment fragment1 = new ProfileFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment1).addToBackStack(null).commit();
            case ContentFragment.CASE:
                PostingFragment postingFragment = new PostingFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,postingFragment).addToBackStack(null).commit();
                return screenShotable;
            default:
                ContentFragment contentFragment = ContentFragment.newInstance(this.res);
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).addToBackStack(null).commit();
                return replaceFragment(screenShotable, position);
        }
    }

    @Override
    public void disableHomeButton() {
        getSupportActionBar().setHomeButtonEnabled(false);
    }

    @Override
    public void enableHomeButton() {
        getSupportActionBar().setHomeButtonEnabled(true);
        binding.drawerLayout.closeDrawers();
    }

    @Override
    public void addViewToContainer(View view) {
        binding.leftDrawer.addView(view);
    }
}
