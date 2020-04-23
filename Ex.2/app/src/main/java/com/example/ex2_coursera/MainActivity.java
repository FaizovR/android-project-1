package com.example.ex2_coursera;

import android.support.v4.app.Fragment;

public class MainActivity extends SingleFragmentActivity {

	@Override
	protected Fragment getFragment() {
		return MainFragment.newInstance();
	}
}
