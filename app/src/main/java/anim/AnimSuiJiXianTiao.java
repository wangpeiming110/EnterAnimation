package anim;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Region;
import android.util.Log;
import android.view.View;

import com.wangpm.enteranimation.EnterAnimLayout;

import java.util.Random;

/**
 * Created by wpm on 2017/3/30.
 */

public class AnimSuiJiXianTiao extends Anim {
    private final int[] lines;
    int restNum;
    Random random = new Random();

    public AnimSuiJiXianTiao(EnterAnimLayout view) {
        super(view);
        lines = new int[(int) h];
        restNum = (int) h -1; //线条本身占据一像素高度
        for (int i = 0; i < h-1; i++)
        {
            lines[i] = i;
        }
    }

    Path path = new Path();
    @Override
    public void handleCanvas(Canvas canvas, float rate) {
        path.reset();
        int needNum = (int) ((h - 1) * rate - (h - 1 - restNum));
        for (int i = 0; i < needNum; i++)
        {
            int r = random.nextInt(restNum - i);
            path.addRect(0, lines[r], w, lines[r] + 1, Path.Direction.CW);

            int temp = lines[r];
            lines[r] = lines[restNum - i - 1];
            lines[restNum - 1 -i] = temp;
        }
        for(int i = 0;i<(h-1) -restNum;i++) {
            path.addRect(0, lines[(int) (h - 2 - i)], w, lines[(int) (h - 2 - i)] + 1, Path.Direction.CW);
        }

        restNum = restNum - needNum;
        canvas.clipPath(path);
        canvas.save();
    }

}
