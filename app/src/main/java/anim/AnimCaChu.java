package anim;

import android.graphics.Canvas;
import android.view.View;

/**
 * Created by wpm on 2017/3/30.
 */

public class AnimCaChu extends Anim {
    public AnimCaChu(View view) {
        super(view);
    }

    @Override
    public void handleCanvas(Canvas canvas, float rate) {
        float rectTop =  (h - h * rate);
        canvas.clipRect(0, rectTop, w, h);

        canvas.save();
    }
}
