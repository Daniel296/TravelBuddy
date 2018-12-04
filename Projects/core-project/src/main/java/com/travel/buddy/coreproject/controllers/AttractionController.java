package com.travel.buddy.coreproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.buddy.coreproject.DTOs.AttractionDTO;
import com.travel.buddy.coreproject.DTOs.InterestWrapper;
import com.travel.buddy.coreproject.services.attractions.Implementations.AttractionRecomandationService;

@RestController
@RequestMapping(value = "/attraction")
public class AttractionController {
	
	@Autowired
	private AttractionRecomandationService attractionRecommandationService;
	
	@CrossOrigin
	@PostMapping(value = "/getAll", consumes = "application/json", produces = "application/json")
	public List<AttractionDTO> getAllAttractions(@RequestBody InterestWrapper interestWrapper) {
		return attractionRecommandationService.getAttractionsByUserPreferences(interestWrapper.getCityName(),
				interestWrapper.getUserInterests());
	}
}
