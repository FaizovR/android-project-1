package com.example.ex3;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.concurrent.TimeUnit;

public class SleepLoader extends AsyncTaskLoader<String> {

	public SleepLoader(Context context) {
		super(context);
	}

	@Override
	protected void onStartLoading() {
		forceLoad();
	}

	@Override
	public String loadInBackground() {
		try {
			TimeUnit.MILLISECONDS.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
