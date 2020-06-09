package com.breeze.custom.hencoder.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class Practice3DrawRectView extends View {

    private RectF mRectF;
    private Paint mPaint;

    private int black = 0xffff0000;
    private float mWidth;
    private float mHeight;

    public Practice3DrawRectView(Context context) {
        this(context, null);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
        mRectF = new RectF();

        mPaint.setColor(black);
        mPaint.setStrokeWidth(20);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = (float)getMeasuredWidth();
        mHeight = (float) getMeasuredHeight();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        练习内容：使用 canvas.drawRect() 方法画矩形
        Log.d("TAG3", "mWidth: "+mWidth+"    mHeight: "+mHeight);
        mRectF.left = mWidth * 1 / 3;
        mRectF.right = mWidth * 2 / 3;
        mRectF.top = mHeight * 1 / 3;
        mRectF.bottom = mHeight * 2 / 3;
        canvas.drawRect(mRectF, mPaint);
    }
}
