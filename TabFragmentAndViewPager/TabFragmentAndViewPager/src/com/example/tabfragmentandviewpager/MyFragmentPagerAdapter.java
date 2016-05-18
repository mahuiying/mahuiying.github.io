package com.example.tabfragmentandviewpager;

import java.util.List;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

	private List<Fragment> mList;
	
	public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> mList) {
		super(fm);
		// TODO Auto-generated constructor stub
		this.mList = mList;
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return mList.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

}
