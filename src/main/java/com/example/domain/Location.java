package com.example.domain;

public class Location {
	/** 都市名 */
	private String city;
	/** 都道府県ID */
	private String prefID;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPrefID() {
		return prefID;
	}

	public void setPrefID(String prefID) {
		this.prefID = prefID;
	}

	@Override
	public String toString() {
		return "Location [city=" + city + ", prefID=" + prefID + "]";
	}

}
