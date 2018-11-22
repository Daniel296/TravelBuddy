package com.travel.buddy.coreproject.services.cities.interfaces;

import java.util.List;

import com.travel.buddy.coreproject.model.City;

public interface BLICityService {
	
	public List<City> getAllCities();
	
	public City getCityById(Long id);

	public City save(City city);
}
