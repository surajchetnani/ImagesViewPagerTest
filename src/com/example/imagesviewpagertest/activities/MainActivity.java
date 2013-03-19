package com.example.imagesviewpagertest.activities;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.example.imagesviewpagertest.R;
import com.example.imagesviewpagertest.adapters.FragmentViewPagerAdapter;
import com.example.imagesviewpagertest.fragments.ImagesFragment;
import com.example.imagesviewpagertest.utils.ImageUtils;
import com.example.imagesviewpagertest.views.CustomViewPager;

public class MainActivity extends FragmentActivity {

	private ArrayList<Bitmap> mImages;
	private CustomViewPager mViewPager;
	
	private boolean buttonTouched;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mImages = new ArrayList<Bitmap>();

		new FetchImages().execute();

	}
	
	public boolean isButtonTouched() {
		return buttonTouched;
	}

	private class FetchImages extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			String url = "http://placekitten.com/200/300";
			Bitmap image1 = ImageUtils.fetchBitmapFromUrl(url);
			Bitmap image2 = ImageUtils.fetchBitmapFromUrl(url);
			Bitmap image3 = ImageUtils.fetchBitmapFromUrl(url);

			mImages.add(image1);
			mImages.add(image2);
			mImages.add(image3);

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {

			FragmentManager fragmentManager = getSupportFragmentManager();

			FragmentViewPagerAdapter adapter = new FragmentViewPagerAdapter(
					fragmentManager, mImages);

			mViewPager = (CustomViewPager) findViewById(R.id.main_view_pager);
			mViewPager.setAdapter(adapter);

			super.onPostExecute(result);
		}

	}

	public void mainButtonTouched() {
		mViewPager.enablePaging();

	}
	
	public void imagesButtonTouched() {
		mViewPager.enablePaging();
	}
	
	public void disableViewPagerSlide(){
		mViewPager.disablePaging();
	}

}
