package com.travel.buddy.coreproject.DTOs;

import java.util.List;

public class InterestWrapper {

	private List<String> userInterests;

	private String cityName;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<String> getUserInterests() {
		return userInterests;
	}

	public void setUserInterests(List<String> userInterests) {
		this.userInterests = userInterests;
	}

}
