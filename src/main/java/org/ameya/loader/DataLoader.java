package org.ameya.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;


public class DataLoader {

	private Gson gson = new Gson();
	
	public <T> T[] readUri(String uri, Class<T[]> cls) throws IOException {
		return readJson(getJson(uri), cls);
	}

	private String getJson(String uri) throws IOException {
		URL url = new URL(uri);
		URLConnection connection = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		StringBuilder response = new StringBuilder();
		String inputLine;

		while ((inputLine = in.readLine()) != null)
			response.append(inputLine);

		in.close();
		return response.toString();
	}

	private <T> T[] readJson(String json, Class<T[]> cls) {
		return gson.fromJson(json, cls);
	}
}
