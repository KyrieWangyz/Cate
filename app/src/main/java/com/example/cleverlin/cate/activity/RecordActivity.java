package com.example.cleverlin.cate.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ImageButton;

import com.example.cleverlin.cate.R;
import com.example.cleverlin.cate.adapter.viewpager.RecordAdapter;
import com.example.cleverlin.cate.view.SliderLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecordActivity extends FragmentActivity {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.record_viewpager)
    ViewPager recordViewpager;
    @BindView(R.id.slider)
    SliderLayout slider;
    @BindView(R.id.returnAct)
    ImageButton returnAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        ButterKnife.bind(this);
        initViewPager();
    }

    private void initViewPager() {
        PagerAdapter pagerAdapter = new RecordAdapter(getSupportFragmentManager());
        recordViewpager.setCurrentItem(0);
        recordViewpager.setOffscreenPageLimit(5);
        recordViewpager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(recordViewpager);

        recordViewpager.clearOnPageChangeListeners();
        recordViewpager.addOnPageChangeListener(new SliderLayout.SliderOnPageChangeListener(tabLayout, slider));

    }

    @OnClick(R.id.returnAct)
    public void onViewClicked() {
        Intent intent=new Intent(this,PersonActivity.class);
        startActivity(intent);
        this.finish();
    }
}
