package com.example.a1_coursera_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	private final static String KEY_TEXT = "TEXT";
	private EditText	mEnterText;
	private Button		mEnter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mEnterText = findViewById(R.id.et_enterText);
		mEnter = findViewById(R.id.but_editButton);

		mEnter.setOnClickListener(mOnEnterClickListener);
	}

	private View.OnClickListener mOnEnterClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			if (isTextValid()) {
				Intent startIntent = new Intent(MainActivity.this, SecondActivity.class);
				startIntent.putExtra(KEY_TEXT, mEnterText.getText().toString());
				startActivity(startIntent);
				showMessage(mEnterText.getText().toString());
			}
		}
	};

	private void showMessage(String message) {
		Toast.makeText(this, message, Toast.LENGTH_LONG).show();
	}

	private boolean isTextValid() {
		return !TextUtils.isEmpty(mEnterText.getText());
	}
}
