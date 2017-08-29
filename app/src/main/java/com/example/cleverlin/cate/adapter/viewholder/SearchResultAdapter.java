package com.example.cleverlin.cate.adapter.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cleverlin.cate.R;
import com.example.cleverlin.cate.bean.ResultBean;
import com.example.cleverlin.cate.imageloader.ImageLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cleverlin on 2017/8/21.
 */

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder> {

    private Context mContext;
    private List<ResultBean> mDatas;
    private LayoutInflater mLayoutInflater;

    public SearchResultAdapter(Context mContext, List<ResultBean> mDatas) {//修改List<....>
        this.mContext = mContext;
        this.mDatas = mDatas;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.search_result, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ResultBean resultBean=mDatas.get(position);
        holder.foodName.setText(resultBean.getName());
        ImageLoader.load(resultBean.getImg(),holder.foodIcon);
        holder.material.setText(resultBean.getMaterial());
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.food_icon)
        ImageView foodIcon;
        @BindView(R.id.food_name)
        TextView foodName;
        @BindView(R.id.material)
        TextView material;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
