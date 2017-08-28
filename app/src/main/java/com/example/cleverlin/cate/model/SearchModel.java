package com.example.cleverlin.cate.model;

import com.example.cleverlin.cate.bean.Article;
import com.example.cleverlin.cate.bean.ResultBean;
import com.example.cleverlin.cate.http.ApiService;
import com.example.cleverlin.cate.http.HttpManager;

import retrofit2.Callback;

/**
 * Created by cleverlin on 2017/8/22.
 */

public class SearchModel  {//getRetrofitPRC
    public void getSearchResult(Callback<Article<ResultBean>> callback, String keywords){
        HttpManager httpManager=new HttpManager();
        ApiService apiService=httpManager.getRetrofitPRC(httpManager.getOkHttpClient()).create(ApiService.class);
        apiService.getResult(keywords).enqueue(callback);
    }
}
