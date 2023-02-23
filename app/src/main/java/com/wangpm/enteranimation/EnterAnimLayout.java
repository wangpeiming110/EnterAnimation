package com.wangpm.enteranimation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import anim.Anim;

/**
 * Created by wpm on 2017/4/1.
 */

public class EnterAnimLayout extends FrameLayout {
    private Anim anim ; //需要播放的动画类型
    private long startTime = 0;//开始时间
    private boolean mIsAnimationRun = false;//开始播放动画的标志位，设置为true，然后invalidate即开始播放动画
    private boolean mIsVisibleAtFirst = true;//view所在页面打开时是否显示此view

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
    public boolean isAnimationRun() {
        return mIsAnimationRun;
    }

    public void setIsAnimationRun(boolean mIsAnimationRun) {
        this.mIsAnimationRun = mIsAnimationRun;
    }



    @Override
    protected void dispatchDraw(Canvas canvas) {
        //如果设置了打开页面时正常显示，并且未设置播放动画，则正常分发draw
        if (mIsVisibleAtFirst && !mIsAnimationRun) {
            super.dispatchDraw(canvas);
            return;
        }
        //如果设置了打开页面时控件先不可见，并且未设置播放动画，则不分发draw
        if (!mIsVisibleAtFirst && !mIsAnimationRun) {
            return;
        }

        //mIsAnimationRun 为true，播放动画，自定义分发draw

        //计算动画已播放时间比率rate=（当前时间-动画开始时间）/总共需要播放的时间
        long currentTime = System.currentTimeMillis();
        float rate = ((float)(currentTime - startTime) )/ anim.totalPaintTime;
        rate = rate > 1 ? 1 : rate;

        //先交给anim根据当前动画已播放时间比率来处理canvas，把处理后的canvas再分发给子view来draw
        //不同的anim会有不同的处理canvas的方式
        anim.handleCanvas(canvas,rate);
        super.dispatchDraw(canvas);

        //如果动画未播放完成，则继续刷新，如果已完成，则不继续刷新，重置标志位。
        if (rate < 1) {
            invalidate();
        } else {
            mIsAnimationRun = false;
            mIsVisibleAtFirst = true;
        }
    }


//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        //正在播放动画时点击才拦截
//        if (ev.getAction() == MotionEvent.ACTION_DOWN && mIsAnimationRun == true) {
//            mIsAnimationRun = false;
//            return true;
//        }
//        return super.onInterceptTouchEvent(ev);
//    }
}
