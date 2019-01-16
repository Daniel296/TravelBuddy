package com.travel.buddy.coreproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.buddy.coreproject.DTOs.UserMatchDTO;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.matches.Interfaces.MatchesRecommandationsServiceInterface;
import com.travel.buddy.coreproject.services.sessions.interfaces.BLIUserSessionService;
import com.travel.buddy.coreproject.services.userprofile.interfaces.BLIUserProfileService;

@RestController
@RequestMapping(value = "/matches")
public class MatchesController {
	
	@Autowired
	private MatchesRecommandationsServiceInterface matchesService;
	
	@Autowired
	private BLIUserSessionService userSessionService;
	
	@Autowired
	private BLIUserProfileService userProfileService;
	
	@PostMapping(value = "/getMatches")
	public List<UserMatchDTO> getUsersMatches(@RequestParam("sessionUUID") String sessionUUID){
		if (userSessionService.checkIfUserSessionUUIDExists(sessionUUID)) {
			UserProfile userProfile = userProfileService.getBySessionUuid(sessionUUID);
			return matchesService.getUsersRecomandations(userProfile);
		} else
			return null;
	}
}