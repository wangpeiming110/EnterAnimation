package anim;

import android.graphics.Canvas;
import android.graphics.Region;
import android.view.View;

import com.wangpm.enteranimation.EnterAnimLayout;

/**
 * Created by wpm on 2017/3/30.
 */

public class AnimQieRu extends Anim {
    public AnimQieRu(EnterAnimLayout view) {
        super(view);
    }

    @Override
    public void handleCanvas(Canvas canvas, float rate) {
        if(isExitAnim) {
            canvas.translate(0,h*rate);
        }else{
            canvas.translate(0,h-h*rate);
        }
        canvas.save();
    }
}
