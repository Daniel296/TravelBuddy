package com.travel.buddy.coreproject.services.travelplans.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.buddy.coreproject.DTOs.TravelPlanWrapper;
import com.travel.buddy.coreproject.model.TravelPlan;
import com.travel.buddy.coreproject.repository.TravelPlanRepository;
import com.travel.buddy.coreproject.services.sessions.interfaces.BLIUserSessionService;
import com.travel.buddy.coreproject.services.travelplans.interfaces.BLITravelPlanService;
import com.travel.buddy.coreproject.services.userlogin.interfaces.BLIUserLoginService;

@Service
public class BLTravelPlanService implements BLITravelPlanService {
	
	@Autowired
	private BLIUserSessionService userSessionService;
	@Autowired
	private TravelPlanRepository travelPlanRepository;
	@Autowired
	private BLIUserLoginService userLoginService;

	@Override
	public void createTravelPlan(String userSessionUUID, TravelPlanWrapper travelPlanWrapper) {
		TravelPlan tp = new TravelPlan();
		long userLoginId = userSessionService.getUserLoginIdBySessionUUID(userSessionUUID);
		tp.setUserProfile(userLoginService.getUserProfileByUserLoginId(userLoginId));
		tp.setEndDate(Long.valueOf(travelPlanWrapper.getEndDate()));
		tp.setStartDate(Long.valueOf(travelPlanWrapper.getStartDate()));
		tp.setTravelPlanItems(travelPlanWrapper.getTravelPlanItems());
		
		travelPlanRepository.save(tp);
	}

	@Override
	public List<TravelPlan> findAllTravelPlans() {
		return travelPlanRepository.findAll();
	}

	@Override
	public TravelPlan findTravelPlanById(long travelPlanId) {
		return travelPlanRepository.findByTravelPlanId(travelPlanId);
	}

}
