package com.example.tabpageindicator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {

	public static final String[] TITLES = 
			new String[]{"微信", "朋友", "通讯录", "设置"};
	public TabAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override  
    public CharSequence getPageTitle(int position) {  
        return TITLES[position % TITLES.length];  
    }  
	
	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		Fragment fg = new MyFragment(arg0);
		return fg;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return TITLES.length;
	}

}
