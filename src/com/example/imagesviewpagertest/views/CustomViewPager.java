package com.example.imagesviewpagertest.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class CustomViewPager extends ViewPager {
	
	private boolean mEnabled = false;

	public CustomViewPager(Context context) {
		super(context);
	}
	
	public CustomViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		if (event.getAction() == MotionEvent.ACTION_DOWN && ( event.getX() < (getWidth() - 150) && event.getX() > 150))
			return false;
		return super.onTouchEvent(event);
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent event) {
		int width = getWidth();
		int x = (int) event.getX();
		if (event.getAction() == MotionEvent.ACTION_DOWN && ( event.getX() < (getWidth() - 150) && event.getX() > 150))
			return false;
		return super.onInterceptTouchEvent(event);
	}
	
	public void enablePaging() {
		mEnabled = true;
	}
	
	public void disablePaging() {
		mEnabled = false;
	}

}
