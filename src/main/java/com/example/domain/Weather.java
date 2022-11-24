package com.example.domain;

public class Weather {
	/** 都市名 */
	private String cityName;
	/** 天気 */
	private String description;
	/** 気温 */
	private Double temp;
	/** 最高最低気温 */
	private Double tempMin;
	/** 最高気温 */
	private Double tempMax;
	/** 湿度 */
	private Double humidity;

	public Weather() {

	}

	public Weather(String cityName, String description, Double temp, Double tempMin, Double tempMax, Double humidity) {
		this.cityName = cityName;
		this.description = description;
		this.temp = temp;
		this.tempMin = tempMin;
		this.tempMax = tempMax;
		this.humidity = humidity;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getTemp() {
		return temp;
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}

	public Double getTempMin() {
		return tempMin;
	}

	public void setTempMin(Double tempMin) {
		this.tempMin = tempMin;
	}

	public Double getTempMax() {
		return tempMax;
	}

	public void setTempMax(Double tempMax) {
		this.tempMax = tempMax;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	@Override
	public String toString() {
		return "Weather [cityName=" + cityName + ", description=" + description + ", temp=" + temp + ", tempMin="
				+ tempMin + ", tempMax=" + tempMax + ", humidity=" + humidity + "]";
	}

}
