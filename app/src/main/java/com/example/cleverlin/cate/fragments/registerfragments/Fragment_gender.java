package com.example.cleverlin.cate.fragments.registerfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.cleverlin.cate.R;
import com.example.cleverlin.cate.activity.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by cleverlin on 2017/8/11.
 */

public class Fragment_gender extends Fragment {
    @BindView(R.id.boy)
    ImageButton boy;
    @BindView(R.id.girl)
    ImageButton girl;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gender, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.boy, R.id.girl})
    public void onViewClicked(View view) {
        final RegisterActivity registerActivity = (RegisterActivity) getActivity();
        registerActivity.setFragment2Fragment(new RegisterActivity.Fragment2Fragment() {
            @Override
            public void gotoFragment(ViewPager viewPager) {
                int currentItem=viewPager.getCurrentItem();
                viewPager.setCurrentItem(currentItem+1);
            }
        });
        registerActivity.forSkip();
        switch (view.getId()) {
            case R.id.boy:
                ((RegisterActivity) getActivity()).setGender0("boy");

                break;
            case R.id.girl:
                ((RegisterActivity) getActivity()).setGender0("girl");
                break;
        }
    }

}
