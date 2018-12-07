package com.travel.buddy.coreproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.buddy.coreproject.DTOs.AttractionDTO;
import com.travel.buddy.coreproject.DTOs.InterestWrapper;
import com.travel.buddy.coreproject.services.attractions.Implementations.AttractionRecomandationService;
import com.travel.buddy.coreproject.services.sessions.interfaces.BLIUserSessionService;

@RestController
@RequestMapping(value = "/attraction")
public class AttractionController {

	@Autowired
	private AttractionRecomandationService attractionRecommandationService;

	@Autowired
	private BLIUserSessionService userSessionService;

	@CrossOrigin
	@PostMapping(value = "/getAll")
	// consumes = "application/json; charset=UTF-8", produces = "application/json"
	public List<AttractionDTO> getAllAttractions(@RequestParam("session") String sessionUUID,
			@RequestBody InterestWrapper interestWrapper) {
		if (userSessionService.checkIfUserSessionUUIDExists(sessionUUID)) {
			return attractionRecommandationService.getAttractionsByUserPreferences(interestWrapper.getCityName(),
					interestWrapper.getUserInterests());
		} else {
			return null;
		}
	}
}
