package com.breeze.custom.hencoder.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.breeze.custom.hencoder.R;

public class Practice8DrawArcView extends View {

    private final Paint mPaint;
    private int red = 0xffff0000;
    private float mWidth;
    private float mHeight;

    public Practice8DrawArcView(Context context) {
        this(context, null);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();

        mPaint.setColor(red);
//        mPaint.setStrokeWidth(20);
//        mPaint.setStrokeCap(Paint.Cap.ROUND);
//        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = (float) getMeasuredWidth();
        mHeight = (float) getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawArc(mWidth / 4, mHeight * 3 / 7, mWidth * 3 / 4, mHeight * 5 / 6, -20, -85, true, mPaint);
//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(getResources().getColor(R.color.yellow));
        canvas.drawArc(mWidth / 4, mHeight * 1 / 4, mWidth * 3 / 4, mHeight * 3 / 4, 260, 50, false, mPaint);


        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(getResources().getColor(R.color.colorAccent));
        canvas.drawArc(mWidth / 4, mHeight * 3 / 7, mWidth * 3 / 4, mHeight * 5 / 6, 0, 180, false, mPaint);
    }
}
