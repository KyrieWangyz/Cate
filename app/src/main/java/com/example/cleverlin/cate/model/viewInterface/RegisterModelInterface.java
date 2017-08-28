package com.example.cleverlin.cate.model.viewInterface;

import com.example.cleverlin.cate.presenter.preinterface.OnRegisterListener;

/**
 * Created by cleverlin on 2017/8/13.
 */

public interface RegisterModelInterface {
    public void register(String username,String password,String gender,int age,double height,double weight,OnRegisterListener registerListener);
}
