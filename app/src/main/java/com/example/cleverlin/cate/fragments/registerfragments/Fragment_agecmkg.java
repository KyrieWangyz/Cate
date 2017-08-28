package com.example.cleverlin.cate.fragments.registerfragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cleverlin.cate.R;
import com.example.cleverlin.cate.activity.LoginActivity;
import com.example.cleverlin.cate.activity.RegisterActivity;
import com.example.cleverlin.cate.activity.viewInterface.RegisterView;
import com.example.cleverlin.cate.presenter.RegisterPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by cleverlin on 2017/8/11.
 */

public class Fragment_agecmkg extends Fragment implements RegisterView{
    @BindView(R.id.register_age)
    AutoCompleteTextView registerAge;
    @BindView(R.id.register_height)
    EditText registerHeight;
    @BindView(R.id.register_weight)
    EditText registerWeight;
    @BindView(R.id.register_finish)
    Button registerFinish;
    Unbinder unbinder;
    ProgressDialog mPbLoading;
    private RegisterPresenter registerPresenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_agecmkg, container, false);
        unbinder = ButterKnife.bind(this, view);
        mPbLoading=new ProgressDialog((RegisterActivity)getActivity());
        registerPresenter=new RegisterPresenter(this);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.register_finish)
    public void onViewClicked() {
        Toast.makeText(getContext(),"注册成功",Toast.LENGTH_SHORT).show();
       // registerPresenter.register();
    }

    @Override
    public String getRegisterUserName() {
        return ((RegisterActivity)getActivity()).getUsername0();
    }

    @Override
    public String getRegisterPassword() {
        return ((RegisterActivity)getActivity()).getPassword0();
    }

    @Override
    public String getRegisterGender() {
        return ((RegisterActivity)getActivity()).getGender0();
    }

    @Override
    public int getRegisterAge() {
        return Integer.valueOf(registerAge.getText().toString());
    }

    @Override
    public double getRegisterHeight() {
        return Double.parseDouble(registerHeight.getText().toString());
    }

    @Override
    public double getRegisterWeight() {
        return Double.parseDouble(registerWeight.getText().toString());
    }

    @Override
    public void showLoading() {
        mPbLoading.show();
        mPbLoading.setMessage("Registering……");
    }

    @Override
    public void hideLoading() {
        mPbLoading.dismiss();
    }

    @Override
    public void toLoginActivity() {
        Intent reg2log=new Intent((RegisterActivity)getActivity(), LoginActivity.class);
        startActivity(reg2log);
    }

    @Override
    public void registerFaild(String message) {
        Toast.makeText((RegisterActivity)getActivity(), "Register Faild:"+message, Toast.LENGTH_SHORT).show();
    }

}
