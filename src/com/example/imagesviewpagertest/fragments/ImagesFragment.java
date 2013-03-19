package com.example.imagesviewpagertest.fragments;

import java.util.ArrayList;

import android.drm.DrmStore.Action;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.imagesviewpagertest.R;
import com.example.imagesviewpagertest.activities.MainActivity;
import com.example.imagesviewpagertest.adapters.ImagesViewPagerAdapter;
import com.viewpagerindicator.CirclePageIndicator;

public class ImagesFragment extends Fragment {

	private ImagesViewPagerAdapter mAdapter;
	private ArrayList<Bitmap> mImages = new ArrayList<Bitmap>();
	private ViewPager mViewPager;
	private CirclePageIndicator mIndicator;
	private ImageButton mButton;

	public static ImagesFragment newInstance(ArrayList<Bitmap> images) {
		ImagesFragment fragment = new ImagesFragment();
		Bundle bundle = new Bundle();
		bundle.putSerializable("images", images);
		fragment.setArguments(bundle);
		return fragment;
	}

	private ArrayList<Bitmap> getImages() {
		ArrayList<Bitmap> images = new ArrayList<Bitmap>();

		images = (ArrayList<Bitmap>) getArguments().getSerializable("images");

		return images;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.images_fragment, container, false);

	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		ArrayList<Bitmap> images = getImages();

		if (images != null && !images.isEmpty())
			mImages.addAll(getImages());

		mAdapter = new ImagesViewPagerAdapter(getActivity(), mImages);

		mViewPager = (ViewPager) getActivity().findViewById(R.id.view_pager);
		mViewPager.setAdapter(mAdapter);

		mIndicator = (CirclePageIndicator) getActivity().findViewById(
				R.id.indicator);
		mIndicator.setViewPager(mViewPager);
		
		mButton = (ImageButton) getActivity().findViewById(R.id.main_button);
		mButton.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					((MainActivity) getActivity()).mainButtonTouched();
				}

				if (event.getAction() == MotionEvent.ACTION_UP) {
					((MainActivity) getActivity()).disableViewPagerSlide();
				}
				return false;
			}
		});
	}

}
