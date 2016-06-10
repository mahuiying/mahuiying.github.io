package com.example.mhy.qq50slidemenu;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.mhy.qq50slidemenu.view.SlidingMenu;

public class MainActivity extends Activity {

    private SlidingMenu mSlidingMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题拦
        setContentView(R.layout.activity_main);
        mSlidingMenu = (SlidingMenu) findViewById(R.id.sliding_menu);
    }

    public void toggleMenu(View view) {
        mSlidingMenu.toggle();
    }
}
