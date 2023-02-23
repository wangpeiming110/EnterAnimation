# EnterAnimation
android 仿ppt进入/退出/转场动画，入场/出场动画效果合集，
百叶窗效果，擦除效果，盒状效果，阶梯效果，菱形效果，轮子效果，劈裂效果，棋盘效果，
切入效果，扇形展开效果，十字扩展效果，随机线条效果，向内溶解效果，圆形扩展效果，
适用于各种view和viewgroup，activity即用于页面根部viewgroup，
自定义viewgroup自动换行layout，
看效果图</br> 

Series of entrance animation effects just like ppt in Android.
There are effects of Blinds, Wipe, Box, Strips, Diamond, Wheel, Split, Checkerboard, Peek In, Wedge, Plus, Random Bars, Dissolve In, Circle.
The Animation effects can apply to any View or ViewGroup.
There is also a custom ViewGroup of auto linefeed called SimpleLineWrapLayout to layout the buttons.
Please take a look at the images:

<img src='image/1.gif' height='300px'> <img src='image/2.gif' height='300px'> <img src='image/3.gif' height='300px'/>
<img src='image/4.gif' height='300px'> <img src='image/5.gif' height='300px'> <img src='image/6.gif' height='300px'/>
<img src='image/7.gif' height='300px'> <img src='image/8.gif' height='300px'> <img src='image/9.gif' height='300px'/>
<img src='image/10.gif' height='300px'> <img src='image/11.gif' height='300px'> <img src='image/12.gif' height='300px'/>
<img src='image/13.gif' height='300px'> <img src='image/14.gif' height='300px'/>


# Attributes

There are several attributes you can set:

| attr 属性          | description 描述 |
|:---				 |:---|
| isVisibleAtFirst   | 进入页面时视图内容是否可见，默认可见 |



### How to use

#### layout: 
在需要显示动画效果的view或viewgroup的外层包一个EnterAnimLayout，然后在java中设置具体动画和控制开始播放动画；需要播放整个activity的话同理在最外层加一个EnterAnimLayout，然后在java中设置具体动画和控制开始播放动画
```xml
        <com.wangpm.enteranimation.EnterAnimLayout
            android:id="@+id/anim_layout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center_horizontal"
            android:background="@android:color/holo_blue_bright"
            android:padding="20dp"
            >
            <LinearLayout
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:orientation="vertical"
                android:background="@android:color/holo_orange_light">
                <TextView
                    android:id="@+id/text_view"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="EnterAnimTextView"
                    android:textSize="30sp"
                    />
                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:orientation="horizontal">
                    <ImageView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:src="@mipmap/ic_launcher"
                        />
                    <Button
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="这就是一个按钮"/>
                </LinearLayout>

            </LinearLayout>
        </com.wangpm.enteranimation.EnterAnimLayout>
```

#### java: 

```java    
        enterAnimLayout = (EnterAnimLayout)  findViewById(R.id.anim_layout);
	    //oncreate中还并未获得view的具体尺寸，所以打开页面时延迟播放动画
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
			    //举例设置成百叶窗动画
                Anim anim = new AnimBaiYeChuang(enterAnimLayout);
                anim.startAnimation(2500);//开始播放动画，动画播放时长2500ms，默认2000
            }
        }, 1000);
```

# Release Notes
## [2.0.0] - 2023-02-03
### Change
- Support exit animations [#8](/../../issues/8) [#7](/../../issues/7) [#6](/../../issues/6) [#2](/../../issues/2)
- Fix interrupting active animation [#5](/../../issues/5)
