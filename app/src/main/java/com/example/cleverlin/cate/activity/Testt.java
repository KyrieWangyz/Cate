package com.example.cleverlin.cate.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;

import com.example.cleverlin.cate.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cleverlin on 2017/8/19.
 */

public class Testt extends AppCompatActivity {
    @BindView(R.id.ratingbar)
    RatingBar ratingbar;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.testlayout);
        ButterKnife.bind(this);
        ratingbar.setNumStars(5);
        ratingbar.setMax(100);
        ratingbar.setRating((float)2.5);
        ratingbar.setStepSize((float) 0.5);

    }
}
