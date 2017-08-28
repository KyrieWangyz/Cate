package com.example.cleverlin.cate.fragments.homefragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.cleverlin.cate.R;
import com.example.cleverlin.cate.activity.SingleSearchActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by cleverlin on 2017/8/17.
 */

public class CalculatorFragment extends Fragment {
    @BindView(R.id.yes_add)
    ImageButton yesAdd;
    @BindView(R.id.menu_food)
    RecyclerView menuFood;
    @BindView(R.id.hintText)
    TextView hintText;
    @BindView(R.id.no_add)
    ImageButton noAdd;
    @BindView(R.id.sum_calorie)
    TextView sumCalorie;
    @BindView(R.id.equalSport)
    TextView equalSport;
    @BindView(R.id.add_record)
    ImageButton addRecord;
    Unbinder unbinder;

    private List<String> list=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_calculator, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
       // list.add("1");
        if (0==list.size()){
            yesAdd.setVisibility(View.INVISIBLE);
            hintText.setVisibility(View.VISIBLE);
            noAdd.setVisibility(View.VISIBLE);
            sumCalorie.setVisibility(View.INVISIBLE);
            equalSport.setVisibility(View.INVISIBLE);
            addRecord.setVisibility(View.INVISIBLE);
        }else{
            yesAdd.setVisibility(View.VISIBLE);
            hintText.setVisibility(View.INVISIBLE);
            noAdd.setVisibility(View.INVISIBLE);
            sumCalorie.setVisibility(View.VISIBLE);
            equalSport.setVisibility(View.VISIBLE);
            addRecord.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    private void toActivity(Class mClass){
        Intent intent=new Intent(getActivity(),mClass);
        startActivity(intent);
    }
    @OnClick({R.id.yes_add, R.id.no_add, R.id.add_record})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.yes_add:
                toActivity(SingleSearchActivity.class);
                break;
            case R.id.no_add:
                toActivity(SingleSearchActivity.class);
                break;
            case R.id.add_record:
                break;
        }
    }
}
