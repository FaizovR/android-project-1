package com.example.a1_coursera_android.utilities;

import android.net.Uri;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUtils {

	private static final String STATIC_GOOGLE_URL =
			"https://google.com/search";

	final static String QUERY_PARAM = "q";

	public static String buildUrl(String searchText) {
		Uri builtUri = Uri.parse(STATIC_GOOGLE_URL).buildUpon()
				.appendQueryParameter(QUERY_PARAM, searchText)
				.build();

		URL url = null;
		try {
			url = new URL(builtUri.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return url.toString();
	}
}
