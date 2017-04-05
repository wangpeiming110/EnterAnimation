package com.wangpm.enteranimation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import anim.AnimBaiYeChuang;
import anim.AnimCaChu;
import anim.AnimHeZhuang;
import anim.AnimJieTi;
import anim.AnimLayout;


public class MainActivity extends Activity implements View.OnClickListener {

    private AnimLayout animLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animLayout = (AnimLayout)  findViewById(R.id.anim_layout);
        animLayout.setAnim(new AnimBaiYeChuang(animLayout));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                animLayout.startAnimation();
            }
        }, 1000);

        findViewById(R.id.btn_baiyechuang).setOnClickListener(this);
        findViewById(R.id.btn_cachu).setOnClickListener(this);
        findViewById(R.id.btn_hezhuang).setOnClickListener(this);
        findViewById(R.id.btn_jieti).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_baiyechuang:
                animLayout.setAnim(new AnimBaiYeChuang(animLayout));
                animLayout.startAnimation();
                break;
            case R.id.btn_cachu:
                animLayout.setAnim(new AnimCaChu(animLayout));
                animLayout.startAnimation();
                break;
            case R.id.btn_hezhuang:
                animLayout.setAnim(new AnimHeZhuang(animLayout));
                animLayout.startAnimation();
                break;
            case R.id.btn_jieti:
                animLayout.setAnim(new AnimJieTi(animLayout));
                animLayout.startAnimation();
                break;
        }
    }
}
