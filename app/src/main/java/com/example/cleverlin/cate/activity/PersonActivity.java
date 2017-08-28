package com.example.cleverlin.cate.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cleverlin.cate.R;
import com.example.cleverlin.cate.view.CircleProgressView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonActivity extends Activity {

    @BindView(R.id.yesterday_calorie)
    CircleProgressView yesterdayCalorie;
    @BindView(R.id.today_calorie)
    CircleProgressView todayCalorie;
    @BindView(R.id.week_calorie)
    CircleProgressView weekCalorie;
    @BindView(R.id.hintText)
    TextView hintText;
    @BindView(R.id.suggest_menu)
    ImageButton suggestMenu;
    @BindView(R.id.suggest_menuTv)
    TextView suggestMenuTv;
    @BindView(R.id.change_calorie)
    ImageButton changeCalorie;
    @BindView(R.id.change_calorieTv)
    TextView changeCalorieTv;
    @BindView(R.id.calculator_calorie)
    ImageButton calculatorCalorie;
    @BindView(R.id.calculator_calorieTv)
    TextView calculatorCalorieTv;
    @BindView(R.id.record_eat)
    ImageButton recordEat;
    @BindView(R.id.record_eatTv)
    TextView recordEatTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreen();
        setContentView(R.layout.activity_person);
        ButterKnife.bind(this);
        initProgress();

    }

    private void initProgress() {
        yesterdayCalorie.setProgress(5,false);
        todayCalorie.setProgress(20,true);
        weekCalorie.setProgress(45,false);
    }

    private void setFullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
    }

    private void toActivity(Class mClass){
        Intent intent=new Intent(this,mClass);
        startActivity(intent);
    }
    @OnClick({R.id.suggest_menu, R.id.suggest_menuTv, R.id.change_calorie, R.id.change_calorieTv, R.id.calculator_calorie, R.id.calculator_calorieTv, R.id.record_eat, R.id.record_eatTv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.suggest_menu:
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.suggest_menuTv:
                Toast.makeText(this, "1.1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.change_calorie:
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.change_calorieTv:
                Toast.makeText(this, "2.2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.calculator_calorie:
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();

                break;
            case R.id.calculator_calorieTv:
                Toast.makeText(this, "3.3", Toast.LENGTH_SHORT).show();

                break;
            case R.id.record_eat:
                toActivity(RecordActivity.class);
                break;
            case R.id.record_eatTv:
                toActivity(RecordActivity.class);

                break;
        }
    }
}
