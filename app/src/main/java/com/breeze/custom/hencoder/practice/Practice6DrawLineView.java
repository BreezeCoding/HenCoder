package com.breeze.custom.hencoder.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Practice6DrawLineView extends View {

    private final Paint mPaint;
    private int red = 0xffff0000;
    private float mWidth;
    private float mHeight;

    public Practice6DrawLineView(Context context) {
        this(context, null);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();

        mPaint.setColor(red);
        mPaint.setStrokeWidth(20);
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

        canvas.drawLine(mWidth / 6, mHeight * 1 / 6, mWidth * 5 / 6, mHeight * 5 / 6, mPaint);
//        练习内容：使用 canvas.drawLine() 方法画直线
    }
}
