package com.example.cleverlin.cate.activity.viewInterface;



import com.example.cleverlin.cate.bean.AllBean;
import com.example.cleverlin.cate.bean.BannersBean;

import java.util.List;

/**
 * Created by cleverlin on 2017/8/16.
 */

public interface ArticleContract {
    interface View{

        void  showResult(List<AllBean> datas, List<BannersBean> banners);
        void showNodata();
        void showError(String msg);
        void showLodading();
        void  dimissLoading();

    }


    interface  Presenter {

        public void requestDatas();

    }
}
