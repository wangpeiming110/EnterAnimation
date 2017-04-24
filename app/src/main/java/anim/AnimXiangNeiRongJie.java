package anim;

import android.graphics.Canvas;
import android.graphics.Region;
import android.view.View;

import com.wangpm.enteranimation.EnterAnimLayout;

import java.util.Random;

/**
 * Created by wpm on 2017/3/30.
 */

public class AnimXiangNeiRongJie extends Anim {
    private final int[] ceils;
    int restNum;
    Random random = new Random();

    int total ;
    float rowNum = 20;
    float colNum = 30;
    float ceilWidth;
    float ceilHeight;

    public AnimXiangNeiRongJie(EnterAnimLayout view) {
        super(view);
        total = (int) (rowNum*colNum);
        ceils = new int[total];
        restNum =total;
        ceilHeight = (float) Math.ceil( h / rowNum);
        ceilWidth = (float) Math.ceil(w / colNum);
        for (int i = 0; i < total; i++)
        {
            ceils[i] = i;
        }
    }

    @Override
    public void handleCanvas(Canvas canvas, float rate) {
        int needNum = (int) (total * rate - (total - restNum));//这一次绘制需要新增的随机数
        canvas.clipRect(0, 0, 0, 0);
        for (int i = 0; i < needNum; i++)
        {
            int r = random.nextInt(restNum - i);
            float left = getLeft(ceils[r]);
            float top = getTop(ceils[r]);
            canvas.clipRect(left, top, left+ceilWidth, top+ceilHeight, Region.Op.UNION);

            int temp = ceils[r];
            ceils[r] = ceils[restNum - i - 1];
            ceils[restNum - 1 -i] = temp;
        }
        for(int i = 0;i<total -restNum;i++) {
            float left = getLeft(ceils[total-1-i]);
            float top = getTop(ceils[total-1-i]);
            canvas.clipRect(left, top, left+ceilWidth, top+ceilHeight, Region.Op.UNION);
        }

        restNum = restNum - needNum;
        canvas.save();
    }


    public float  getLeft(int index) {
        int leftIndex = index % (int) colNum;
        return leftIndex * ceilWidth;
    }

    public float  getTop(int index) {
        int topIndex = index / (int) colNum;
        return topIndex * ceilHeight-1;
    }


}
