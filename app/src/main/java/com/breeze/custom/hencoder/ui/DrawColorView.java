package com.breeze.custom.hencoder.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.breeze.custom.hencoder.R;

public class DrawColorView extends View {

    private Paint mPaint;

    public DrawColorView(Context context) {
        this(context,null);
    }

    public DrawColorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DrawColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //初始化画笔
        mPaint = new Paint();
        mPaint.setColor(getResources().getColor(R.color.colorAccent));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(getResources().getColor(R.color.yellow));
    }
}
