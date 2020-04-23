package com.example.ex2_coursera;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public abstract class SingleFragmentActivity extends AppCompatActivity {

	private final String TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.v(TAG, "ContentSet = ac_single_fragment");
		setContentView(R.layout.ac_single_fragment);

		if (savedInstanceState == null) {
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.fragmentContainer, getFragment())
					.commit();
		}
	}

	protected abstract Fragment getFragment();

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_ma, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public void onBackPressed() {
		FragmentManager fragmentManager = getSupportFragmentManager();
		if (fragmentManager.getBackStackEntryCount() == 1) {
			Log.v(TAG, "Exit from APP");
			finish();
		} else {
			Log.v(TAG, "Back Fragment");
			fragmentManager.popBackStack();
		}
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		switch (item.getItemId()) {
			case R.id.actionSettings:
				getSupportFragmentManager()
						.beginTransaction()
						.replace(R.id.fragmentContainer, SettingsFragment.newInstance())
						.addToBackStack(SettingsFragment.class.getName())
						.commit();
				showToastMessage("Настройки");
				break;
			case R.id.actionSearch:
				getSupportFragmentManager()
						.beginTransaction()
						.replace(R.id.fragmentContainer, SearchFragment.newInstance())
						.addToBackStack(SettingsFragment.class.getName())
						.commit();
				showToastMessage("Поиск");
				break;
			case R.id.actionExit:
				finish();
				showToastMessage("Выход");
				break;
			default:
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	private void showToastMessage(String message) {
		Toast.makeText(this, message, Toast.LENGTH_LONG).show();
	}
}
