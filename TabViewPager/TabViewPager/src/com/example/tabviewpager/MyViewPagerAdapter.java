package com.example.tabviewpager;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;


public class MyViewPagerAdapter extends PagerAdapter {

	private Context context;
	private List<View> mList;
	
	public MyViewPagerAdapter(Context context, List<View> mList) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.mList = mList;
		
	}

	

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		container.removeView(mList.get(position));
	}



	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub

		container.addView(mList.get(position));
		return mList.get(position);
	}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

	

}
