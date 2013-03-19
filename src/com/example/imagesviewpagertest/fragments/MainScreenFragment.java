package com.example.imagesviewpagertest.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.imagesviewpagertest.R;
import com.example.imagesviewpagertest.activities.MainActivity;

public class MainScreenFragment extends Fragment {
	
	private ImageButton mButton;
	
	public static MainScreenFragment newInstance() {
		return new MainScreenFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.main_fragment, container, false);
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		mButton = (ImageButton) getActivity().findViewById(R.id.images_button);
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
