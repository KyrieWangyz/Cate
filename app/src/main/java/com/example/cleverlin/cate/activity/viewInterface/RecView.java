package com.example.cleverlin.cate.activity.viewInterface;

import com.example.cleverlin.cate.bean.RecommendBean;

import java.util.List;

/**
 * Created by cleverlin on 2017/8/19.
 */

public interface RecView extends BaseView {
    void  showResult(List<RecommendBean> datas);
    void showNodata();
    void showError(String msg);

}
