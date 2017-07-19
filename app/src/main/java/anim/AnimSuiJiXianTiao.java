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
    private final int[] lines;//线条数组
    int restNum; //剩余线条数
    Random random = new Random();

    public AnimSuiJiXianTiao(EnterAnimLayout view) {
        super(view);
        //初始化线条数组和剩余线条数量
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
        //计算这一次需要取得的线条数量
        int needNum = (int) ((h - 1) * rate - (h - 1 - restNum));
        //循环随机获取线条数组中的线条
        for (int i = 0; i < needNum; i++)
        {
            //获取到一条随机线条，添加进path中
            int r = random.nextInt(restNum - i);
            path.addRect(0, lines[r], w, lines[r] + 1, Path.Direction.CW);

            //把这一次获取到的随机线条在数组中对应的元素移至数组已取线条区域
            //保证数组中前面部分的线条都是已取线条，后面的都是未取线条
            int temp = lines[r];
            lines[r] = lines[restNum - i - 1];
            lines[restNum - 1 -i] = temp;
        }
        //遍历数组中“之前已取”的线条，全部放在path中
        for(int i = 0;i<(h-1) -restNum;i++) {
            path.addRect(0, lines[(int) (h - 2 - i)], w, lines[(int) (h - 2 - i)] + 1, Path.Direction.CW);
        }

        //剩余线条数量
        restNum = restNum - needNum;
        canvas.clipPath(path);
        canvas.save();
    }

}
