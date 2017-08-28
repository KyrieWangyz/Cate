package com.example.cleverlin.cate.model;

import com.example.cleverlin.cate.bean.Article;
import com.example.cleverlin.cate.bean.RecommendBean;
import com.example.cleverlin.cate.http.ApiService;
import com.example.cleverlin.cate.http.HttpManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cleverlin on 2017/8/19.
 */

public class RecommendModel {
    public void recommendMenu(Callback<Article<RecommendBean>> callback){
        HttpManager manager=new HttpManager();
        ApiService apiService=manager.getRetrofit(manager.getOkHttpClient()).create(ApiService.class);
        apiService.getRecMenu().enqueue(callback);
    }
}
