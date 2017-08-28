package com.example.cleverlin.cate.activity;

import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.cleverlin.cate.R;
import com.example.cleverlin.cate.adapter.viewpager.HomeAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity {


    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @BindView(R.id.item_weixin)
    ImageView item_weixin;
    @BindView(R.id.item_tongxunlu)
    ImageView item_tongxunlu;
    @BindView(R.id.item_me)
    ImageView item_me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
     //   setCustomActionBar();
        init();
    }
    private void setCustomActionBar() {
        ActionBar.LayoutParams lp =new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        View mActionBarView = LayoutInflater.from(this).inflate(R.layout.actionbar_title, null);
        ActionBar actionBar = getActionBar();
        actionBar.setCustomView(mActionBarView, lp);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = this.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(this.getResources().getColor(R.color.colorMain));

                //底部导航栏
                //window.setNavigationBarColor(activity.getResources().getColor(colorResId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void init() {
        PagerAdapter adapter = new HomeAdapter(getSupportFragmentManager());
        viewpager.setCurrentItem(0);
        viewpager.setOffscreenPageLimit(3);
        viewpager.setAdapter(adapter);
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changeTextColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    @OnClick({R.id.item_weixin, R.id.item_tongxunlu, R.id.item_me})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.item_weixin:
                viewpager.setCurrentItem(0, true);
                break;
            case R.id.item_tongxunlu:
                viewpager.setCurrentItem(1, true);
                break;
            case R.id.item_me:
                viewpager.setCurrentItem(2, true);
                break;
        }
    }

    private void changeTextColor(int position) {
        if (position == 0) {
            item_weixin.setImageResource(R.mipmap.tab_home_pre);
            item_tongxunlu.setImageResource(R.mipmap.tab_calculator);
            item_me.setImageResource(R.mipmap.tab_personal);
        } else if (position == 1) {
            item_weixin.setImageResource(R.mipmap.tab_home);
            item_tongxunlu.setImageResource(R.mipmap.tab_calculator_pre);
            item_me.setImageResource(R.mipmap.tab_personal);
        } else if (position == 2) {
            item_weixin.setImageResource(R.mipmap.tab_home);
            item_tongxunlu.setImageResource(R.mipmap.tab_calculator);
            item_me.setImageResource(R.mipmap.tab_personal_pre);
        }
    }
}
