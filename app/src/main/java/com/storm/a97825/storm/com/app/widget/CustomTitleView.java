package com.storm.a97825.storm.com.app.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.storm.a97825.storm.R;

/**
 * Created by 97825 on 2018/1/22.
 */
public class CustomTitleView extends View {

    //定义属性 文字 颜色，字体大小
    private String mTitleText;
    private int mTitleColor;
    private int mTitleTextSize;

    private Rect mBound;
    private Paint mPaint = null;

    public CustomTitleView(Context context) {
        this(context , null);
    }

    public CustomTitleView(Context context, AttributeSet attrs) {
        this(context, attrs , 0);
    }

    /**
     * description
     * 获取我自定义的样式属性
     * @param context
     * @param attrs
     * @param defStyleAttr
     */

    public CustomTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.CustomTitleView);


        mTitleText = typedArray.getString(R.styleable.CustomTitleView_titleTextd);
        mTitleColor = typedArray.getColor(R.styleable.CustomTitleView_titleTextColord , Color.BLACK);
        mTitleTextSize = typedArray.getDimensionPixelSize(R.styleable.CustomTitleView_titleTextSized,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));

        typedArray.recycle();

        /**
         * 获取自定义样式属性

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs ,
                R.styleable.CustomTitleView, defStyleAttr , 0);
        int n = a.getIndexCount();
        for(int i=0; i<n ; i++){
            int attr = a.getIndex(i);
            switch(attr){
                case R.styleable.CustomTitleView_titleTextd:
                    mTitleText = a.getString(attr);
                    break;
                case R.styleable.CustomTitleView_titleTextColord:
                    mTitleColor = a.getColor(attr , Color.BLACK);
                    break;
                case R.styleable.CustomTitleView_titleTextSized:
                    mTitleTextSize = a.getDimensionPixelSize(attr , (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP , 16 , getResources().getDisplayMetrics()
                    ));
                    break;
            }
        }
        a.recycle();
         */

        mPaint = new Paint();

        //设置抗锯齿
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(mTitleTextSize);
        mPaint.setColor(mTitleColor);

        if(mPaint == null){
            System.out.println("init paint failed");
        }

        // 获得绘制文本的宽和高
        // mPaint = new Paint();
        //mPaint.setTextSize(mTitleTextSize);
        mBound = new Rect();

        mPaint.getTextBounds(mTitleText , 0, mTitleText.length() , mBound);
    }




    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        //重新onDraw方法

        //mPaint = new Paint();
        if(mPaint == null){
            System.out.println("Paint null");
            return ;
        }
        //绘制背景
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0 ,0, getMeasuredWidth() , getMeasuredHeight() , mPaint);
        //绘制文本
        mPaint.setColor(mTitleColor);
        canvas.drawText(mTitleText , getWidth()/2-mBound.width()/2 ,
                getHeight() / 2 + mBound.height() / 2, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}