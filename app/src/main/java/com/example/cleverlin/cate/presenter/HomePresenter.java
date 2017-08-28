package com.example.cleverlin.cate.presenter;



import com.example.cleverlin.cate.bean.AllBean;
import com.example.cleverlin.cate.bean.Article;
import com.example.cleverlin.cate.model.ArticleModel;
import com.example.cleverlin.cate.activity.viewInterface.ArticleContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cleverlin on 2017/8/16.
 */

public class HomePresenter implements ArticleContract.Presenter {
    private ArticleModel articleModel;
    private ArticleContract.View mView;

    public HomePresenter(ArticleContract.View mView) {
        this.mView = mView;
        articleModel=new ArticleModel();
    }

    @Override
    public void requestDatas() {
        mView.showLodading();
        articleModel.getArticle(new Callback<Article<AllBean>>() {
            @Override
            public void onResponse(Call<Article<AllBean>> call, Response<Article<AllBean>> response) {
                if (response!=null){
                    mView.showResult(response.body().getAll(),response.body().getBanners());

                }else{
                    mView.showNodata();
                }
                mView.dimissLoading();
            }

            @Override
            public void onFailure(Call<Article<AllBean>> call, Throwable t) {
                mView.dimissLoading();
                mView.showError(t.getMessage());
            }
        });

    }
}
