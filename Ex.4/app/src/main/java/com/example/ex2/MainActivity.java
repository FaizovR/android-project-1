package com.example.ex2;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

	BoundService boundService;
	boolean isServiceActive = false;
	private BroadcastR mBroadcastReceiver;
	private IntentFilter mIntentFilter;

	ProgressBar mProgressBar;
	Button mReturnButton;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mProgressBar = findViewById(R.id.pb_progressbar);
		mReturnButton = findViewById(R.id.btn_return_button);

		mReturnButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isServiceActive) {
					boundService.updateToLowCounter();
				}
			}
		});

		mBroadcastReceiver = new BroadcastR(mProgressBar);
		mIntentFilter = new IntentFilter(BroadcastR.NAME);
	}

	private ServiceConnection serviceConnection = new ServiceConnection() {
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			BoundService.ProgressBinder binder = (BoundService.ProgressBinder) service;
			boundService = binder.getBoundService();
			isServiceActive = true;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			isServiceActive = false;
		}
	};

	@Override
	protected void onStart() {
		super.onStart();
		Intent intent = new Intent(this, BoundService.class);
		bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
	}

	@Override
	protected void onResume() {
		super.onResume();
		registerReceiver(mBroadcastReceiver, mIntentFilter);
	}

	@Override
	protected void onStop() {
		super.onStop();
		if (isServiceActive) {
			unbindService(serviceConnection);
			isServiceActive = false;
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(mBroadcastReceiver);
	}
}
