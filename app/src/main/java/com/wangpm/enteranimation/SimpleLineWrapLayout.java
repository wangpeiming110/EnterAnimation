package com.wangpm.enteranimation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wpm on 2017/4/5.
 */

public class SimpleLineWrapLayout extends ViewGroup {
    Context context;
    private int maxWidth;

    public SimpleLineWrapLayout(Context context) {
        super(context);
        init(context);
    }

    public SimpleLineWrapLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SimpleLineWrapLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        maxWidth = MeasureSpec.getSize(widthMeasureSpec);
        int finalWidth = 0;
        int finalHeight = 0;
        int lineWidth = 0;
        int lineHeight = 0;

        for (int index = 0; index < getChildCount(); index++) {
            final View child = getChildAt(index);
            // measure
            child.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);

            if (index == 0) {
                lineHeight = child.getMeasuredHeight();
                lineWidth = child.getMeasuredWidth();
                finalHeight = lineHeight;
                finalWidth = lineWidth;
            } else {
                //没有超出当前行
                if (lineWidth + dip2px(context, 1) + child.getMeasuredWidth() <= maxWidth) {
                    lineWidth = lineWidth + dip2px(context, 1) + child.getMeasuredWidth();
                    if (lineWidth > finalWidth) {
                        finalWidth = lineWidth;
                    }
                    if (child.getMeasuredHeight() > lineHeight) {
                        finalHeight = finalHeight - lineHeight + child.getMeasuredHeight();
                        lineHeight = child.getMeasuredHeight();
                    }
                }
                //换行
                else {
                    lineHeight = child.getMeasuredHeight();
                    lineWidth = child.getMeasuredWidth();
                    finalHeight += lineHeight;
                    if (lineWidth > finalWidth) {
                        finalWidth = lineWidth;
                    }
                }
            }
        }
        setMeasuredDimension(finalWidth,finalHeight);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int left;
        int top =0;
        int right =0;
        int bottom ;
        int lineWidth = 0;
        int lineHeight = 0;
        for (int index = 0; index < getChildCount(); index++) {
            final View child = getChildAt(index);

            if (index == 0) {
                left = 0;
                top = 0;
                right = child.getMeasuredWidth();
                bottom = child.getMeasuredHeight();
                lineWidth = child.getMeasuredWidth();
                lineHeight = child.getMeasuredHeight();
            } else {
                //没有超出当前行
                if (lineWidth + dip2px(context, 1) + child.getMeasuredWidth() <= maxWidth) {
                    lineWidth = lineWidth + dip2px(context, 1) + child.getMeasuredWidth();
                    if (child.getMeasuredHeight() > lineHeight) {
                        lineHeight = child.getMeasuredHeight();
                    }
                    left = right +dip2px(context, 1);
                    right = left+ child.getMeasuredWidth();
                    bottom = top+child.getMeasuredHeight();
                }
                //换行
                else {
                    left =0;
                    right = child.getMeasuredWidth();
                    top = top+ lineHeight;
                    bottom =top + child.getMeasuredHeight();
                    lineHeight = child.getMeasuredHeight();
                    lineWidth = child.getMeasuredWidth();
                }
            }
            child.layout(left, top, right, bottom);
        }
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
