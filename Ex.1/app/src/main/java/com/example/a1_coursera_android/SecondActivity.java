package com.example.a1_coursera_android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.a1_coursera_android.utilities.NetworkUtils.buildUrl;

public class SecondActivity extends AppCompatActivity {

	private final static 	String KEY_TEXT = "TEXT";
	private TextView 		mView;
	private Button 			mButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ac_second);

		mView = findViewById(R.id.tv_secondAc);
		mButton = findViewById(R.id.but_editButtonAC);

		Bundle bundle = getIntent().getExtras();
		mView.setText(bundle.getString(KEY_TEXT));
		mButton.setOnClickListener(mOnButtonClickListener);
	}

	private View.OnClickListener mOnButtonClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			String url = buildUrl(mView.getText().toString());
			openWebPage(url);
		}
	};

	public void openWebPage(String url) {
		Uri webpage = Uri.parse(url);
		Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
		if (intent.resolveActivity(getPackageManager()) != null) {
			startActivity(intent);
		}
	}
}
