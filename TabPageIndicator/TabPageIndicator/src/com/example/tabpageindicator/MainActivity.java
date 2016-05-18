package com.example.tabpageindicator;

import com.viewpagerindicator.TabPageIndicator;

import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

	private TabPageIndicator mIndicator;
	private ViewPager mViewPager;
	private TabAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mIndicator = (TabPageIndicator) findViewById(R.id.id_indicator);
		mViewPager = (ViewPager) findViewById(R.id.viewPager);
		mAdapter = new TabAdapter(getSupportFragmentManager());
		mViewPager.setAdapter(mAdapter);
		//第二个参数的意思是设置初始位置
		mIndicator.setViewPager(mViewPager, 0);
	}



}
