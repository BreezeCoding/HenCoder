package com.breeze.custom.hencoder.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Practice9DrawPathView extends View {

    private final Paint mPaint;
    private int red = 0xffff0000;
    private float mWidth;
    private float mHeight;
    private Path mPath;
    private RectF mRect;

    public Practice9DrawPathView(Context context) {
        this(context, null);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPath = new Path();
        mRect = new RectF();


        mPaint.setColor(Color.parseColor("#ff0000"));
        mPaint.setStrokeWidth(5);
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
        mRect.left = 200;
        mRect.top = 200;
        mRect.right = 400;
        mRect.bottom = 400;
        mPath.addArc(200, 200, 400, 400, -255, 255);
        mPath.arcTo(400, 200, 600, 400, -180, 225, false);
        mPath.lineTo(400, 542);
        mPath.close();
//        mPath.addCircle(300, 300, 200, Path.Direction.CW);
        canvas.drawPath(mPath, mPaint);
//        练习内容：使用 canvas.drawPath() 方法画心形
    }
}
