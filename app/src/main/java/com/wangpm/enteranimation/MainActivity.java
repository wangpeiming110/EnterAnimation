package com.wangpm.enteranimation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import anim.AnimBaiYeChuang;
import anim.AnimCaChu;
import anim.AnimHeZhuang;
import anim.AnimJieTi;
import anim.AnimLunZi;
import anim.AnimPiLie;
import anim.AnimQiPan;
import anim.AnimShanXingZhanKai;
import anim.EnterAnimLayout;
import anim.AnimLingXing;


public class MainActivity extends Activity implements View.OnClickListener {

    private EnterAnimLayout enterAnimLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterAnimLayout = (EnterAnimLayout)  findViewById(R.id.anim_layout);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                enterAnimLayout.setAnim(new AnimBaiYeChuang(enterAnimLayout));
                enterAnimLayout.startAnimation();
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
        findViewById(R.id.btn_shanxingzhankai).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_baiyechuang:
                enterAnimLayout.setAnim(new AnimBaiYeChuang(enterAnimLayout));
                enterAnimLayout.startAnimation();
                break;
            case R.id.btn_cachu:
                enterAnimLayout.setAnim(new AnimCaChu(enterAnimLayout));
                enterAnimLayout.startAnimation();
                break;
            case R.id.btn_hezhuang:
                enterAnimLayout.setAnim(new AnimHeZhuang(enterAnimLayout));
                enterAnimLayout.startAnimation();
                break;
            case R.id.btn_jieti:
                enterAnimLayout.setAnim(new AnimJieTi(enterAnimLayout));
                enterAnimLayout.startAnimation();
                break;
            case R.id.btn_lingxing:
                enterAnimLayout.setAnim(new AnimLingXing(enterAnimLayout));
                enterAnimLayout.startAnimation();
                break;
            case R.id.btn_lunzi:
                enterAnimLayout.setAnim(new AnimLunZi(enterAnimLayout));
                enterAnimLayout.startAnimation();
                break;
            case R.id.btn_pilie:
                enterAnimLayout.setAnim(new AnimPiLie(enterAnimLayout));
                enterAnimLayout.startAnimation();
                break;
            case R.id.btn_qipan:
                enterAnimLayout.setAnim(new AnimQiPan(enterAnimLayout));
                enterAnimLayout.startAnimation();
                break;
            case R.id.btn_shanxingzhankai:
                enterAnimLayout.setAnim(new AnimShanXingZhanKai(enterAnimLayout));
                enterAnimLayout.startAnimation();
                break;
        }
    }
}
