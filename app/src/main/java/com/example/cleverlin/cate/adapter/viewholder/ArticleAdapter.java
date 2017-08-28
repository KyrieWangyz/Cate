package com.example.cleverlin.cate.adapter.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cleverlin.cate.R;
import com.example.cleverlin.cate.bean.AllBean;
import com.example.cleverlin.cate.imageloader.ImageLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cleverlin on 2017/8/16.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private Context mContext;
    private List<AllBean> mDatas;

    private LayoutInflater mLayoutInflater;
    public ArticleAdapter(Context mContext, List<AllBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        mLayoutInflater = LayoutInflater.from(mContext);

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.template_article, parent, false));
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AllBean article = mDatas.get(position);
        holder.title.setText(article.getTitle());
        ImageLoader.load(article.getPhoto(),holder.image);


    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.title)
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }
    }

}
