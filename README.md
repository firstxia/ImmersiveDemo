#ImmersiveDemo
沉浸式状态栏,其实这个叫法不准确,应该为沉浸式模式,这里也叫为透明状态栏,这个demo是一步一步的演化过程,最终为沉浸式状态栏效果,个人学习使用...
#实现全屏,隐藏状态栏
  
	if (Build.VERSION.SDK_INT >= 21) {
      View decorView = getWindow().getDecorView(); //获取当前界面的decorview
      int option = View.SYSTEM_UI_FLAG_FULLSCREEN; //全屏,隐藏状态栏(带LAYOUT的不行),导航栏不会隐藏
      decorView.setSystemUiVisibility(option);
    }
	
  // 根据Android的设计,actionbar是不应该独立于状态栏而单独显示的,如果状态栏隐藏了,也要隐藏actionbar
  ActionBar actionBar = getSupportActionBar();
  actionBar.hide();
#实现全屏,设置状态栏为透明色,导航栏还在

	View decorView = getWindow().getDecorView(); //获取当前界面的decorview
	int option=View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;  //让应用的主体内容占用系统状态栏的空间
	decorView.setSystemUiVisibility(option);
	getWindow().setStatusBarColor(Color.TRANSPARENT); //设置状态栏为透明色
	
#全屏,隐藏状态栏和导航栏,触摸屏幕任意位置会退出全屏
	
	View decorView = getWindow().getDecorView(); //获取当前界面的decorview
	int option=View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION; //全屏,隐藏状态栏和导航栏
	decorView.setSystemUiVisibility(option);

#全屏,设置状态栏和导航栏为透明
	View decorView = getWindow().getDecorView(); //获取当前界面的decorview
	int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
					View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
					View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
	decorView.setSystemUiVisibility(option);
	getWindow().setStatusBarColor(Color.TRANSPARENT); //设置状态栏为透明色
	getWindow().setNavigationBarColor(Color.TRANSPARENT); // 设置导航栏为透明色

#沉浸式状态栏完成,重写activity的一个方法
	  
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
