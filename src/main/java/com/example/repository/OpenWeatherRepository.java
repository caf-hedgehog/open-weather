package com.example.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Repository;

import com.example.domain.Location;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class OpenWeatherRepository {

	public JsonNode weatherForecast(Location location) throws IOException {
		// URLをセット
		StringBuilder urlbuilder = new StringBuilder("http://api.openweathermap.org/data/2.5/weather?");
		// 都市名
		String city = "q=" + location.getCity() + ",";
		// 国名
		String country = "jp&";
		// APIキー
		String API_KEY = "APPID=59c9175d591e9fff52d323ea3d78fdc3";
		// 言語指定
		String lang = "&lang=ja";
		// 温度メトリック
		String cerius = "&units=metric";
		// URL
		String requestUrl = urlbuilder.append(city).append(country).append(API_KEY).append(lang).append(cerius)
				.toString();

		URL url = new URL(requestUrl);
		String result = "";
		JsonNode json = null;

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();

		String tmp = "";
		System.out.println(requestUrl);
		if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((tmp = br.readLine()) != null) {
				result += tmp;
			}
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.readTree(result);
			br.close();
		} else {
			System.out.println("取得失敗");
		}
		connection.disconnect();
		return json;
	}

}
