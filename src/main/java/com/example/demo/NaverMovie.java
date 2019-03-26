package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class NaverMovie {
	private String clientId = "cJP6b4D2KXl0AeXBKsTS";
	private String clientSecret= "ehBL0m9mbS";
	
	public List<Movie> searchMovie(String text, int display) {
		List<Movie> list = null;
		
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
			list = new ArrayList<Movie>();
			
			JsonParser jsonParser = new JsonParser();
            
            JsonObject jsonObj = (JsonObject) jsonParser.parse(response.toString());
            JsonArray jsonArray = (JsonArray) jsonObj.get("items");
            System.out.println(jsonArray.size());
            
            if(jsonArray.size() > 0) {
            
            	for(int i = 0; i<jsonArray.size(); i++) {
            		JsonObject object = (JsonObject) jsonArray.get(i);
            		String tmp = object.get("title").toString();
            		tmp = tmp.replaceAll("\"", "");
            		tmp = tmp.replaceAll("<b>","");
            		tmp = tmp.replaceAll("</b>", "");
            		
            		Movie movie = new Movie();
            		movie.setM_title(tmp);
            			
            		if(object.get("image") != null) {
            			
            			movie.setM_img(object.get("image").toString());
            		}
            		if(object.get("director") != null) {
            			tmp = object.get("director").toString();
            			tmp = tmp.replaceAll("\"", "");
            			
            			movie.setM_director(tmp);
            		}
            		if(object.get("pubDate") != null) {
            			tmp = object.get("pubDate").toString();
            			tmp = tmp.replaceAll("\"", "");
            			movie.setM_pubDate(tmp);
            		}
            		if(object.get("userRating") != null) {
            			tmp = object.get("userRating").toString();
            			tmp = tmp.replaceAll("\"", "");
            			movie.setM_rating(tmp);
            		}
            		list.add(movie);
            	 }
            }
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("success");
		return list;
	}

}
