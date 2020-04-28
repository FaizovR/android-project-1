package com.example.ex2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BoundService extends Service {


	private int mCounter;
	private IBinder mBinder = new ProgressBinder();
	private ScheduledExecutorService mScheduledExecutorService;
	private boolean isWorking = false;

	@Override
	public void onCreate() {
		mScheduledExecutorService = Executors.newScheduledThreadPool(1);
		mScheduledExecutorService.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				if (mBinder.isBinderAlive() && mCounter != 100) {
					updateCounter();
				}
			}
		},0, 200, TimeUnit.MILLISECONDS);
	}

	public IBinder onBind(Intent intent) {
		return mBinder;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		return super.onUnbind(intent);
	}

	public class ProgressBinder extends Binder {
		BoundService getBoundService() {
			return BoundService.this;
		}
	}

	private void updateCounter() {
		mCounter += 5;
		sendBroadcast(new Intent(BroadcastR.NAME));
	}

	public void updateToLowCounter() {
		if (mCounter <= 50) {
			mCounter = 0;
		} else {
			mCounter = mCounter - 50;
		}
		sendBroadcast(new Intent(BroadcastR.NAME));
	}

	public int getCounter() {return mCounter;}
}
