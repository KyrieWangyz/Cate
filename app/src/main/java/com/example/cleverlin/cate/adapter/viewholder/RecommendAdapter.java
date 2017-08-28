package com.example.cleverlin.cate.adapter.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cleverlin.cate.R;
import com.example.cleverlin.cate.bean.RecommendBean;
import com.example.cleverlin.cate.imageloader.ImageLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cleverlin on 2017/8/19.
 */

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.ViewHolder> {


    private Context context;

    private LayoutInflater mLayoutInflater;

    private List<RecommendBean> mDatas;

    public RecommendAdapter(Context mContext, List<RecommendBean> mDatas) {
        this.context = mContext;
        this.mDatas = mDatas;
        mLayoutInflater = LayoutInflater.from(mContext);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.template_reommend, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RecommendBean rbean = mDatas.get(position);
        ImageLoader.load(rbean.getPhoto(), holder.foodphoto);
        holder.foodname.setText(rbean.getName());
        holder.star.setStar(rbean.getStars());
        holder.star.setClickable(false);
        holder.time.setText("需要" + rbean.getCooktime() + "分钟");
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.foodphoto)
        ImageView foodphoto;
        @BindView(R.id.foodname)
        TextView foodname;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.star)
        com.example.cleverlin.cate.other.RatingBar star;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }
    }
}
