package com.example.tabviewpager;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private ViewPager mViewPager;
	
	private LinearLayout tab01;
	private LinearLayout tab02;
	private LinearLayout tab03;
	private LinearLayout tab04;
	
	private LinearLayout mWeixin;
	private LinearLayout mFriend;
	private LinearLayout mAddress;
	private LinearLayout mSetting;
	
	private ImageButton mWeixin_btn;
	private ImageButton mFriend_btn;
	private ImageButton mAddress_btn;
	private ImageButton mSetting_btn;
	
	private TextView mWeixin_tv;
	private TextView mFriend_tv;
	private TextView mAddress_tv;
	private TextView mSetting_tv;
	
	private List<View> mList = new ArrayList<View>();
	private MyViewPagerAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initView();
		initViewEvent();
		
		adapter = new MyViewPagerAdapter(this, mList);
		mViewPager.setAdapter(adapter);
	}

	
	private void initViewEvent() {
	
		mWeixin.setOnClickListener(this);
		mFriend.setOnClickListener(this);
		mAddress.setOnClickListener(this);
		mSetting.setOnClickListener(this);
	
		
		//监听页面更换事件
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				int itemNum = mViewPager.getCurrentItem();
				reset();
				switch(itemNum) {
				case 0:
					mWeixin_btn.setImageResource(R.drawable.tab_weixin_pressed);
					mWeixin_tv.setTextColor(getResources().getColor(R.color.green));
					break;
				case 1:
					mFriend_btn.setImageResource(R.drawable.tab_find_frd_pressed);
					mFriend_tv.setTextColor(getResources().getColor(R.color.green));
					break;
				case 2:
					
					mAddress_btn.setImageResource(R.drawable.tab_address_pressed);
					mAddress_tv.setTextColor(getResources().getColor(R.color.green));
					break;
				case 3:
					
					mSetting_btn.setImageResource(R.drawable.tab_settings_pressed);
					mSetting_tv.setTextColor(getResources().getColor(R.color.green));
					break;
				}
			}
			
		});
	}

	private void initView() {
		mViewPager = (ViewPager) findViewById(R.id.viewPager);
		
		tab01 = (LinearLayout) findViewById(R.layout.tab01);
		tab02 = (LinearLayout) findViewById(R.layout.tab02);
		tab03 = (LinearLayout) findViewById(R.layout.tab03);
		tab04 = (LinearLayout) findViewById(R.layout.tab04);
		
		mWeixin = (LinearLayout) findViewById(R.id.tab01_ll);
		mFriend = (LinearLayout) findViewById(R.id.tab02_ll);
		mAddress = (LinearLayout) findViewById(R.id.tab03_ll);
		mSetting = (LinearLayout) findViewById(R.id.tab04_ll);
		
		mWeixin_btn = (ImageButton) findViewById(R.id.weixin_btn);
		mFriend_btn = (ImageButton) findViewById(R.id.friend_btn);
		mAddress_btn = (ImageButton) findViewById(R.id.address_btn);
		mSetting_btn = (ImageButton) findViewById(R.id.setting_btn);
		
		mWeixin_tv = (TextView) findViewById(R.id.bottom_tab01_tv);
		mFriend_tv = (TextView) findViewById(R.id.bottom_tab02_tv);
		mAddress_tv = (TextView) findViewById(R.id.bottom_tab03_tv);
		mSetting_tv = (TextView) findViewById(R.id.bottom_tab04_tv);
		
		//把布局文件转换成View(得到该布局文件的View)
		LayoutInflater inflater = LayoutInflater.from(this);
		View view01 = inflater.inflate(R.layout.tab01, null);
		View view02 = inflater.inflate(R.layout.tab02, null);
		View view03 = inflater.inflate(R.layout.tab03, null);
		View view04 = inflater.inflate(R.layout.tab04, null);
		mList.add(view01);
		mList.add(view02);
		mList.add(view03);
		mList.add(view04);
		
		mWeixin_btn.setImageResource(R.drawable.tab_weixin_pressed);
		mWeixin_tv.setTextColor(getResources().getColor(R.color.green));
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		reset();
		switch(v.getId()) {
		case R.id.tab01_ll:
			mViewPager.setCurrentItem(0);
			mWeixin_btn.setImageResource(R.drawable.tab_weixin_pressed);
			mWeixin_tv.setTextColor(getResources().getColor(R.color.green));
			break;
		case R.id.tab02_ll:
			mViewPager.setCurrentItem(1);
			mFriend_btn.setImageResource(R.drawable.tab_find_frd_pressed);
			mFriend_tv.setTextColor(getResources().getColor(R.color.green));
			break;
		case R.id.tab03_ll:
			mViewPager.setCurrentItem(2);
			mAddress_btn.setImageResource(R.drawable.tab_address_pressed);
			mAddress_tv.setTextColor(getResources().getColor(R.color.green));
			break;
		case R.id.tab04_ll:
			mViewPager.setCurrentItem(3);
			mSetting_btn.setImageResource(R.drawable.tab_settings_pressed);
			mSetting_tv.setTextColor(getResources().getColor(R.color.green));
			break;
		}
	}
  
	public void reset() {
    	mWeixin_btn.setImageResource(R.drawable.tab_weixin_normal);
    	mFriend_btn.setImageResource(R.drawable.tab_find_frd_normal);
    	mAddress_btn.setImageResource(R.drawable.tab_address_normal);
    	mSetting_btn.setImageResource(R.drawable.tab_settings_normal);
    	
    	/*
    	 * 设置字体的颜色时不能直接用R.color.white，color是自己定义的标签
    	 * 使用getResources().getColor(R.color.white)
    	 */
    	
    	mWeixin_tv.setTextColor(getResources().getColor(R.color.white));
    	mFriend_tv.setTextColor(getResources().getColor(R.color.white));
    	mAddress_tv.setTextColor(getResources().getColor(R.color.white));
		mSetting_tv.setTextColor(getResources().getColor(R.color.white));
    	
    	
    }

}
