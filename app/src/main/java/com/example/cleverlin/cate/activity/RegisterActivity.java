package com.example.cleverlin.cate.activity;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.example.cleverlin.cate.R;
import com.example.cleverlin.cate.adapter.viewpager.RegisterFragmentAdapter;

import com.example.cleverlin.cate.other.NoScrollViewPager;
import com.example.cleverlin.cate.other.ViewPagerScroller;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by cleverlin on 2017/8/11.
 */

public class RegisterActivity extends AppCompatActivity{

    @BindView(R.id.viewpage)
    NoScrollViewPager viewpage;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initViewPage();
        initRegister();

    }

    private void initViewPage() {
        ViewPagerScroller pagerScroller = new ViewPagerScroller(this);
        pagerScroller.setScrollDuration(1500);//设置时间，时间越长，速度越慢
        pagerScroller.initViewPagerScroll(viewpage);
    }

    private void initRegister() {
        PagerAdapter adapter = new RegisterFragmentAdapter(getSupportFragmentManager());
        viewpage.setAdapter(adapter);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            int cnt = viewpage.getCurrentItem();
            if (cnt != 0) {
                viewpage.setCurrentItem(cnt - 1);
            } else {
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                this.finish();
            }
        }
        return true;
    }

    /**
     * 这部分是利用按钮点击跳转fragment;
     */

    private Fragment2Fragment fragment2Fragment;

    public void setFragment2Fragment(Fragment2Fragment fragment2Fragment) {
        this.fragment2Fragment = fragment2Fragment;
    }

    public void forSkip() {
        if (fragment2Fragment != null) {
            fragment2Fragment.gotoFragment(viewpage);
        }
    }



    public interface Fragment2Fragment {
        public void gotoFragment(ViewPager viewPager);
    }

    /**
     * 获取注册信息，暂存注册信息
     */
    private String username0;
    private String password0;
    private String gender0;


    public String getGender0() {
        return gender0;
    }

    public void setGender0(String gender0) {
        this.gender0 = gender0;
    }

    public String getPassword0() {
        return password0;
    }

    public void setPassword0(String password0) {
        this.password0 = password0;
    }

    public String getUsername0() {
        return username0;
    }

    public void setUsername0(String username0) {
        this.username0 = username0;
    }

    //  }
}
