package com.example.ex2_coursera;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {
	public static final String SHARED_PREF_NAME = "SHARED_PREF_NAME_SETTINGS";
	public static final String USERS_KEY = "USER_KEY";

	private SharedPreferences mSharedPreferences;

	public SharedPreferencesHelper(Context context) {
		mSharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
	}

	public int getId() {
		return mSharedPreferences.getInt(USERS_KEY, R.id.rb_google);
	}

	public void addId(int id) {
		mSharedPreferences.edit().putInt(USERS_KEY, id).apply();
	}
}
