package com.example.imagesviewpagertest.adapters;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;

public class ImagesViewPagerAdapter extends BaseViewPagerAdapter {
	
	private List<Bitmap> mImages = new ArrayList<Bitmap>();

	public ImagesViewPagerAdapter(Context context, ArrayList<Bitmap> images) {
		super(context);
		
		if (images != null && !images.isEmpty())
			mImages.addAll(images);
	}

	@Override
	public Bitmap getBitmap(int position) {
		Bitmap image = null;
		
		if (mImages != null && !mImages.isEmpty())
			image = mImages.get(position);
		
		return image;
	}

	@Override
	public int getCount() {
		return mImages.size();
	}


}
