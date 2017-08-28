package com.example.cleverlin.cate.adapter.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.cleverlin.cate.fragments.FragmentInfo;
import com.example.cleverlin.cate.fragments.registerfragments.Fragment_IdPwd;
import com.example.cleverlin.cate.fragments.registerfragments.Fragment_agecmkg;
import com.example.cleverlin.cate.fragments.registerfragments.Fragment_gender;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cleverlin on 2017/8/11.
 */

public class RegisterFragmentAdapter extends FragmentPagerAdapter {

    private List<FragmentInfo> mFragments= new ArrayList<>(3);

    public RegisterFragmentAdapter(FragmentManager fm) {
        super(fm);
        initFragments();
    }
    private void initFragments() {

        mFragments.add(new FragmentInfo(Fragment_IdPwd.class));
        mFragments.add(new FragmentInfo(Fragment_gender.class));
        mFragments.add(new FragmentInfo(Fragment_agecmkg.class));

    }

//    public void setmFragments(List<Fragment> fragments) {
//        if(fragments==null){
//            mFragments=new ArrayList<>();
//        }else{
//            mFragments=fragments;
//        }
//    }

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
