package com.travel.buddy.coreproject.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.travel.buddy.coreproject.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Serializable> {
	
	@Query(value = "SELECT c FROM Country c")
	public List<Country> findAll();
	
	public Country findByCountryId(Long countryId);
}
