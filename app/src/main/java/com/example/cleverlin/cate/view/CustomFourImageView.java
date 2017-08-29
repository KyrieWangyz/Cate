package com.example.cleverlin.cate.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.example.cleverlin.cate.R;

/**
 * Created by cleverlin on 2017/8/2.
 */

public class CustomFourImageView extends View {
    //用于判断只在第一次绘制才初始化一些资源数据
    private int state = -1;
    private final int START = 1;
    private Bitmap topImage;
    private Paint paint;
    private Matrix topMatrix;
    private Path top;
    private int imageId= R.drawable.gg;
    public CustomFourImageView(Context context) {
        super(context);
    }

    public CustomFourImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void setImageView(int imageId) {
        this.imageId=imageId;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right,int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (state > 0) {
            return;
        }
        state = START;
        init();
    }
    private void init() {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);// 软件加速
        topImage = BitmapFactory.decodeResource(getResources(), imageId);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);// 防抖动
        paint.setFilterBitmap(true);// 过滤
        initMatrix();// 缩小图片
        initPath();
    }
    private void initMatrix() {
        topMatrix = new Matrix();
        float w = getWidth();
        float h = getWidth();
        // 第一个图片
        float scale = 1;// 缩放量
        float scaleX = w / topImage.getWidth();
        float scaleY = h / topImage.getHeight();
        scale = scaleX > scaleY ? scaleX : scaleY;
        topMatrix.setScale(scale, scale);// 开始缩放比例
    }
    // 画好矩阵模块
    private void initPath() {
        top = new Path();
        top.moveTo(0, 0);
        top.lineTo(dip2px(getContext(),getWidth()), 0);
        top.lineTo(dip2px(getContext(),getWidth()), dip2px(getContext(),300));
        top.lineTo(0, dip2px(getContext(),240));
        top.close();
    }
    private int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (topImage != null) {
            // 设置抗锯齿
            PaintFlagsDrawFilter pfd = new PaintFlagsDrawFilter(0,Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
            canvas.setDrawFilter(pfd);
            canvas.save();
            canvas.clipPath(top);// 先画好模块
            canvas.drawBitmap(topImage, topMatrix, paint);// 再画图
            canvas.restore();
        }
    }

}
