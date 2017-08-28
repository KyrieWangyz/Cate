package com.example.cleverlin.cate.adapter.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.cleverlin.cate.fragments.FragmentInfo;
import com.example.cleverlin.cate.fragments.recordfragments.FridayFragment;
import com.example.cleverlin.cate.fragments.recordfragments.MondayFragment;
import com.example.cleverlin.cate.fragments.recordfragments.SaturdayFragment;
import com.example.cleverlin.cate.fragments.recordfragments.SunFragment;
import com.example.cleverlin.cate.fragments.recordfragments.ThursdayFragment;
import com.example.cleverlin.cate.fragments.recordfragments.TuesdayFragment;
import com.example.cleverlin.cate.fragments.recordfragments.WednesdayFragment;
import com.example.cleverlin.cate.fragments.searchfragments.MaterialFragment;
import com.example.cleverlin.cate.fragments.searchfragments.RecipesFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cleverlin on 2017/8/25.
 */

public class RecordAdapter extends FragmentPagerAdapter {
    public List<FragmentInfo> fragments=new ArrayList<>(7);
    public RecordAdapter(FragmentManager fm) {
        super(fm);
        initFragments();
    }

    private void initFragments() {
        fragments.add(new FragmentInfo("一", MondayFragment.class));
        fragments.add(new FragmentInfo("二", TuesdayFragment.class));
        fragments.add(new FragmentInfo("三", WednesdayFragment.class));
        fragments.add(new FragmentInfo("四", ThursdayFragment.class));
        fragments.add(new FragmentInfo("五", FridayFragment.class));
        fragments.add(new FragmentInfo("六", SaturdayFragment.class));
        fragments.add(new FragmentInfo("日", SunFragment.class));
    }

    @Override
    public Fragment getItem(int position) {
        try {
            return (Fragment) fragments.get(position).getFragment().newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return  null;
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();
    }
}
