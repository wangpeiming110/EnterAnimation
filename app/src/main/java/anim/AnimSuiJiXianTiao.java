package anim;

import android.graphics.Canvas;
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

    @Override
    public void handleCanvas(Canvas canvas, float rate) {
        int needNum = (int) ((h - 1) * rate - (h - 1 - restNum));
        canvas.clipRect(0, 0, 0, 0);
        for (int i = 0; i < needNum; i++)
        {
            int r = random.nextInt(restNum - i);
            canvas.clipRect(0, lines[r], w, lines[r] + 1, Region.Op.UNION);

            int temp = lines[r];
            lines[r] = lines[restNum - i - 1];
            lines[restNum - 1 -i] = temp;
        }
        for(int i = 0;i<(h-1) -restNum;i++) {
            canvas.clipRect(0, lines[(int) (h - 2 - i)], w, lines[(int) (h - 2 - i)] + 1, Region.Op.UNION);
        }

        restNum = restNum - needNum;
        canvas.save();
    }

}
