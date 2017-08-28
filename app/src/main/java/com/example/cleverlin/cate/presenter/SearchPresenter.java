package com.example.cleverlin.cate.presenter;

import com.example.cleverlin.cate.bean.Article;
import com.example.cleverlin.cate.bean.ResultBean;
import com.example.cleverlin.cate.fragments.searchfragments.MaterialFragment;
import com.example.cleverlin.cate.http.ApiService;
import com.example.cleverlin.cate.http.HttpManager;
import com.example.cleverlin.cate.model.SearchModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cleverlin on 2017/8/22.
 */

public class SearchPresenter {
    private SearchModel searchModel;
    private MaterialFragment materialFragment;
    public SearchPresenter(MaterialFragment materialFragment) {
        this.searchModel = new SearchModel();
        this.materialFragment=materialFragment;
    }

    public void searchResult(String keywords){
       searchModel.getSearchResult(new Callback<Article<ResultBean>>() {
           @Override
           public void onResponse(Call<Article<ResultBean>> call, Response<Article<ResultBean>> response) {
                materialFragment.initResultData(response.body().getResult());
           }

           @Override
           public void onFailure(Call<Article<ResultBean>> call, Throwable t) {

           }
       },keywords);
    }
}
