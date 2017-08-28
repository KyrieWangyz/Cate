package com.example.cleverlin.cate.presenter;

import com.example.cleverlin.cate.bean.User;
import com.example.cleverlin.cate.model.LoginModel;
import com.example.cleverlin.cate.model.viewInterface.LoginModelInterFace;
import com.example.cleverlin.cate.activity.viewInterface.LoginView;
import com.example.cleverlin.cate.presenter.preinterface.OnLoginListener;

/**
 * Created by cleverlin on 2017/8/11.
 */

public class UserLoginPresenter {

    private LoginModelInterFace loginModel;
    private LoginView loginActivity;

    public UserLoginPresenter(LoginView loginActivity) {
        this.loginActivity = loginActivity;
        this.loginModel = new LoginModel();
    }
    public void Logining(){
        loginActivity.showLoading();
        loginModel.login(loginActivity.getUserName(), loginActivity.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(User user) {
                loginActivity.hideLoading();
                loginActivity.toMainActivity(user);

            }

            @Override
            public void loginFailed(String errorMessage) {
                loginActivity.hideLoading();
                loginActivity.showFailedError(errorMessage);

            }
        });
    }


}
