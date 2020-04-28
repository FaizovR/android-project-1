package com.example.ex3;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

	public static final int OPERATION_SLEEP_LOADER = 1;

	Button mLoadButton;
	ProgressBar mLoadingBar;
	TextView mLoadTextView;

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
	}

	@Override
	public Loader<String> onCreateLoader(int id, Bundle args) {
		mLoadButton.setEnabled(false);
		mLoadingBar.setVisibility(View.VISIBLE);
		mLoadTextView.setText("Loading..");
		return new SleepLoader(this);
	}

	@Override
	public void onLoadFinished(Loader<String> loader, String data) {
		mLoadButton.setEnabled(true);
		mLoadingBar.setVisibility(View.GONE);
		mLoadTextView.setText("Ready");
	}

	@Override
	public void onLoaderReset(Loader<String> loader) {

	}
}
