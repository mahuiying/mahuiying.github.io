package com.example.tabfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnClickListener {

	private FrameLayout frameLayout;

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

	private Fragment fragment01;
	private Fragment fragment02;
	private Fragment fragment03;
	private Fragment fragment04;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initView();
		initViewEvent();
		seletItem(0);

	}

	private void initViewEvent() {
		// TODO Auto-generated method stub
		mWeixin.setOnClickListener(this);
		mFriend.setOnClickListener(this);
		mAddress.setOnClickListener(this);
		mSetting.setOnClickListener(this);

		mWeixin_btn.setImageResource(R.drawable.tab_weixin_pressed);
		mWeixin_tv.setTextColor(getResources().getColor(R.color.green));

	}

	private void initView() {
		// TODO Auto-generated method stub
		frameLayout = (FrameLayout) findViewById(R.id.frameLayout);

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


	}

	private void seletItem(int i) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		hideFragment(transaction);
		switch (i) {
		case 0:
			if (fragment01 == null) {
				fragment01 = new Fragment01();
				//把碎片添加到所在的布局里
				transaction.add(R.id.frameLayout, fragment01);
			} else {
				transaction.show(fragment01);
			}
			break;
		case 1:
			if (fragment02 == null) {
				fragment02 = new Fragment02();
				transaction.add(R.id.frameLayout, fragment02);
			} else {
				transaction.show(fragment02);
			}
			break;
		case 2:
			if (fragment03 == null) {
				fragment03 = new Fragment03();
				transaction.add(R.id.frameLayout, fragment03);
			} else {
				transaction.show(fragment03);
			}
			break;
		case 3:
			if (fragment04 == null) {
				fragment04 = new Fragment04();
				transaction.add(R.id.frameLayout, fragment04);
			} else {
				transaction.show(fragment04);
			}
			break;
		}
		transaction.commit();
	}

	//隐藏所有存在的碎片
	private void hideFragment(FragmentTransaction transaction) {
		// TODO Auto-generated method stub
		//判断是否为空，是为了判断该碎片是否已经被加载了
		if (fragment01 != null) {
			transaction.hide(fragment01);
		} 
		if (fragment02 != null) {
			transaction.hide(fragment02);
		} 
        if (fragment03 != null) {
			transaction.hide(fragment03);
		} 
        if (fragment04 != null) {
			transaction.hide(fragment04);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		reset();
		switch (v.getId()) {
		case R.id.tab01_ll:
			seletItem(0);
			mWeixin_btn.setImageResource(R.drawable.tab_weixin_pressed);
			mWeixin_tv.setTextColor(getResources().getColor(R.color.green));
			break;
		case R.id.tab02_ll:
			seletItem(1);
			mFriend_btn.setImageResource(R.drawable.tab_find_frd_pressed);
			mFriend_tv.setTextColor(getResources().getColor(R.color.green));
			break;
		case R.id.tab03_ll:
			seletItem(2);
			mAddress_btn.setImageResource(R.drawable.tab_address_pressed);
			mAddress_tv.setTextColor(getResources().getColor(R.color.green));
			break;
		case R.id.tab04_ll:
			seletItem(3);
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
