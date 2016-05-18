package com.example.tabpageindicator;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class MyFragment extends Fragment {

	private int newsType = 0;
	
	public MyFragment(int newsType) {
		this.newsType = newsType;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.tab01,null);
		TextView  text = (TextView) view.findViewById(R.id.text);
		text.setText(TabAdapter.TITLES[newsType]);
		return view;
	}
}
