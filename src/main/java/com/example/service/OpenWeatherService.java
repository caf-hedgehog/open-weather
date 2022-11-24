package com.example.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import com.example.domain.Location;
import com.example.repository.OpenWeatherRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.ibm.icu.text.Transliterator;

@Service
@Transactional
public class OpenWeatherService {

	@Autowired
	private OpenWeatherRepository openWeatherRepository;

	public JsonNode weatherForecast(Location location) throws IOException {
		// 漢字からカタカナに変換
		Tokenizer tokenizer = new Tokenizer();
		List<Token> tokens = tokenizer.tokenize(location.getCity());

		// カタカナからローマ字に変換
		Transliterator trans = Transliterator.getInstance("Katakana-Latin");
		location.setCity(trans.transliterate(tokens.get(0).getReading()));

		return openWeatherRepository.weatherForecast(location);
	}

}
