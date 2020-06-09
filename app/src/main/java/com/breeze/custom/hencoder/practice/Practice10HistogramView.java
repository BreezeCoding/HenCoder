package com.breeze.custom.hencoder.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Practice10HistogramView extends View {

    private final Paint mPaint;
    private int red = 0xffff0000;
    private float mWidth;
    private float mHeight;
    private Path mPath;
    private RectF mRect;

    public Practice10HistogramView(Context context) {
        this(context, null);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPath = new Path();
        mRect = new RectF();


        mPaint.setColor(Color.parseColor("#ffffff"));
        mPaint.setStrokeWidth(3);
//        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStyle(Paint.Style.STROKE);
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

        mPath.moveTo(200, 200);
        mPath.lineTo(200, 800);
        mPath.lineTo(1200, 800);
        canvas.drawPath(mPath, mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(50);
        mPaint.setColor(Color.parseColor("#00ff00"));
        canvas.drawLine(250, 800, 250, 700, mPaint);

        mPaint.setTextSize(20);
        mPaint.setColor(Color.parseColor("#ffffff"));
        canvas.drawText("你好啊", 245, 850, mPaint);
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
    }
}
