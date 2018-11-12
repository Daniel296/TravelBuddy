package com.travel.buddy.coreproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.buddy.coreproject.model.Country;
import com.travel.buddy.coreproject.services.countries.interfaces.BLICountryService;

@RestController
@RequestMapping(value = "/country")
public class CountryController {
	
	@Autowired
	private BLICountryService countryService;
	
	@PostMapping(value = "/findAll")
	public List<Country> getAllCountries(){
		return countryService.getAllCountries();
	}
	
	@PostMapping(value = "/findById")
	public Country getCountryById(@RequestParam("id") Long id) {
		return countryService.getCountryById(id);
	}
}
