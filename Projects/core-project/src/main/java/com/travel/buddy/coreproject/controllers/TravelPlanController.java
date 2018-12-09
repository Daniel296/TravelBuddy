package com.travel.buddy.coreproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.buddy.coreproject.DTOs.TravelPlanWrapper;
import com.travel.buddy.coreproject.model.TravelPlan;
import com.travel.buddy.coreproject.services.sessions.interfaces.BLIUserSessionService;
import com.travel.buddy.coreproject.services.travelplans.interfaces.BLITravelPlanService;

@RestController
@RequestMapping(value = "/trip")
public class TravelPlanController {

	@Autowired
	private BLIUserSessionService userSessionService;
	@Autowired
	private BLITravelPlanService travelPlanService;

	@CrossOrigin
	@PostMapping(value = "/create")
	public String createTravelPlan(@RequestParam("session") String sessionUUID,
			@RequestBody TravelPlanWrapper travelPlanWrapper) {
		if (userSessionService.checkIfUserSessionUUIDExists(sessionUUID)) {
			travelPlanService.createTravelPlan(sessionUUID, travelPlanWrapper);
			return "OK";
		} else
			return "NOT OK";
	}

	@CrossOrigin
	@PostMapping(value = "/getAll")
	public List<TravelPlan> getAllTravelPlans(@RequestParam("session") String sessionUUID) {
		if (userSessionService.checkIfUserSessionUUIDExists(sessionUUID)) {
			return travelPlanService.findAllTravelPlans();
		}
		return null;
	}

	@CrossOrigin
	@PostMapping(value ="/getAllById")
	public TravelPlan getTravelPlanById(@RequestParam("session") String sessionUUID, @RequestParam("travelPlanId") long travelPlanId) {
		if (userSessionService.checkIfUserSessionUUIDExists(sessionUUID)) {
			return travelPlanService.findTravelPlanById(travelPlanId);
		}
		return null;
	}
}
