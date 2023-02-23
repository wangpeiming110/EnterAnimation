package anim;

import android.graphics.Canvas;
import android.graphics.Region;
import android.util.Log;
import android.view.View;

import com.wangpm.enteranimation.EnterAnimLayout;

/**
 * Created by wpm on 2017/3/30.
 */

public class AnimHeZhuang extends Anim {
    public AnimHeZhuang(EnterAnimLayout view) {
        super(view);
    }

    @Override
    public void handleCanvas(Canvas canvas, float rate) {
        float rectLeft =  (w/2 * rate);
        float rectRight = w - rectLeft;
        float rectTop = (h/2 * rate);
        float rectBottom = h - rectTop;

        //剪切需要展示的区域
        if(isExitAnim) {
            canvas.clipRect(rectLeft, rectTop,rectRight , rectBottom);
        }else{
            canvas.clipRect(rectLeft, rectTop,rectRight , rectBottom, Region.Op.DIFFERENCE);
        }
        canvas.save();
    }
}
