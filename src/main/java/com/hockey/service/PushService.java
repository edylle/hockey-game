package com.hockey.service;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class PushService {

	@Autowired
	private Environment environment;
	
	public void notifyAndroid(String title, String message) throws Exception {
		try {
			@SuppressWarnings("unused")
			String jsonResponse;

			URL url = new URL(environment.getProperty("onesignal.api-url"));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setUseCaches(false);
			con.setDoOutput(true);
			con.setDoInput(true);

			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			con.setRequestProperty("Authorization", "Basic " + environment.getProperty("onesignal.authentication-key"));
			con.setRequestMethod("POST");

			String strJsonBody = "{"
			                   + "\"app_id\": \""
			                   + environment.getProperty("onesignal.api-id")
			                   + "\","
							   + "\"included_segments\": [\""
							   + "All"
			                   + "\"],"
			                   + "\"contents\": {\"en\": \""
			                   + message
			                   + "\"}"
			                   + "}";

			byte[] sendBytes = strJsonBody.getBytes("UTF-8");
			con.setFixedLengthStreamingMode(sendBytes.length);

			OutputStream outputStream = con.getOutputStream();
			outputStream.write(sendBytes);

			int httpResponse = con.getResponseCode();

			if (httpResponse >= HttpURLConnection.HTTP_OK && httpResponse < HttpURLConnection.HTTP_BAD_REQUEST) {
				Scanner scanner = new Scanner(con.getInputStream(), "UTF-8");
				jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
				scanner.close();
			} else {
				Scanner scanner = new Scanner(con.getErrorStream(), "UTF-8");
				jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
				scanner.close();
			}
		} catch (Throwable t) {
			throw new Exception(t);
		}
	}
}
