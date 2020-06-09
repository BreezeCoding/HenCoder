package com.breeze.custom.hencoder.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Practice4DrawPointView extends View {

    private final Paint mPaint;
    private final RectF mRectF;
    private int black = 0xffff0000;
    private float mWidth;
    private float mHeight;

    public Practice4DrawPointView(Context context) {
        this(context, null);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mRectF = new RectF();

        mPaint.setColor(black);
        mPaint.setStrokeWidth(50);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
//        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
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

        //圆点
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(mWidth / 6, mHeight / 4, mPaint);
        //方形点
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(mWidth * 3 / 6, mHeight / 4, mPaint);
        //
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(mWidth * 5 / 6, mHeight / 4, mPaint);

        float pHeight = mHeight * 3 / 4;

        float[] points = {mWidth * 1 / 6, mHeight * 3 / 4, mWidth * 3 / 6, mHeight * 3 / 4, mWidth * 5 / 6, mHeight * 3 / 4
                , mWidth * 1 / 6, mHeight * 2 / 4, mWidth * 3 / 6, mHeight * 2 / 4, mWidth * 5 / 6, mHeight * 2 / 4
        };

        canvas.drawPoints(points, 2, 8, mPaint);

//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点
    }
}
