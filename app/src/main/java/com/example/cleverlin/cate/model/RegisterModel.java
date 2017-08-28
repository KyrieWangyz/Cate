package com.example.cleverlin.cate.model;

import com.example.cleverlin.cate.http.ApiService;
import com.example.cleverlin.cate.http.HttpManager;
import com.example.cleverlin.cate.model.viewInterface.RegisterModelInterface;
import com.example.cleverlin.cate.presenter.preinterface.OnRegisterListener;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cleverlin on 2017/8/13.
 */

public class RegisterModel implements RegisterModelInterface {
    @Override
    public void register(String username, String password, String gender, int age, double height, double weight, final OnRegisterListener registerListener) {
        HttpManager manager=new HttpManager();
        ApiService apiService=manager.getRetrofit(manager.getOkHttpClient()).create(ApiService.class);

        apiService.RegisterUser(username,password,gender,age,height,weight).enqueue(new Callback<RequestBody>() {
            @Override
            public void onResponse(Call<RequestBody> call, Response<RequestBody> response) {
                registerListener.registerSuccess();
            }

            @Override
            public void onFailure(Call<RequestBody> call, Throwable t) {
                registerListener.registernFailed(t.getMessage());
            }
        });
    }
}
