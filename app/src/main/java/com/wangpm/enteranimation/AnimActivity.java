package com.wangpm.enteranimation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import anim.Anim;
import anim.AnimBaiYeChuang;
import anim.AnimCaChu;
import anim.AnimHeZhuang;
import anim.AnimJieTi;
import anim.AnimLunZi;
import anim.AnimPiLie;
import anim.AnimQiPan;
import anim.AnimQieRu;
import anim.AnimShanXingZhanKai;
import anim.AnimShiZiXingKuoZhan;
import anim.AnimSuiJiXianTiao;
import anim.AnimXiangNeiRongJie;
import anim.AnimYuanXingKuoZhan;
import anim.AnimLingXing;


public class AnimActivity extends Activity implements View.OnClickListener {
    private CheckBox mCheckBoxApplyActivity;
    private CheckBox mCheckBoxIsExit;

    private EnterAnimLayout enterAnimLayout;
    private EnterAnimLayout enterAnimRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anims);
        mCheckBoxApplyActivity = (CheckBox) findViewById(R.id.check_box_apply_activity);
        mCheckBoxIsExit = (CheckBox) findViewById(R.id.check_box_is_exit);

        enterAnimLayout = (EnterAnimLayout)  findViewById(R.id.anim_layout);
        enterAnimRootView = (EnterAnimLayout)  findViewById(R.id.activity_main);

        //打开页面时给anim_layout播放百叶窗效果
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Anim anim = new AnimBaiYeChuang(enterAnimLayout);
                anim.startAnimation();
            }
        }, 1000);

        findViewById(R.id.btn_baiyechuang).setOnClickListener(this);
        findViewById(R.id.btn_cachu).setOnClickListener(this);
        findViewById(R.id.btn_hezhuang).setOnClickListener(this);
        findViewById(R.id.btn_jieti).setOnClickListener(this);
        findViewById(R.id.btn_lingxing).setOnClickListener(this);
        findViewById(R.id.btn_lunzi).setOnClickListener(this);
        findViewById(R.id.btn_pilie).setOnClickListener(this);
        findViewById(R.id.btn_qipan).setOnClickListener(this);
        findViewById(R.id.btn_qieru).setOnClickListener(this);
        findViewById(R.id.btn_shanxingzhankai).setOnClickListener(this);
        findViewById(R.id.btn_shizixingkuozhan).setOnClickListener(this);
        findViewById(R.id.btn_suijixiantiao).setOnClickListener(this);
        findViewById(R.id.btn_xiangneirongjie).setOnClickListener(this);
        findViewById(R.id.btn_yuanxingkuozhan).setOnClickListener(this);
    }

    @Override
    public void onClick(final View view) {
        Anim anim1 =null;
        Anim anim2 =null;
        EnterAnimLayout view1 = enterAnimLayout;
        final EnterAnimLayout view2 = (EnterAnimLayout) view.getParent();
        //如果选中了checkbox，则播放整个页面，把activity的根view赋给view1，否则 view1为顶部的anim_layout
        if (mCheckBoxApplyActivity.isChecked()) {
            view1 = enterAnimRootView;
        }
        if(view1.isAnimationRun() || view2.isAnimationRun() ){
            // 正在播放动画中
            return;
        }
        switch (view.getId()) {
            case R.id.btn_baiyechuang:
                anim1 = new AnimBaiYeChuang(view1);
                anim2 = new AnimBaiYeChuang(view2);
                break;
            case R.id.btn_cachu:
                anim1 = new AnimCaChu(view1);
                anim2 = new AnimCaChu(view2);
                break;
            case R.id.btn_hezhuang:
                anim1 = new AnimHeZhuang(view1);
                anim2 = new AnimHeZhuang(view2);
                break;
            case R.id.btn_jieti:
                anim1 = new AnimJieTi(view1);
                anim2 = new AnimJieTi(view2);
                break;
            case R.id.btn_lingxing:
                anim1 = new AnimLingXing(view1);
                anim2 = new AnimLingXing(view2);
                break;
            case R.id.btn_lunzi:
                anim1 = new AnimLunZi(view1);
                anim2 = new AnimLunZi(view2);
                break;
            case R.id.btn_pilie:
                anim1 = new AnimPiLie(view1);
                anim2 = new AnimPiLie(view2);
                break;
            case R.id.btn_qipan:
                anim1 = new AnimQiPan(view1);
                anim2 = new AnimQiPan(view2);
                break;
            case R.id.btn_qieru:
                anim1 = new AnimQieRu(view1);
                anim2 = new AnimQieRu(view2);
                break;
            case R.id.btn_shanxingzhankai:
                anim1 = new AnimShanXingZhanKai(view1);
                anim2 = new AnimShanXingZhanKai(view2);
                break;
            case R.id.btn_shizixingkuozhan:
                anim1 = new AnimShiZiXingKuoZhan(view1);
                anim2 = new AnimShiZiXingKuoZhan(view2);
                break;
            case R.id.btn_suijixiantiao:
                anim1 = new AnimSuiJiXianTiao(view1);
                anim2 = new AnimSuiJiXianTiao(view2);
                break;
            case R.id.btn_xiangneirongjie:
                anim1 = new AnimXiangNeiRongJie(view1);
                anim2 = new AnimXiangNeiRongJie(view2);
                break;
            case R.id.btn_yuanxingkuozhan:
                anim1 = new AnimYuanXingKuoZhan(view1);
                anim2 = new AnimYuanXingKuoZhan(view2);
                break;
        }
        //如果选中了checkbox，则只播放anim1，anim1绑定的view为view1，view1之前赋值为acitivity的根view
        //否则播放anim_layout和当前button的动画
        //参数为动画播放总时间
        if (mCheckBoxIsExit.isChecked()){
            anim1.isExitAnim = true;
            anim2.isExitAnim = true;
        }
        if (mCheckBoxApplyActivity.isChecked()) {
            if(view1.isAnimationRun()){
                return;
            }
            anim1.startAnimation(2000);
        } else {
            anim1.startAnimation(2000);
            anim2.startAnimation(2000);
        }

        final EnterAnimLayout finalView = view1;
        if(!mCheckBoxApplyActivity.isChecked() && mCheckBoxIsExit.isChecked()){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // exit动画播放完成后移除view2
                    if(view2 != null) {
                        ViewGroup view2Parent = (ViewGroup) view2.getParent();
                        if (view2Parent != null) {
                            view2Parent.removeView(view2);
                        }
                    }

                    // exit动画播放完成后保留view1
                    finalView.setIsAnimationRun(false);
                    finalView.invalidate();
                }
            }, 2000);
        }

        if (mCheckBoxApplyActivity.isChecked() && mCheckBoxIsExit.isChecked()){
            AnimActivity.this.setDisableAllClick(true);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // 选择 Activity的exit动画播放完成后finish掉 Activity
                    AnimActivity.this.finish();
                    AnimActivity.this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                    // 选择 Activity的exit动画播放完成后保留 Activity
//                    AnimActivity.this.setDisableAllClick(false);
//                    finalView.setIsAnimationRun(false);
//                    finalView.invalidate();
                }
            }, 2000);
        }
    }


    private boolean disableAllClick = false;

    //禁用所有触摸事件
    public Activity setDisableAllClick(boolean disableAllClick) {
        this.disableAllClick = disableAllClick;
        return this;
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (!disableAllClick) {
            return super.dispatchTouchEvent(ev);
        } else {
            return true;
        }

    }

}
