package anim;

import android.graphics.Canvas;
import android.graphics.Region;
import android.view.View;

/**
 * Created by wpm on 2017/3/30.
 */

public class AnimQieRu extends Anim {
    public AnimQieRu(View view) {
        super(view);
    }

    @Override
    public void handleCanvas(Canvas canvas, float rate) {

        canvas.translate(0,h-h*rate);

        canvas.save();
    }
}
