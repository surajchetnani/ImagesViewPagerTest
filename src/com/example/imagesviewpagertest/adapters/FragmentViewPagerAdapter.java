package com.example.imagesviewpagertest.adapters;

import java.util.ArrayList;

import com.example.imagesviewpagertest.fragments.ImagesFragment;
import com.example.imagesviewpagertest.fragments.MainScreenFragment;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentViewPagerAdapter extends FragmentPagerAdapter {
	
	private int mNumberOfFragments = 2;
	private ArrayList<Bitmap> mImages;
	
	public FragmentViewPagerAdapter(FragmentManager fm, ArrayList<Bitmap> images) {
		super(fm);
		mImages = new ArrayList<Bitmap>();
		mImages.addAll(images);
	}

	@Override
	public Fragment getItem(int position) {
		if (position == 0) 
			return MainScreenFragment.newInstance();
		else if (position == 1) {
			return ImagesFragment.newInstance(mImages);
		}
		return null;
	}

	@Override
	public int getCount() {
		return mNumberOfFragments;
	}

}
