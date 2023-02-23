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

public class AnimBaiYeChuang extends Anim {
    public AnimBaiYeChuang(EnterAnimLayout view) {
        super(view);
    }
    float lines = 6;//百叶窗的行数

    Path path = new Path();
    @Override
    public void handleCanvas(Canvas canvas, float rate) {
        path.reset();
        //计算百叶窗每一行当前需要展示的左上右下
        for(int i = 0;i<lines;i++) {
            float top = h / lines * i;
            float bottom = top + h / lines * rate;
            path.addRect(0, top, w, bottom, Path.Direction.CW);
        }
        if(isExitAnim) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
        }else{
            canvas.clipPath(path);
        }
        canvas.save();
    }
}
