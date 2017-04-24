package com.wangpm.enteranimation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
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


public class MainActivity extends Activity implements View.OnClickListener {
    private CheckBox mCheckBox;

    private EnterAnimLayout enterAnimLayout;
    private EnterAnimLayout enterAnimRootView;

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
        mCheckBox = (CheckBox) findViewById(R.id.check_box);

        enterAnimLayout = (EnterAnimLayout)  findViewById(R.id.anim_layout);
        enterAnimRootView = (EnterAnimLayout)  findViewById(R.id.activity_main);

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
    public void onClick(View view) {
        Anim anim1 =null;
        Anim anim2 =null;
        EnterAnimLayout view1 = enterAnimLayout;
        EnterAnimLayout view2 = (EnterAnimLayout) view.getParent();
        if (mCheckBox.isChecked()) {
            view1 = enterAnimRootView;
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
        if (mCheckBox.isChecked()) {
            anim1.startAnimation(2000);
        } else {
            anim1.startAnimation(2000);
            anim2.startAnimation(2000);
        }

    }
}
