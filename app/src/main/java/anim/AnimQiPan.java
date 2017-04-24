package anim;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Region;
import android.view.View;

import com.wangpm.enteranimation.EnterAnimLayout;

/**
 * Created by wpm on 2017/3/30.
 */

public class AnimQiPan extends Anim {
    public AnimQiPan(EnterAnimLayout view) {
        super(view);
    }

    float rowNum = 10;
    float colNum = 7;


    Path path = new Path();
    @Override
    public void handleCanvas(Canvas canvas, float rate) {
        path.reset();
        for(int i = 0; i< rowNum; i++) {
            float leftStart = i%2==0?0:-(w/colNum)/2 ;
            for(int j = 0;j < colNum+1;j++) {
                float left = leftStart + j*w/colNum;
                float top = h/ rowNum *i;
                float right = left+ w/colNum*rate;
                float bottom = top + h / rowNum;
                path.addRect(left, top,right,bottom, Path.Direction.CW);
            }
        }
        canvas.clipPath(path);
        canvas.save();
    }
}
