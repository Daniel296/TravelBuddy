package com.travel.buddy.coreproject.services.travelplans.interfaces;

import java.util.List;

import com.travel.buddy.coreproject.DTOs.TravelPlanWrapper;
import com.travel.buddy.coreproject.model.TravelPlan;

public interface BLITravelPlanService {
	public void createTravelPlan(String userSessionUUID, TravelPlanWrapper travelPlanWrapper);

	public List<TravelPlan> findAllTravelPlans();

	public TravelPlan findTravelPlanById(long travelPlanId);

}
