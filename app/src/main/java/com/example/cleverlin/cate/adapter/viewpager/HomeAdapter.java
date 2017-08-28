package com.example.cleverlin.cate.adapter.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.example.cleverlin.cate.fragments.FragmentInfo;
import com.example.cleverlin.cate.fragments.homefragments.CalculatorFragment;
import com.example.cleverlin.cate.fragments.homefragments.HomeFragment;
import com.example.cleverlin.cate.fragments.homefragments.PersonalFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cleverlin on 2017/8/17.
 */

public class HomeAdapter extends FragmentPagerAdapter {

    private List<FragmentInfo> mFragments=new ArrayList<>(3);



    public HomeAdapter(FragmentManager fm) {
        super(fm);
        initFragments();
    }


    private void initFragments() {
        mFragments.add(new FragmentInfo(HomeFragment.class));
        mFragments.add(new FragmentInfo(CalculatorFragment.class));
        mFragments.add(new FragmentInfo(PersonalFragment.class));
    }


    @Override
    public Fragment getItem(int position) {
        try {
            return (Fragment) mFragments.get(position).getFragment().newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return  null;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
