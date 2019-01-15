package com.travel.buddy.coreproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.buddy.coreproject.services.sessions.interfaces.BLIUserSessionService;

@RestController
@RequestMapping(value = "/session")
public class SessionController {
	@Autowired
	private BLIUserSessionService userSessionService;
	
	@PostMapping(value = "/checkIfSessionExists")
	public String checkIfSessionExists(@RequestParam("sessionUUID")  String sessionUUID) {
		if( sessionUUID != null && userSessionService.checkIfUserSessionUUIDExists(sessionUUID) ) {
			return "OK";
		}
		return "NOT OK";
	}
}
