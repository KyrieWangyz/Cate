package com.example.cleverlin.cate.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by cleverlin on 2017/8/17.
 * Recycview Item之间的间隔
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int space;
    private boolean layout;

    public SpaceItemDecoration(int space,boolean layout) {
        this.space = space;
        this.layout=layout;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if(layout){
            if (parent.getChildPosition(view)!=0){
                outRect.top=space;
            }
        }else{
            outRect.left = space;
            outRect.bottom = space;
            //由于每行都只有3个，所以第一个都是3的倍数，把左边距设为0
            if (parent.getChildLayoutPosition(view) %2==0) {
                outRect.left = 0;
            }
        }

    }
}
