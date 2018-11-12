package com.travel.buddy.coreproject.services.countries.interfaces;

import java.util.List;

import com.travel.buddy.coreproject.model.Country;

public interface BLICountryService {
	
	public List<Country> getAllCountries();
	
	public Country getCountryById(Long id);
	
	public void deleteCountry(Long id);
}
