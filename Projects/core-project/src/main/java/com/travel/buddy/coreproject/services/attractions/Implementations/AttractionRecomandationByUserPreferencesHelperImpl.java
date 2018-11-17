package com.travel.buddy.coreproject.services.attractions.Implementations;

import java.util.ArrayList;
import java.util.List;

import com.travel.buddy.coreproject.DTOs.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

import com.travel.buddy.coreproject.DTOs.Attraction;
import com.travel.buddy.coreproject.model.Interest;
import com.travel.buddy.coreproject.model.TravelPlanItem;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.repository.AttractionRepository;
import com.travel.buddy.coreproject.services.attractions.Interfaces.AttractionRecomandationHelper;
import com.travel.buddy.coreproject.services.attractions.Interfaces.InterestsScoreComputer;

public class AttractionRecomandationByUserPreferencesHelperImpl implements AttractionRecomandationHelper {

    @Autowired
    public AttractionRepository attractionRepository;

    private List<TravelPlanItem> allTravelPlanItems;
    private UserDTO userDTO;

    public AttractionRecomandationByUserPreferencesHelperImpl(UserDTO userDTO){
        this.userDTO = userDTO;
    }

    public List<TravelPlanItem> getTravelPlanItems(){
        List<TravelPlanItem> travelPlanItems = new ArrayList<>();
        InterestsScoreComputer scoreComputer  = new InterestScoreComputerImpl();
        //allAttractions = attractionRepository.findAll();
        Interest userInterests = userDTO.getInterest();

        return travelPlanItems;
    }

    public List<TravelPlanItem> getAllTravelPlanItems() {
        return allTravelPlanItems;
    }

    public void setAllTravelPlanItems(List<TravelPlanItem> allTravelPlanItems) {
        this.allTravelPlanItems = allTravelPlanItems;
    }

	@Override
	public List<Attraction> getAttractions() {
		return null;
	}
}