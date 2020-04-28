package com.example.ex5;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Boolean> {

	public static final int OPERATION_SLEEP_LOADER = 1;
	public static final String KEY_IS_SLEEP = "KEY_IS_SLEEP";

	private Boolean isSleep = false;

	private Button mLoadButton;
	private ProgressBar mLoadingBar;
	private TextView mLoadTextView;

	private View.OnClickListener mOnButtonPressedClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			LoaderManager loaderManager = getLoaderManager();

			loaderManager.initLoader(OPERATION_SLEEP_LOADER, null, MainActivity.this);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mLoadButton = findViewById(R.id.btn_load);
		mLoadingBar = findViewById(R.id.pb_loading_bar);
		mLoadTextView = findViewById(R.id.tv_loading_text);
		mLoadButton.setOnClickListener(mOnButtonPressedClickListener);

		if (savedInstanceState != null) {
			isSleep = savedInstanceState.getBoolean(KEY_IS_SLEEP);
			if (isSleep) {
				loading();
			}
		}

		getLoaderManager().initLoader(OPERATION_SLEEP_LOADER, null, this);
	}

	@Override
	public Loader<Boolean> onCreateLoader(int id, Bundle args) {
		loading();
		isSleep = true;
		return new SleepLoader(MainActivity.this);
	}

	@Override
	public void onLoadFinished(Loader<Boolean> loader, Boolean data) {
		isSleep = false;
		loadFinished();
	}

	@Override
	public void onLoaderReset(Loader<Boolean> loader) {

	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		outState.putBoolean(KEY_IS_SLEEP, isSleep);
		super.onSaveInstanceState(outState);
	}

	private void loading() {
		mLoadButton.setEnabled(false);
		mLoadingBar.setVisibility(View.VISIBLE);
		mLoadTextView.setText("Loading..");
	}

	private void loadFinished() {
		mLoadButton.setEnabled(true);
		mLoadingBar.setVisibility(View.GONE);
		mLoadTextView.setText("Ready");
	}
}
