package com.storm.a97825.storm.com.app.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 97825 on 2018/1/23.
 * 自定义一个百分比空间
 */
public class PercentView extends View {

    private final String TAG = PercentView.class.getSimpleName();
    private Paint mPaint;
    private RectF rect;

    public PercentView(Context context) {
        super(context);
        init();
    }

    public PercentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PercentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    public void init(){
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        rect = new RectF();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.GRAY);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        int width = getWidth();
        int height = getHeight();
        float radius = width/4;
        canvas.drawCircle(width/2 , height/2 , radius , mPaint);
        mPaint.setColor(Color.BLUE);
        rect.set(width/2-radius , width/2-radius , width/2+radius , width/2+radius);
        canvas.drawArc(rect , 270 , 120 , true, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
}