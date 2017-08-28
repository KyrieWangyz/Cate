package com.example.cleverlin.cate.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.cleverlin.cate.R;
import com.example.cleverlin.cate.adapter.viewpager.SearchAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cleverlin on 2017/8/19.
 */

public class SearchActivity extends AppCompatActivity {
    @BindView(R.id.search_viewpager)
    ViewPager searchViewpager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_search);
        ButterKnife.bind(this);
        initSearch();
    }

    private void initSearch() {
        PagerAdapter adapter = new SearchAdapter(getSupportFragmentManager());
        searchViewpager.setAdapter(adapter);
        tabLayout.setupWithViewPager(searchViewpager);
    }
}
