package com.travel.buddy.coreproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.sessions.interfaces.BLIUserSessionService;
import com.travel.buddy.coreproject.services.userprofile.interfaces.BLIUserProfileService;

@RestController
@RequestMapping(value = "/user-profile")
public class UserProfileController {
	
	@Autowired
	private BLIUserSessionService userSessionService;
	
	@Autowired
	private BLIUserProfileService userProfileService;
	
	
	@CrossOrigin
	@PostMapping(value="/getBySessionUuid")
	public UserProfile getUserProfileBySessionUuid(@RequestParam("sessionUuid") String sessionUUID) {
		if (userSessionService.checkIfUserSessionUUIDExists(sessionUUID)) {
			return userProfileService.getBySessionUuid(sessionUUID);
		} else {
			return null;
		}
	}
}