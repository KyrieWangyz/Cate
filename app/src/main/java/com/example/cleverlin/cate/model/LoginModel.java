package com.example.cleverlin.cate.model;

import com.example.cleverlin.cate.bean.User;
import com.example.cleverlin.cate.http.ApiService;
import com.example.cleverlin.cate.http.HttpManager;
import com.example.cleverlin.cate.model.viewInterface.LoginModelInterFace;
import com.example.cleverlin.cate.presenter.preinterface.OnLoginListener;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cleverlin on 2017/8/11.
 */

public class LoginModel implements LoginModelInterFace {
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {

        HttpManager manager = new HttpManager();

        ApiService apiService =manager.getRetrofit(manager.getOkHttpClient()).create(ApiService.class);


        apiService.LoginUser(username,password).enqueue(new Callback<RequestBody>() {
            @Override
            public void onResponse(Call<RequestBody> call, Response<RequestBody> response) {
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                loginListener.loginSuccess(user);
            }

            @Override
            public void onFailure(Call<RequestBody> call, Throwable t) {
                loginListener.loginFailed(t.getMessage());
            }
        });
    }
}
