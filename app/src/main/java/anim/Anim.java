package anim;

import android.graphics.Canvas;
import android.view.View;

/**
 * Created by wpm on 2017/3/30.
 */
public abstract class Anim {
    protected View view;
    public float totalPaintTime;//控制绘制时间

    public Anim(View view) {
        this(view,2000);
    }

    public Anim(View view, float totalPaintTime) {
        this.totalPaintTime = totalPaintTime;
        this.view = view;
    }

    public abstract void handleCanvas(Canvas canvas, float rate);
}
