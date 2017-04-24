package com.wangpm.enteranimation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.wangpm.enteranimation.R;

import anim.Anim;

/**
 * Created by wpm on 2017/4/1.
 */

public class EnterAnimLayout extends FrameLayout {
    private Anim anim ;
    private long startTime = 0;//开始时间
    private boolean mIsAnimaionRun = false;
    private boolean mIsVisibleAtFirst = true;

    public EnterAnimLayout(Context context) {
        super(context);
        initialize();
    }

    public EnterAnimLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray attribute = context.obtainStyledAttributes(attrs, R.styleable.EnterAnimLayout);
        mIsVisibleAtFirst = attribute.getBoolean(R.styleable.EnterAnimLayout_isVisibleAtFirst, true);

        attribute.recycle();
        initialize();
    }

    public EnterAnimLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray attribute = context.obtainStyledAttributes(attrs, R.styleable.EnterAnimLayout);
        mIsVisibleAtFirst = attribute.getBoolean(R.styleable.EnterAnimLayout_isVisibleAtFirst, false);

        attribute.recycle();
        initialize();
    }

    protected void initialize() {
    }

    public void setAnim(Anim anim) {
        this.anim = anim;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
    public boolean ismIsAnimaionRun() {
        return mIsAnimaionRun;
    }

    public void setmIsAnimaionRun(boolean mIsAnimaionRun) {
        this.mIsAnimaionRun = mIsAnimaionRun;
    }



    @Override
    protected void dispatchDraw(Canvas canvas) {

        if (mIsVisibleAtFirst && !mIsAnimaionRun) {
            super.dispatchDraw(canvas);
            return;
        }
        if (!mIsVisibleAtFirst && !mIsAnimaionRun) {
            return;
        }

        long currentTime = System.currentTimeMillis();
        float rate = ((float)(currentTime - startTime) )/ anim.totalPaintTime;
        rate = rate > 1 ? 1 : rate;

        anim.handleCanvas(canvas,rate);

        super.dispatchDraw(canvas);

        if (rate < 1) {
            invalidate();
        } else {
            mIsAnimaionRun = false;
            mIsVisibleAtFirst = true;
        }
    }
}
