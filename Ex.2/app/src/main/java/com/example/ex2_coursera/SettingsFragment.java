package com.example.ex2_coursera;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingsFragment extends Fragment {

	private RadioGroup mRadio;
	private RadioButton mGoogle;
	private RadioButton mYandex;
	private RadioButton mBing;
	private SharedPreferencesHelper mSharedPreferencesHelper;

	public static SettingsFragment newInstance() {
		return new SettingsFragment();
	}


	@Override
	public void onPause() {
		mSharedPreferencesHelper.addId(mRadio.getCheckedRadioButtonId());
		super.onPause();
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater,
							 @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fr_settings, container, false);

		mSharedPreferencesHelper = new SharedPreferencesHelper(getActivity());

		mRadio = view.findViewById(R.id.rg_settings);
		mGoogle = view.findViewById(R.id.rb_google);
		mYandex = view.findViewById(R.id.rb_yandex);
		mBing = view.findViewById(R.id.rb_bing);
		mRadio.check(mSharedPreferencesHelper.getId());

		return view;
	}
}
