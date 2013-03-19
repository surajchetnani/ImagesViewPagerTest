package com.example.imagesviewpagertest.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImageUtils {

	public static Bitmap fetchBitmapFromUrl(String url) {
		Bitmap bitmap = null;
		
		if (url != null)
			bitmap = fetchBitmap(url);

		return bitmap;
	}

	private static Bitmap fetchBitmap(String url) {
		HttpURLConnection connection = null;
		InputStream inputStream = null;
		Bitmap bitmap = null; 
		
		connection = getHttpUrlConnection(url);
		inputStream = getInputStream(connection);
		bitmap = getBitmap(inputStream);

		return bitmap;
	}

	private static Bitmap getBitmap(InputStream inputStream) {
		Bitmap bitmap = null;

		if (inputStream != null)
			bitmap = BitmapFactory.decodeStream(inputStream);
		
		return bitmap;
	}

	private static InputStream getInputStream(HttpURLConnection connection) {
		InputStream inputStream = null;

		try {
			if (connection != null) {
				connection.connect();
				inputStream = connection.getInputStream();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return inputStream;
	}

	private static HttpURLConnection getHttpUrlConnection(String url) {
		HttpURLConnection connection = null;

		try {
			if (url != null) {
				connection = (HttpURLConnection) new URL(url).openConnection();
				connection.setRequestProperty("User-agent", "Mozilla/4.0");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return connection;
	}

}
