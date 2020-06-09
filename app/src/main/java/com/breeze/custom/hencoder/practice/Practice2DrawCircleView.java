package com.breeze.custom.hencoder.practice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.breeze.custom.hencoder.R;

public class Practice2DrawCircleView extends View {

    private Paint mPaint;
    private RectF mRect;
    private float mProgress;
    private float mMaxProgress;
    private float mHeight;
    private float mWidth;
    private Paint mPaintArc;
    private onCallBack mCallBack = null;

    public Practice2DrawCircleView(Context context) {
        this(context, null);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Practice2DrawCircleView);
        mProgress = typedArray.getFloat(R.styleable.Practice2DrawCircleView_Progress, 0);
        mMaxProgress = typedArray.getFloat(R.styleable.Practice2DrawCircleView_MaxProgress, 100);
        typedArray.recycle();

        mPaint = new Paint();
        mPaintArc = new Paint();

        mPaint.setColor(getResources().getColor(R.color.yellow));
        mPaint.setAntiAlias(true);
        mRect = new RectF();

        mPaintArc.setColor(getResources().getColor(R.color.yellow));
        mPaintArc.setAntiAlias(true);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        Log.d("ViewTAG", "onMeasure: ");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mHeight = getMeasuredHeight();
        mWidth = getMeasuredWidth();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
//        Log.d("ViewTAG", "onLayout: ");
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        Log.d("ViewTAG", "onDraw: ");
//        Log.d("ViewTAG", "getHeight: " + mHeight);
//        Log.d("ViewTAG", "getWidth: " + mWidth);

        float radius = 0;
        if (mWidth > mHeight) {
            radius = mHeight / 6;
        } else {
            radius = mWidth / 6;
        }

        //1.实心圆
        canvas.drawCircle(mWidth * 1 / 4, mHeight * 1 / 4, radius, mPaint);

        //3.蓝色实心圆
        mPaint.setColor(getResources().getColor(R.color.colorAccent));
        canvas.drawCircle(mWidth * 1 / 4, mHeight * 3 / 4, radius, mPaint);

        //4.空心圆
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(40);
        canvas.drawCircle(mWidth * 3 / 4, mHeight * 3 / 4, radius, mPaint);


        mPaintArc.setStyle(Paint.Style.STROKE);
        mPaintArc.setStrokeWidth(40);
        //画圆弧
        mRect.left = mWidth * 3 / 4 - radius;
        mRect.right = mWidth * 3 / 4 + radius;
        mRect.top = mHeight * 3 / 4 - radius;
        mRect.bottom = mHeight * 3 / 4 + radius;

        float progress = 0;
//        Log.d("ViewViewTAG", "mMaxProgress: " + mMaxProgress + "    mProgress: " + mProgress);
        if (mProgress != 0) {
            progress = mProgress / mMaxProgress;
        }
        canvas.drawArc(mRect, 0, progress * 360, false, mPaintArc);

        if (mCallBack != null && progress == 1) {
            mCallBack.callback();
        }

        //3.空心圆
        mPaint.setStrokeWidth(3);
        mPaint.setColor(getResources().getColor(R.color.black));
        canvas.drawCircle(mWidth * 3 / 4, mHeight * 1 / 4, radius, mPaint);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
    }


    public void setProgress(float progress) {
//        Log.d("ViewViewTAG", "setProgress: " + progress);
        this.mProgress = progress;
        invalidate();
    }

    public void setMaxProgress(float maxProgress) {
        this.mMaxProgress = maxProgress;
    }

    public void setOnCallBack(onCallBack callBack) {
        this.mCallBack = callBack;
    }

    public interface onCallBack {
        void callback();
    }
}
