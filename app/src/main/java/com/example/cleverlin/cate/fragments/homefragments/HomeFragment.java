package com.example.cleverlin.cate.fragments.homefragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.cleverlin.cate.R;
import com.example.cleverlin.cate.activity.EveRecommend;
import com.example.cleverlin.cate.activity.RecordActivity;
import com.example.cleverlin.cate.activity.SearchActivity;
import com.example.cleverlin.cate.adapter.viewholder.ArticleAdapter;
import com.example.cleverlin.cate.adapter.SpaceItemDecoration;
import com.example.cleverlin.cate.bean.AllBean;
import com.example.cleverlin.cate.bean.BannersBean;
import com.example.cleverlin.cate.imageloader.ImageLoader;
import com.example.cleverlin.cate.activity.viewInterface.ArticleContract;
import com.example.cleverlin.cate.other.BannerLayout;
import com.example.cleverlin.cate.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by cleverlin on 2017/8/17.
 */

public class HomeFragment extends Fragment implements ArticleContract.View {
    @BindView(R.id.banner)
    BannerLayout banner;
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    Unbinder unbinder;
    List<String> image = new ArrayList<>();
    @BindView(R.id.recommend)
    LinearLayout recommend;
    @BindView(R.id.search)
    LinearLayout search;
    @BindView(R.id.personal)
    LinearLayout personal;
    @BindView(R.id.recommendBnt)
    ImageButton recommendBnt;
    @BindView(R.id.recommendTvw)
    TextView recommendTvw;
    @BindView(R.id.searchBtn)
    ImageButton searchBtn;
    @BindView(R.id.searchTvw)
    TextView searchTvw;
    @BindView(R.id.personalBtn)
    ImageButton personalBtn;
    @BindView(R.id.personalTvw)
    TextView personalTvw;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;


    private ArticleAdapter mAdapter;
    private ProgressDialog progressDialog;
    private HomePresenter articlePresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_home, container, false);

        unbinder = ButterKnife.bind(this, view);
        progressDialog = new ProgressDialog(getContext());
        articlePresenter = new HomePresenter(this);
        initData();
        mAdapter = new ArticleAdapter(getContext(), null);
        recycleView.setAdapter(mAdapter);
        return view;
    }


    private void initData() {
        articlePresenter.requestDatas();
    }

    private void initRecycleView(List<AllBean> datas) {
        int spacingInPixels=getResources().getDimensionPixelSize(R.dimen.space);
        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleView.addItemDecoration(new SpaceItemDecoration(spacingInPixels,true));
        recycleView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new ArticleAdapter(getContext(), datas);
        recycleView.setAdapter(mAdapter);
    }

    private void initBanners(List<BannersBean> banners) {
        banner.setImageLoader(new BannerLayout.ImageLoader() {
            @Override
            public void displayImage(Context context, String path, ImageView imageView) {
                ImageLoader.load(path, imageView);
            }
        });
        for (int i = 0; i < banners.size(); i++) {
            image.add(banners.get(i).getBanner());
        }
        banner.setViewUrls(image);
    }

    @Override
    public void showResult(List<AllBean> datas, List<BannersBean> banners) {

        initRecycleView(datas);
        initBanners(banners);
    }

    @Override
    public void showNodata() {
        Toast.makeText(getContext(), "暂时无数据，请吃完饭再来", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getContext(), "服务器开小差了：" + msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLodading() {
        progressDialog.show();
    }

    @Override
    public void dimissLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    private void toActivity(Class mClass){
        Intent intent=new Intent(getActivity(),mClass);
        startActivity(intent);
    }

    @OnClick({R.id.recommendBnt, R.id.recommendTvw, R.id.searchBtn, R.id.searchTvw, R.id.personalBtn, R.id.personalTvw})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.recommendBnt:
                toActivity(EveRecommend.class);
                break;
            case R.id.recommendTvw:
                toActivity(EveRecommend.class);

                break;
            case R.id.searchBtn:
                toActivity(SearchActivity.class);
                break;
            case R.id.searchTvw:
                toActivity(SearchActivity.class);
                break;
            case R.id.personalBtn:
                toActivity(RecordActivity.class);
                break;
            case R.id.personalTvw:
                toActivity(RecordActivity.class);
                break;
        }
    }
}
