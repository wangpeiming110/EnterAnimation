package anim;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Region;
import android.util.Log;
import android.view.View;

import com.wangpm.enteranimation.EnterAnimLayout;

/**
 * Created by wpm on 2017/3/30.
 */

public class AnimJieTi extends Anim {
    public AnimJieTi(EnterAnimLayout view) {
        super(view);
        //每一行从起跑到终点所需要的时间 = 总时间 - 第一行“等待”其他所有行跑完的时间
        timePerLine =  totalPaintTime - (timeInterval* (lineNum-1));
    }

    float lineNum = 5;//阶梯的行数
    float timeInterval = 200;//每一行阶梯与上一行起跑时间差

    float timePerLine;//每一行从起跑到终点所需要的时间

    Path path = new Path();
    @Override
    public void handleCanvas(Canvas canvas, float rate) {
        path.reset();

        float left1 = w - (rate*totalPaintTime - 0*timeInterval)/timePerLine *w;
        float top1 = h/lineNum *0;
        float right1 = w;
        float bottom1 = top1 + h / lineNum;

        path.addRect(left1, top1,right1,bottom1, Path.Direction.CW);

        //计算每一行需要展示的左上右下，最后一起剪切
        for(int i = 1; i< lineNum; i++) {
            float left = w - (rate*totalPaintTime - i*timeInterval)/timePerLine *w;
            float top = h/lineNum *i;
            float right = w;
            float bottom = top + h / lineNum;
            path.addRect(left,top,right,bottom, Path.Direction.CW);
        }
        if(isExitAnim) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
        }else{
            canvas.clipPath(path);
        }
        canvas.save();
    }
}
