package anim;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.view.View;

import com.wangpm.enteranimation.EnterAnimLayout;

/**
 * Created by wpm on 2017/3/30.
 */

public class AnimYuanXingKuoZhan extends Anim {
    public AnimYuanXingKuoZhan(EnterAnimLayout view) {
        super(view);

    }
    Path path1=new Path();
    RectF oval = new RectF();
    @Override
    public void handleCanvas(Canvas canvas, float rate) {
        path1.reset();
        oval.set((float)(1-Math.sqrt(2)*(1-rate))*w/2,(float)(1-Math.sqrt(2)*(1-rate))*h/2,
                (float)(1+Math.sqrt(2)*(1-rate))*w/2,(float)(1+Math.sqrt(2)*(1-rate))*h/2);
        path1.addOval(oval, Path.Direction.CCW);

        path1.close();//封闭
        canvas.clipPath(path1, Region.Op.DIFFERENCE);

        canvas.save();
    }
}
