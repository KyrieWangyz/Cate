package com.example.cleverlin.cate.fragments.searchfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cleverlin.cate.R;

/**
 * Created by cleverlin on 2017/8/19.
 */

public class RecipesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_recipes,container,false);
        return  view;
    }
}
