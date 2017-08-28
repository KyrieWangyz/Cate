package com.example.cleverlin.cate.http;

import com.example.cleverlin.cate.bean.AllBean;
import com.example.cleverlin.cate.bean.Article;
import com.example.cleverlin.cate.bean.RecommendBean;
import com.example.cleverlin.cate.bean.ResultBean;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by cleverlin on 2017/8/11.
 */

public interface ApiService {
//    http://115.159.55.206/forAndroidSelf/
//    http://119.29.245.39/foodApp/interface/searchByKeyword.php
    public static final String BASE_URL = "http://115.159.55.206/forAndroidSelf/";
    public static final String BASE_URLPRC = "http://119.29.245.39/foodApp/interface/";
    @FormUrlEncoded
    @POST("...待定...")
    Call<RequestBody> LoginUser(@Field("username")String username, @Field("password")String password);

    @FormUrlEncoded
    @POST("...待定...")
    Call<RequestBody> RegisterUser(@Field("username")String username,
                                   @Field("password")String password,
                                   @Field("gender")String gender,
                                   @Field("age")int age,
                                   @Field("height")double height,
                                   @Field("weight")double weight
                                   );

    @POST("php/Article.php")
    public Call<Article<AllBean>> getArticles();


    @POST("php/recommend.php")
    public Call<Article<RecommendBean>> getRecMenu();
    @FormUrlEncoded
    @POST("searchByKeyword.php")
    public Call<Article<ResultBean>> getResult(@Field("keywords")String keywords);

}
