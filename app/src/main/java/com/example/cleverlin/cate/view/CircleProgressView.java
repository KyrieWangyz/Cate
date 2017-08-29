package com.example.cleverlin.cate.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by cleverlin on 2017/8/24.
 */

public class CircleProgressView extends View {
    private int mMaxProgress=100;
    private int mProgress=30;

    public int getmCircleLineStrokeWidth() {
        return mCircleLineStrokeWidth;
    }

    public void setmCircleLineStrokeWidth(int mCircleLineStrokeWidth) {
        this.mCircleLineStrokeWidth = mCircleLineStrokeWidth;
    }

    private int mCircleLineStrokeWidth=8;
    private final int mTxtStrokeWidth=2;
    //画圆所在的矩形区域
    private final RectF mRectF;
    private final Paint mPaint;
    private final Context mContext;
//    private String mTxtHint1,mTxtHint2;
    private boolean showNumber=false;





    public CircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mRectF = new RectF();
        mPaint = new Paint();
        mContext = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width=this.getWidth();
        int height=this.getHeight();
        if (width!=height){
            int min=Math.min(width,height);
            width=min;
            height=min;
        }
        //设置画笔相关属性
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.rgb(0xe9,0xe9,0xe9));
        canvas.drawColor(Color.TRANSPARENT);
        mPaint.setStrokeWidth(mCircleLineStrokeWidth);//change
     //   mPaint.setStrokeWidth(mCircleLineStrokeWidth+30);//change
        mPaint.setStyle(Paint.Style.STROKE);
        //位置
        mRectF.left=mCircleLineStrokeWidth/2+20;//change
        mRectF.top=mCircleLineStrokeWidth/2+20;
        mRectF.right=width-mCircleLineStrokeWidth/2-20;
        mRectF.bottom=height-mCircleLineStrokeWidth/2-20;
        //绘制圆圈，进度条背景
        canvas.drawArc(mRectF,-90,360,false,mPaint);
        mPaint.setColor(Color.rgb(0xFF,0xF0,0x97));
        canvas.drawArc(mRectF,-90,((float) mProgress/mMaxProgress)*360,false,mPaint);
        //绘制进度文案显示
        if (showNumber){
            mPaint.setColor(Color.rgb(0x44,0x3C,0x33));
            mPaint.setStrokeWidth(mTxtStrokeWidth);
//            String text=mProgress+"%";
            String text="283";
            int textHeight=height/4;
            mPaint.setTextSize(textHeight);
            int textWidth= (int) mPaint.measureText(text,0,text.length());
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawText(text,width/2-textWidth/2,height/2+textHeight/2,mPaint);
        }


    }
    public int getMaxProgress() {
        return mMaxProgress;
    }

    public void setMaxProgress(int maxProgress) {
        this.mMaxProgress = maxProgress;
    }

    public void setProgress(int progress,boolean showNumber) {
        this.mProgress = progress;
        this.showNumber=showNumber;
        this.invalidate();
    }

    public void setProgressNotInUiThread(int progress) {
        this.mProgress = progress;
        this.postInvalidate();
    }

//    public String getmTxtHint1() {
//        return mTxtHint1;
//    }
//
//    public void setmTxtHint1(String mTxtHint1) {
//        this.mTxtHint1 = mTxtHint1;
//    }
//
//    public String getmTxtHint2() {
//        return mTxtHint2;
//    }
//
//    public void setmTxtHint2(String mTxtHint2) {
//        this.mTxtHint2 = mTxtHint2;
//    }
//    if(!TextUtils.isEmpty(mTxtHint1)){
//        mPaint.setStrokeWidth(mTxtStrokeWidth);
//        text=mTxtHint1;
//        textHeight=height/8;
//        mPaint.setTextSize(textHeight);
//        mPaint.setColor(Color.rgb(0x99,0x99,0x99));
//        textWidth= (int) mPaint.measureText(text,0,text.length());
//        mPaint.setStyle(Paint.Style.FILL);
//        canvas.drawText(text,width/2-textWidth/2,height/4+textHeight/2,mPaint);
//    }
//    if (!TextUtils.isEmpty(mTxtHint2)){
//        mPaint.setStrokeWidth(mTxtStrokeWidth);
//        text=mTxtHint2;
//        textHeight=height/8;
//        mPaint.setTextSize(textHeight);
//        textWidth= (int) mPaint.measureText(text,0,text.length());
//        mPaint.setStyle(Paint.Style.FILL);
//        canvas.drawText(text,width/2-textWidth/2,3*height/4+textHeight/2,mPaint);
//    }
}
