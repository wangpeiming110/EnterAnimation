package anim;

import android.graphics.Canvas;
import android.graphics.Region;
import android.view.View;

/**
 * Created by wpm on 2017/3/30.
 */

public class AnimBaiYeChuang extends Anim {
    public AnimBaiYeChuang(View view) {
        super(view);
    }

    @Override
    public void handleCanvas(Canvas canvas, float rate) {
        float y1 = h / 3 ;
        float y2 = h / 3 * 2;

        float rect1Bottom =  (h / 3 * rate);
        float rect2Bottom = rect1Bottom + h / 3 ;
        float rect3Bottom = rect2Bottom + h / 3 ;
        canvas.clipRect(0, 0,view. getWidth(), rect1Bottom);
        canvas.clipRect(0, y1,view. getWidth(), rect2Bottom, Region.Op.UNION);
        canvas.clipRect(0, y2, w, rect3Bottom, Region.Op.UNION);

        canvas.save();
    }
}
