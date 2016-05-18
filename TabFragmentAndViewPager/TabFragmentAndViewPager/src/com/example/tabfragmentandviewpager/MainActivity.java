package com.example.tabfragmentandviewpager;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnClickListener {

	/**
	 * 如果使用
	 * android.support.v4.app.Fragment中的Fragment
	 * 则Activity一定要继承FragmentActivity
	 */
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

	private List<Fragment> mList = new ArrayList<Fragment>();
	private Fragment fragment01;
	private Fragment fragment02;
	private Fragment fragment03;
	private Fragment fragment04;

	private MyFragmentPagerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initView();
		initViewEvent();

		adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), mList);
		mViewPager.setAdapter(adapter);
	}

	private void initViewEvent() {

		mWeixin.setOnClickListener(this);
		mFriend.setOnClickListener(this);
		mAddress.setOnClickListener(this);
		mSetting.setOnClickListener(this);

		// 监听页面更换事件
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
				switch (itemNum) {
				case 0:
					mWeixin_btn.setImageResource(R.drawable.tab_weixin_pressed);
					mWeixin_tv.setTextColor(getResources().getColor(
							R.color.green));
					break;
				case 1:
					mFriend_btn
							.setImageResource(R.drawable.tab_find_frd_pressed);
					mFriend_tv.setTextColor(getResources().getColor(
							R.color.green));
					break;
				case 2:

					mAddress_btn
							.setImageResource(R.drawable.tab_address_pressed);
					mAddress_tv.setTextColor(getResources().getColor(
							R.color.green));
					break;
				case 3:

					mSetting_btn
							.setImageResource(R.drawable.tab_settings_pressed);
					mSetting_tv.setTextColor(getResources().getColor(
							R.color.green));
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

		fragment01 = new Fragment01();
		fragment02 = new Fragment02();
		fragment03 = new Fragment03();
		fragment04 = new Fragment04();

		mList.add(fragment01);
		mList.add(fragment02);
		mList.add(fragment03);
		mList.add(fragment04);

		mWeixin_btn.setImageResource(R.drawable.tab_weixin_pressed);
		mWeixin_tv.setTextColor(getResources().getColor(R.color.green));
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		reset();
		switch (v.getId()) {
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
