package com.travel.buddy.coreproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.travel.buddy.coreproject.model.Country;
import com.travel.buddy.coreproject.services.countries.interfaces.BLICountryService;

@RestController
@RequestMapping(value = "/country")
public class CountryController {
	
	@Autowired
	private BLICountryService countryService;
	
	@GetMapping
	public List<Country> getAllCountries(){
		return countryService.getAllCountries();
	}
	
	@GetMapping(value = "/{id}")
	public Country getCountryById(@PathVariable("id") Long id) {
		return countryService.getCountryById(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteCountryById(@PathVariable("id") Long id) {
		countryService.deleteCountry(id);
	}
}