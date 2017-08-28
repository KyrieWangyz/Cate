package com.example.cleverlin.cate.presenter;

import com.example.cleverlin.cate.activity.viewInterface.RegisterView;
import com.example.cleverlin.cate.model.RegisterModel;
import com.example.cleverlin.cate.model.viewInterface.RegisterModelInterface;
import com.example.cleverlin.cate.presenter.preinterface.OnRegisterListener;

/**
 * Created by cleverlin on 2017/8/13.
 */

public class RegisterPresenter {
    private RegisterView registerView;
    private RegisterModelInterface registerModel;

    public RegisterPresenter(RegisterView registerView) {
        this.registerView= registerView;
        registerModel=new RegisterModel();
    }
    public void register(){
        registerView.showLoading();
        registerModel.register(registerView.getRegisterUserName(), registerView.getRegisterPassword(),
                registerView.getRegisterGender(), registerView.getRegisterAge(),
                registerView.getRegisterHeight(), registerView.getRegisterWeight(), new OnRegisterListener() {
                    @Override
                    public void registerSuccess() {
                        registerView.hideLoading();
                        registerView.toLoginActivity();
                    }

                    @Override
                    public void registernFailed(String errorMessage) {
                        registerView.hideLoading();
                        registerView.registerFaild(errorMessage);

                    }
                });
    }
}
