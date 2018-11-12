package com.travel.buddy.coreproject.services.countries.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.buddy.coreproject.model.Country;
import com.travel.buddy.coreproject.repository.CountryRepository;
import com.travel.buddy.coreproject.services.countries.interfaces.BLICountryService;


@Service
public class BLCountryService implements BLICountryService{

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@Override
	public Country getCountryById(Long id) {
		return countryRepository.findById(id);
	}
}
