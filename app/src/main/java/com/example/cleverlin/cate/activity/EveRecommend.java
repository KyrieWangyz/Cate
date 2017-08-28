package com.example.cleverlin.cate.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.cleverlin.cate.R;
import com.example.cleverlin.cate.activity.viewInterface.RecView;
import com.example.cleverlin.cate.adapter.viewholder.RecommendAdapter;
import com.example.cleverlin.cate.adapter.SpaceItemDecoration;
import com.example.cleverlin.cate.bean.RecommendBean;
import com.example.cleverlin.cate.presenter.RecommendPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cleverlin on 2017/8/19.
 */

public class EveRecommend extends Activity implements RecView {
    @BindView(R.id.recycleview)
    RecyclerView recycleview;
    private RecommendPresenter recommendPresenter;
    private ProgressDialog progressDialog;

    private RecommendAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_everecommend);
        ButterKnife.bind(this);
        recommendPresenter = new RecommendPresenter(this);
        progressDialog=new ProgressDialog(this);

        //        rating.setNumStars(5);
        //        rating.setMax(100);
        //        rating.setRating((float) 1.5);
        //        rating.setStepSize((float) 0.5);
        initData();


    }

    private void initData() {
        recommendPresenter.requestMenu();
    }

    private void initRecyclerView(List<RecommendBean> datas) {
        mAdapter=new RecommendAdapter(this,datas);
        int spacingInPixels=getResources().getDimensionPixelSize(R.dimen.space);
        recycleview.addItemDecoration(new SpaceItemDecoration(spacingInPixels/2,false));
        recycleview.setLayoutManager(new GridLayoutManager(this,2));
        recycleview.setItemAnimator(new DefaultItemAnimator());

        recycleview.setAdapter(mAdapter);

    }

    @Override
    public void showResult(List<RecommendBean> datas) {
        initRecyclerView(datas);
    }


    @Override
    public void showNodata() {
        Toast.makeText(this,"暂时无数据",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
