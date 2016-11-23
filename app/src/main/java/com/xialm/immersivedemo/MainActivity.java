package com.xialm.immersivedemo;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView(); //获取当前界面的decorview
            int option = View.SYSTEM_UI_FLAG_FULLSCREEN; //全屏,隐藏状态栏(带LAYOUT的不行),导航栏不会隐藏
            decorView.setSystemUiVisibility(option);
        }

        // 根据Android的设计,actionbar是不应该独立于状态栏而单独显示的,如果状态栏隐藏了,也要隐藏actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}
