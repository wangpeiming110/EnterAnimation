package anim;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by wpm on 2017/4/1.
 */

public class AnimLayout extends FrameLayout {
    private Anim anim ;
    private long startTime = 0;//开始时间
    private boolean mIsAnimaionRun = false;
    public void setAnim(Anim anim) {
        this.anim = anim;
    }


    public AnimLayout(Context context) {
        super(context);
        initialize();
    }

    public AnimLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public AnimLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    protected void initialize() {
        anim = new AnimBaiYeChuang(this);
    }

    public void startAnimation() {
        mIsAnimaionRun = true;
        startTime = System.currentTimeMillis();

        invalidate();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {

        if( !mIsAnimaionRun ) {
            return;
        }

        long currentTime = System.currentTimeMillis();
        float rate = ((float)(currentTime - startTime) )/ anim.totalPaintTime;

        anim.handleCanvas(canvas,rate);

        super.dispatchDraw(canvas);

        if (rate < 1) {
            invalidate();
        }
    }
}
