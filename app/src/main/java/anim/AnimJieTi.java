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

        float left1 = view.getWidth() - (rate*totalPaintTime - 0*timeInterval)/timePerLine *view.getWidth();
        float top1 = view.getHeight()/lineNum *0;
        float right1 = view.getWidth();
        float bottom1 = top1 + view.getHeight() / lineNum;
        canvas.clipRect(left1, top1,right1,bottom1);

        for(int i = 1; i< lineNum; i++) {
            float left = view.getWidth() - (rate*totalPaintTime - i*timeInterval)/timePerLine *view.getWidth();
            float top = view.getHeight()/lineNum *i;
            float right = view.getWidth();
            float bottom = top + view.getHeight() / lineNum;
            canvas.clipRect(left, top,right,bottom, Region.Op.UNION);
        }

        canvas.save();
    }
}
