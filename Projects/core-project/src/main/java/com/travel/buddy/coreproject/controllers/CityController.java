package com.travel.buddy.coreproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.buddy.coreproject.model.City;
import com.travel.buddy.coreproject.services.cities.interfaces.BLICityService;

@RestController
@RequestMapping(value = "/city")
public class CityController {

	@Autowired
	private BLICityService cityService;

	@GetMapping
	public List<City> getAllCities() {
		return cityService.getAllCities();
	}

	@GetMapping(value = "/{id}")
	public City getCityById(@PathVariable("id") Long id) {
		return cityService.getCityById(id);
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public City addCity(@RequestBody City city) {
		return cityService.save(city);
	}
}
