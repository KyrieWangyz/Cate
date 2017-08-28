package com.example.cleverlin.cate.activity.viewInterface;

/**
 * Created by cleverlin on 2017/8/12.
 */

public interface RegisterView extends BaseView{
    String getRegisterUserName();
    String getRegisterPassword();
    String getRegisterGender();
    int getRegisterAge();
    double getRegisterHeight();
    double getRegisterWeight();
    void toLoginActivity();
    void registerFaild(String message);
}
