package com.travel.buddy.coreproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.buddy.coreproject.model.City;
import com.travel.buddy.coreproject.services.cities.interfaces.BLICityService;

@RestController
@RequestMapping(value = "/city")
public class CityController {
	
	@Autowired
	private BLICityService cityService;
	
	@PostMapping(value = "/findAll")
	public List<City> getAllCities(){
		return cityService.getAllCities();
	}
	
	@PostMapping(value = "/findById")
	public City getCityById(@RequestParam("id") Long id) {
		return cityService.getCityById(id);
	}
}
