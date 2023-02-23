package anim;

import android.graphics.Canvas;
import android.util.Log;

import com.wangpm.enteranimation.EnterAnimLayout;

/**
 * Created by wpm on 2017/3/30.
 */
public abstract class Anim {
    protected EnterAnimLayout view;
    protected float w;
    protected float h;
    public float totalPaintTime;//控制绘制时间
    public boolean isExitAnim = false;

    public Anim(EnterAnimLayout view) {
        this(view,2000);
    }

    public Anim(EnterAnimLayout view, float totalPaintTime) {
        this(view, totalPaintTime, false);
    }

    public Anim(EnterAnimLayout view, float totalPaintTime, boolean isExitAnim) {
        this.totalPaintTime = totalPaintTime;
        this.view = view;
        this.view.setAnim(this);
        w = view.getWidth();
        h = view.getHeight();
        this.isExitAnim = isExitAnim;
    }

    public void startAnimation() {
        view.setIsAnimationRun(true);
        view.setStartTime(System.currentTimeMillis());
        view.invalidate();
    }
    public void startAnimation(long animTime) {
        totalPaintTime = animTime;
        startAnimation();
    }

    public abstract void handleCanvas(Canvas canvas, float rate);
}
