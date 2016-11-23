package com.xialm.immersivedemo;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * 沉浸式状态栏:(名字不确切,但是大家都这么叫),在屏幕的状态栏位置往下拉,或者在屏幕的导航栏位置往上拉,
 * 都可以重新显示状态栏和导航栏,显示一段时间之后,可以自动隐藏;
 * 如果做游戏或者视频类软件,同时还建议把屏幕写死为横屏:android:screenOrientation="landscape"
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if (Build.VERSION.SDK_INT >= 21) {
//            View decorView = getWindow().getDecorView(); //获取当前界面的decorview
////            int option = View.SYSTEM_UI_FLAG_FULLSCREEN; //全屏,隐藏状态栏(带LAYOUT的不行),导航栏不会隐藏
////            int option=View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;  //让应用的主体内容占用系统状态栏的空间
////            int option=View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION; //全屏,隐藏状态栏和导航栏
//            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
//                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
//            decorView.setSystemUiVisibility(option);
//            getWindow().setStatusBarColor(Color.TRANSPARENT); //设置状态栏为透明色
//            getWindow().setNavigationBarColor(Color.TRANSPARENT); // 设置导航栏为透明色
//        }
//
//        // 根据Android的设计,actionbar是不应该独立于状态栏而单独显示的,如果状态栏隐藏了,也要隐藏actionbar
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
