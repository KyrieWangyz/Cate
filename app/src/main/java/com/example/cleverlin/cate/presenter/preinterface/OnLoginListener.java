package com.example.cleverlin.cate.presenter.preinterface;

import com.example.cleverlin.cate.bean.User;

/**
 * Created by cleverlin on 2017/8/11.
 */

public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed(String errorMessage);
}
