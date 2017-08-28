package com.example.cleverlin.cate.model.viewInterface;

import com.example.cleverlin.cate.presenter.preinterface.OnLoginListener;

/**
 * Created by cleverlin on 2017/8/11.
 */

public interface LoginModelInterFace {
    public void login(String username, String password, OnLoginListener loginListener);
}
