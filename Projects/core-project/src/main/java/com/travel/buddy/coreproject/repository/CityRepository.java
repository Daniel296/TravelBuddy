package com.travel.buddy.coreproject.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.buddy.coreproject.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Serializable> {

	public City findById(Long id);
	
	List<City> findAll();
}
