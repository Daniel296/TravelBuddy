package com.travel.buddy.coreproject.services.attractions.Implementations;

import java.util.ArrayList;
import java.util.List;

import com.travel.buddy.coreproject.DTOs.AttractionDTO;
import com.travel.buddy.coreproject.DTOs.UserDTO;
import com.travel.buddy.coreproject.model.TravelPlan;
import org.springframework.beans.factory.annotation.Autowired;

import com.travel.buddy.coreproject.model.TravelPlanItem;
import com.travel.buddy.coreproject.repository.AttractionRepository;
import com.travel.buddy.coreproject.services.attractions.Interfaces.AttractionRecomandationHelper;

public class AttractionRecomandationByOldTravelPlansHelperImpl implements AttractionRecomandationHelper {

    @Autowired
    public AttractionRepository attractionRepository;

    private List<TravelPlan> allUserTravelPlans;
    UserDTO userDTO;

    public AttractionRecomandationByOldTravelPlansHelperImpl(UserDTO userDTO){
        this.userDTO = userDTO;
    }

    public List<TravelPlanItem> getTravelPlanItems(){

        List<TravelPlanItem> travelPlanItems = new ArrayList<>();
        //List<TravelPlan> userTravelPlans = new ArrayList<>();

        //userTravelPlans.addAll(userDTO.getTravelPlans()); // activitatile userului curent

        for(TravelPlan a : allUserTravelPlans)
            travelPlanItems.addAll(a.getTravelPlanItems());

        return travelPlanItems;
    }

    public List<TravelPlan> getAllUserTravelPlans() {
        return allUserTravelPlans;
    }

    public void setAllUserTravelPlans(List<TravelPlan> allUserTravelPlans) {
        this.allUserTravelPlans = allUserTravelPlans;
    }

	@Override
	public List<AttractionDTO> getAttractionDTOS() {
		return null;
	}
}