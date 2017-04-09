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
import anim.AnimQieRu;
import anim.AnimShanXingZhanKai;
import anim.AnimShiZiXingKuoZhan;
import anim.AnimSuiJiXianTiao;
import anim.AnimXiangNeiRongJie;
import anim.AnimYuanXingKuoZhan;
import anim.AnimLingXing;


public class MainActivity extends Activity implements View.OnClickListener {

    private EnterAnimLayout enterAnimLayout;

    private EnterAnimLayout animBaiyechuang;
    private EnterAnimLayout animCachu;
    private EnterAnimLayout animHezhuang;
    private EnterAnimLayout animJieti;
    private EnterAnimLayout animLingxing;
    private EnterAnimLayout animLunzi;
    private EnterAnimLayout animPilie;
    private EnterAnimLayout animQipan;
    private EnterAnimLayout animQieru;
    private EnterAnimLayout animShanxingzhankai;
    private EnterAnimLayout animShizixingkuozhan;
    private EnterAnimLayout animSuijixiantiao;
    private EnterAnimLayout animXiangneirongjie;
    private EnterAnimLayout animYuanxingkuozhan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterAnimLayout = (EnterAnimLayout)  findViewById(R.id.anim_layout);

        animBaiyechuang = (EnterAnimLayout) findViewById(R.id.anim_baiyechuang);
        animCachu = (EnterAnimLayout) findViewById(R.id.anim_cachu);
        animHezhuang = (EnterAnimLayout) findViewById(R.id.anim_hezhuang);
        animJieti = (EnterAnimLayout) findViewById(R.id.anim_jieti);
        animLingxing = (EnterAnimLayout) findViewById(R.id.anim_lingxing);
        animLunzi = (EnterAnimLayout) findViewById(R.id.anim_lunzi);
        animPilie = (EnterAnimLayout) findViewById(R.id.anim_pilie);
        animQipan = (EnterAnimLayout) findViewById(R.id.anim_qipan);
        animQieru = (EnterAnimLayout) findViewById(R.id.anim_qieru);
        animShanxingzhankai = (EnterAnimLayout) findViewById(R.id.anim_shanxingzhankai);
        animShizixingkuozhan = (EnterAnimLayout) findViewById(R.id.anim_shizixingkuozhan);
        animSuijixiantiao = (EnterAnimLayout) findViewById(R.id.anim_suijixiantiao);
        animXiangneirongjie = (EnterAnimLayout) findViewById(R.id.anim_xiangneirongjie);
        animYuanxingkuozhan = (EnterAnimLayout) findViewById(R.id.anim_yuanxingkuozhan);

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
        findViewById(R.id.btn_qieru).setOnClickListener(this);
        findViewById(R.id.btn_shanxingzhankai).setOnClickListener(this);
        findViewById(R.id.btn_shizixingkuozhan).setOnClickListener(this);
        findViewById(R.id.btn_suijixiantiao).setOnClickListener(this);
        findViewById(R.id.btn_xiangneirongjie).setOnClickListener(this);
        findViewById(R.id.btn_yuanxingkuozhan).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_baiyechuang:
                enterAnimLayout.setAnim(new AnimBaiYeChuang(enterAnimLayout));
                enterAnimLayout.startAnimation(2000);
                animBaiyechuang.setAnim(new AnimBaiYeChuang(animBaiyechuang));
                animBaiyechuang.startAnimation(2000);
                break;
            case R.id.btn_cachu:
                enterAnimLayout.setAnim(new AnimCaChu(enterAnimLayout));
                enterAnimLayout.startAnimation(2000);
                animCachu.setAnim(new AnimCaChu(animCachu));
                animCachu.startAnimation(2000);
                break;
            case R.id.btn_hezhuang:
                enterAnimLayout.setAnim(new AnimHeZhuang(enterAnimLayout));
                enterAnimLayout.startAnimation(2000);
                animHezhuang.setAnim(new AnimHeZhuang(animHezhuang));
                animHezhuang.startAnimation(2000);
                break;
            case R.id.btn_jieti:
                enterAnimLayout.setAnim(new AnimJieTi(enterAnimLayout));
                enterAnimLayout.startAnimation(3000);
                animJieti.setAnim(new AnimJieTi(animJieti));
                animJieti.startAnimation(3000);
                break;
            case R.id.btn_lingxing:
                enterAnimLayout.setAnim(new AnimLingXing(enterAnimLayout));
                enterAnimLayout.startAnimation(4000);
                animLingxing.setAnim(new AnimLingXing(animLingxing));
                animLingxing.startAnimation(4000);
                break;
            case R.id.btn_lunzi:
                enterAnimLayout.setAnim(new AnimLunZi(enterAnimLayout));
                enterAnimLayout.startAnimation(1000);
                animLunzi.setAnim(new AnimLunZi(animLunzi));
                animLunzi.startAnimation(1000);
                break;
            case R.id.btn_pilie:
                enterAnimLayout.setAnim(new AnimPiLie(enterAnimLayout));
                enterAnimLayout.startAnimation(2000);
                animPilie.setAnim(new AnimPiLie(animPilie));
                animPilie.startAnimation(2000);
                break;
            case R.id.btn_qipan:
                enterAnimLayout.setAnim(new AnimQiPan(enterAnimLayout));
                enterAnimLayout.startAnimation(2000);
                animQipan.setAnim(new AnimQiPan(animQipan));
                animQipan.startAnimation(2000);
                break;
            case R.id.btn_qieru:
                enterAnimLayout.setAnim(new AnimQieRu(enterAnimLayout));
                enterAnimLayout.startAnimation(2000);
                animQieru.setAnim(new AnimQieRu(animQieru));
                animQieru.startAnimation(2000);
                break;
            case R.id.btn_shanxingzhankai:
                enterAnimLayout.setAnim(new AnimShanXingZhanKai(enterAnimLayout));
                enterAnimLayout.startAnimation(2000);
                animShanxingzhankai.setAnim(new AnimShanXingZhanKai(animShanxingzhankai));
                animShanxingzhankai.startAnimation(2000);
                break;
            case R.id.btn_shizixingkuozhan:
                enterAnimLayout.setAnim(new AnimShiZiXingKuoZhan(enterAnimLayout));
                enterAnimLayout.startAnimation(2000);
                animShizixingkuozhan.setAnim(new AnimShiZiXingKuoZhan(animShizixingkuozhan));
                animShizixingkuozhan.startAnimation(2000);
                break;
            case R.id.btn_suijixiantiao:
                enterAnimLayout.setAnim(new AnimSuiJiXianTiao(enterAnimLayout));
                enterAnimLayout.startAnimation(2000);
                animSuijixiantiao.setAnim(new AnimSuiJiXianTiao(animSuijixiantiao));
                animSuijixiantiao.startAnimation(2000);
                break;
            case R.id.btn_xiangneirongjie:
                enterAnimLayout.setAnim(new AnimXiangNeiRongJie(enterAnimLayout));
                enterAnimLayout.startAnimation(2000);
                animXiangneirongjie.setAnim(new AnimXiangNeiRongJie(animXiangneirongjie));
                animXiangneirongjie.startAnimation(2000);
                break;
            case R.id.btn_yuanxingkuozhan:
                enterAnimLayout.setAnim(new AnimYuanXingKuoZhan(enterAnimLayout));
                enterAnimLayout.startAnimation(2000);
                animYuanxingkuozhan.setAnim(new AnimYuanXingKuoZhan(animYuanxingkuozhan));
                animYuanxingkuozhan.startAnimation(2000);
                break;
        }
    }
}
