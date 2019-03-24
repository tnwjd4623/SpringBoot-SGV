package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.stereotype.Service;

public class NaverMovie {
	private String clientId = "cJP6b4D2KXl0AeXBKsTS";
	private String clientSecret= "ehBL0m9mbS";
	
	public void  searchMovie(String text, int display) {
		List<Movie> movie = null;
		text = "사랑";
		try {
			text = URLEncoder.encode(text, "UTF-8");
			String apiURL = "https://openapi.naver.com/v1/search/movie?query="+text;
			
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id",clientId );
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			
			BufferedReader br;
			
			if(responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}
			else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			
			System.out.println(response.toString());
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
