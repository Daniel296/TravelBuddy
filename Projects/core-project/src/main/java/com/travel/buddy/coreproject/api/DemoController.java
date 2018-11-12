package com.travel.buddy.coreproject.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travel.buddy.coreproject.model.City;
import com.travel.buddy.coreproject.repository.CityRepository;

@RestController
@RequestMapping("/demo-endpoint")
public class DemoController {
/*
	@Autowired
	public CityRepository cityRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String helloWorld() {
		return "hello world";
	}

	@RequestMapping(value = "/city", method = RequestMethod.GET)
	public List<City> getAllCities() {
		return cityRepository.findAll();
	}

	@RequestMapping(value = "/city/{id}", method = RequestMethod.GET)
	public Optional<City> getCityById(@PathVariable Long id) {
		return cityRepository.findById(id);
	}

	@RequestMapping(value = "/city", consumes = "application/json", method = RequestMethod.POST)
	public City createCity(@RequestBody City city) {
		return cityRepository.save(city);
	}

	public CityRepository gettravelplanRepository() {
		return cityRepository;
	}

	public void settravelplanRepository(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}
*/
}
