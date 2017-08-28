package com.example.cleverlin.cate.model;



import com.example.cleverlin.cate.bean.AllBean;
import com.example.cleverlin.cate.bean.Article;
import com.example.cleverlin.cate.http.ApiService;
import com.example.cleverlin.cate.http.HttpManager;

import retrofit2.Callback;

/**
 * Created by cleverlin on 2017/8/16.
 */

public class ArticleModel {
    public void getArticle(Callback<Article<AllBean>> callback){
        HttpManager manager=new HttpManager();
        ApiService apiService=manager.getRetrofit(manager.getOkHttpClient()).create(ApiService.class);
        apiService.getArticles().enqueue(callback);
    }
}
