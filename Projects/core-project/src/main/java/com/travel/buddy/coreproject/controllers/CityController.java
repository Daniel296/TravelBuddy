package com.travel.buddy.coreproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.travel.buddy.coreproject.model.City;
import com.travel.buddy.coreproject.services.cities.interfaces.BLICityService;

@RestController
@RequestMapping(value = "/city")
public class CityController {
	
	@Autowired
	private BLICityService cityService;
	
	@GetMapping(value = "/findAll")
	public List<City> getAllCities(){
		return cityService.getAllCities();
	}
	
	@GetMapping(value = "/findById/{id}")
	public City getCityById(@PathVariable("id") Long id) {
		return cityService.getCityById(id);
	}
}
