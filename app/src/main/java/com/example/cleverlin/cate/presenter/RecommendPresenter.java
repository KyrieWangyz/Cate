package com.example.cleverlin.cate.presenter;

import com.example.cleverlin.cate.activity.EveRecommend;
import com.example.cleverlin.cate.activity.viewInterface.RecView;
import com.example.cleverlin.cate.bean.Article;
import com.example.cleverlin.cate.bean.RecommendBean;
import com.example.cleverlin.cate.model.RecommendModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cleverlin on 2017/8/19.
 */

public class RecommendPresenter {
    private RecommendModel recommendModel;
    private RecView recommendAct;


    public RecommendPresenter(RecView recommendAct) {
        this.recommendAct = recommendAct;
        recommendModel=new RecommendModel();
    }

    public void requestMenu(){
        recommendAct.showLoading();
        recommendModel.recommendMenu(new Callback<Article<RecommendBean>>() {
            @Override
            public void onResponse(Call<Article<RecommendBean>> call, Response<Article<RecommendBean>> response) {
                recommendAct.showResult(response.body().getFoodmenu());
            }

            @Override
            public void onFailure(Call<Article<RecommendBean>> call, Throwable t) {
                recommendAct.showError(t.getMessage());
            }
        });
        recommendAct.hideLoading();
    }
}
