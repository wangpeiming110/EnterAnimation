package anim;

import android.graphics.Canvas;
import android.graphics.Region;
import android.util.Log;
import android.view.View;

/**
 * Created by wpm on 2017/3/30.
 */

public class AnimJieTi extends Anim {
    public AnimJieTi(View view) {
        super(view);
        timePerLine =  totalPaintTime - (timeInterval* (lineNum-1));
    }

    float lineNum = 5;
    float timeInterval = 200;

    float timePerLine;

    @Override
    public void handleCanvas(Canvas canvas, float rate) {

        float left1 = w - (rate*totalPaintTime - 0*timeInterval)/timePerLine *w;
        float top1 = h/lineNum *0;
        float right1 = w;
        float bottom1 = top1 + h / lineNum;
        canvas.clipRect(left1, top1,right1,bottom1);

        for(int i = 1; i< lineNum; i++) {
            float left = w - (rate*totalPaintTime - i*timeInterval)/timePerLine *w;
            float top = h/lineNum *i;
            float right = w;
            float bottom = top + h / lineNum;
            canvas.clipRect(left, top,right,bottom, Region.Op.UNION);
        }

        canvas.save();
    }
}
