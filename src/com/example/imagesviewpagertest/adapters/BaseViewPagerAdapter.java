package com.example.imagesviewpagertest.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public abstract class BaseViewPagerAdapter extends PagerAdapter {
	
	public abstract Bitmap getBitmap(int position);
	
	private Context mContext;
	
	public BaseViewPagerAdapter(Context context) {
		mContext = context;
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		LinearLayout linearLayout = new LinearLayout(mContext);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		
		ImageView view = (ImageView) new ImageView(mContext);
		view.setLayoutParams(layoutParams);
		view.setImageBitmap(getBitmap(position));
		view.setVisibility(View.VISIBLE);
		linearLayout.addView(view);
		((ViewPager) container).addView(linearLayout);
		return linearLayout;
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object linearLayout) {
		((ViewPager) container).removeView((LinearLayout) linearLayout);
	}

	@Override
	public boolean isViewFromObject(View view, Object linearLayout) {
		return view == ((LinearLayout) linearLayout);
	}
	
	

}
