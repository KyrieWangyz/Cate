package com.example.cleverlin.cate.fragments.registerfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.cleverlin.cate.R;
import com.example.cleverlin.cate.activity.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by cleverlin on 2017/8/11.
 */

public class Fragment_IdPwd extends Fragment {
    @BindView(R.id.register_username)
    AutoCompleteTextView registerUsername;
    @BindView(R.id.register_password)
    EditText registerPassword;
    @BindView(R.id.register_next)
    Button registerNext;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_idpwd, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.register_next)
    public void onViewClicked() {

        final RegisterActivity registerActivity = (RegisterActivity) getActivity();
        registerActivity.setFragment2Fragment(new RegisterActivity.Fragment2Fragment() {
            @Override
            public void gotoFragment(ViewPager viewPager) {
                int currentItem=viewPager.getCurrentItem();
                viewPager.setCurrentItem(currentItem+1);
            }
        });
        registerActivity.forSkip();
        getRegisterNamePwd();

    }

    private void getRegisterNamePwd() {
        ((RegisterActivity) getActivity()).setUsername0(registerUsername.getText().toString());
        ((RegisterActivity) getActivity()).setPassword0(registerPassword.getText().toString());
    }


}
