package com.example.ex2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class BroadcastR extends BroadcastReceiver {

	public static final String NAME = "com.example.ex2";

	private WeakReference<ProgressBar> progressBarWeakReference;

	public BroadcastR(ProgressBar progressBar) {
		progressBarWeakReference = new WeakReference<>(progressBar);
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		ProgressBar progressBar = progressBarWeakReference.get();
		int counter = ((MainActivity) context).boundService.getCounter();

		progressBar.setProgress(counter);
		if (counter == 100) {
			Toast.makeText(context, "Загрузка завершена", Toast.LENGTH_SHORT).show();
		}

	}
}
