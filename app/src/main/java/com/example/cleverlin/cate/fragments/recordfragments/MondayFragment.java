package com.example.cleverlin.cate.fragments.recordfragments;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.cleverlin.cate.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by cleverlin on 2017/8/26.
 */

public class MondayFragment extends BaseFragment {
    @BindView(R.id.breakfast_addbtn)
    ImageButton breakfastAddbtn;
    @BindView(R.id.list_breakfast)
    RecyclerView listBreakfast;
    @BindView(R.id.lunch_addbtn)
    ImageButton lunchAddbtn;
    @BindView(R.id.list_lunch)
    RecyclerView listLunch;
    @BindView(R.id.dinner_addbtn)
    ImageButton dinnerAddbtn;
    @BindView(R.id.list_dinner)
    RecyclerView listDinner;
    Unbinder unbinder;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.breakfast_addbtn, R.id.lunch_addbtn, R.id.dinner_addbtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.breakfast_addbtn:
                Toast.makeText(mActivity, "breakfast_addbtn", Toast.LENGTH_SHORT).show();
                break;
            case R.id.lunch_addbtn:
                Toast.makeText(mActivity, "lunch_addbtn", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dinner_addbtn:
                Toast.makeText(mActivity, "dinner_addbtn", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.week_fragment;
    }
}
