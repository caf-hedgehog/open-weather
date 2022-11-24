package com.example.controller;

import java.io.IOException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Location;
import com.example.domain.Weather;
import com.example.form.LocationForm;
import com.example.service.OpenWeatherService;
import com.fasterxml.jackson.databind.JsonNode;

@Controller
@RequestMapping("/")
public class WeatherForecastController {

	@Autowired
	private OpenWeatherService openWeatherService;

	@RequestMapping("")
	public String topPage(Model model) {
		return "top-page";
	}

	@RequestMapping("/result-forecast")
	public String weatherForecast(LocationForm form, Model model) {
		Location location = new Location();
		BeanUtils.copyProperties(form, location);
		try {
			JsonNode json = openWeatherService.weatherForecast(location);
			Weather weather = new Weather(form.getCity(), json.get("weather").get(0).get("description").toString(),
					json.get("main").get("temp").doubleValue(), json.get("main").get("temp_min").doubleValue(),
					json.get("main").get("temp_max").doubleValue(), json.get("main").get("humidity").doubleValue());
			model.addAttribute("weather", weather);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return topPage(model);
	}

}
