package com.example.ex5;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.concurrent.TimeUnit;

public class SleepLoader extends AsyncTaskLoader<Boolean> {

	SleepLoader(Context context) {
		super(context);
	}

	@Override
	protected void onStartLoading() {
		forceLoad();
	}

	@Override
	public Boolean loadInBackground() {
		try {
			TimeUnit.MILLISECONDS.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}
}