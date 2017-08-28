package com.example.cleverlin.cate.activity.viewInterface;

import com.example.cleverlin.cate.bean.User;

/**
 * Created by cleverlin on 2017/8/11.
 */

public interface LoginView extends BaseView{
    String getUserName();
    String getPassword();
    void toMainActivity(User user);
    void showFailedError(String errorMessage);
}
