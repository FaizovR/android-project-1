package com.example.ex2_coursera;

import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchFragment extends Fragment {
	private static final String STATIC_GOOGLE_URL =
			"https://google.com/search?q=";
	private static final String STATIC_YANDEX_URL =
			"https://yandex.ru/search/?text=";
	private static final String STATIC_BING_URL =
			"https://www.bing.com/search?q=";

	private EditText	mSearch;
	private Button		mSearchButton;
	private SharedPreferencesHelper mSharedPreferencesHelper;

	public static SearchFragment newInstance() {
		return new SearchFragment();
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fr_search, container, false);

		mSharedPreferencesHelper = new SharedPreferencesHelper(getActivity());

		mSearch = view.findViewById(R.id.et_fr_search);
		mSearchButton = view.findViewById(R.id.but_ft_search);

		mSearchButton.setOnClickListener(mOnEnterClickListener);
		return view;
	}

	public void openWebPage(String url) {
		Uri webpage = Uri.parse(url);
		Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
		ContextWrapper contextWrapper = new ContextWrapper(getContext());
		if (intent.resolveActivity(contextWrapper.getPackageManager()) != null) {
			startActivity(intent);
		}
	}

	private View.OnClickListener mOnEnterClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (mSharedPreferencesHelper.getId()) {
				case R.id.rb_google:
					openWebPage(STATIC_GOOGLE_URL + mSearch.getText().toString());
					break;
				case R.id.rb_yandex:
					openWebPage(STATIC_YANDEX_URL + mSearch.getText().toString());
					break;
				case R.id.rb_bing:
					openWebPage(STATIC_BING_URL + mSearch.getText().toString());
					break;
				default:
					break;
			}
		}
	};
}
