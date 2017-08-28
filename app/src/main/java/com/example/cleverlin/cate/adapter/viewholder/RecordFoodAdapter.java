package com.example.cleverlin.cate.adapter.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cleverlin.cate.R;
import com.example.cleverlin.cate.bean.RecommendBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cleverlin on 2017/8/27.
 * 这个是添加每顿卡路里的列表适配器
 */

public class RecordFoodAdapter extends RecyclerView.Adapter<RecordFoodAdapter.ViewHolder> {

    private Context mContext;
    private LayoutInflater layoutInflater;
    private List<RecommendBean> mDatas;
//此处需要修改数据来源
    public RecordFoodAdapter(Context mContext, List<RecommendBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.template_record, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_foodname)
        TextView textFoodname;
        @BindView(R.id.text_number)
        TextView textNumber;
        @BindView(R.id.calorieNumber)
        TextView calorieNumber;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
