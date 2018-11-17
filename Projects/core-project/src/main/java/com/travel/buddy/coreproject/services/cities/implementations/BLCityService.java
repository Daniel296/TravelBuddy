package com.travel.buddy.coreproject.services.cities.implementations;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.buddy.coreproject.model.City;
import com.travel.buddy.coreproject.repository.CityRepository;
import com.travel.buddy.coreproject.services.cities.interfaces.BLICityService;

@Service
public class BLCityService implements BLICityService {

	@Autowired
	private CityRepository cityRepository;

	@Override
	public List<City> getAllCities() {
		return cityRepository.findAll();
	}

	@Override
	public City getCityById(Long id) {
		return cityRepository.findById(id);
	}

	@Override
	public City save(City city) {
		if (StringUtils.isNotBlank(city.getName())) {
			return cityRepository.save(city);
		}
		return null;
	}

}
