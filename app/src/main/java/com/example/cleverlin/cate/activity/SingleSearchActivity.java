package com.example.cleverlin.cate.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cleverlin.cate.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SingleSearchActivity extends Activity {

    @BindView(R.id.returnAct)
    ImageButton returnAct;
    @BindView(R.id.simple_search)
    EditText simpleSearch;
    @BindView(R.id.finish)
    ImageButton finish;
    @BindView(R.id.single_photo)
    ImageView singlePhoto;
    @BindView(R.id.single_name)
    TextView singleName;
    @BindView(R.id.single_calorie)
    TextView singleCalorie;
    @BindView(R.id.layout_food)
    RelativeLayout layoutFood;
    @BindView(R.id.number_food)
    ImageButton numberFood;
    @BindView(R.id.layout_number)
    RelativeLayout layoutNumber;
    @BindView(R.id.food_unit)
    TextView foodUnit;
    @BindView(R.id.layout_unit)
    RelativeLayout layoutUnit;
    @BindView(R.id.when)
    ImageButton when;
    @BindView(R.id.layout_when)
    RelativeLayout layoutWhen;
    @BindView(R.id.activity_single_search)
    LinearLayout activitySingleSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_search);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.returnAct, R.id.finish, R.id.number_food,R.id.when})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.returnAct:
                break;
            case R.id.finish:
                break;
            case R.id.number_food:
                break;
        }
    }
}
