package com.travel.buddy.coreproject.services.attractions.Implementations;

import java.util.ArrayList;
import java.util.List;

import com.travel.buddy.coreproject.model.TravelPlan;
import org.springframework.beans.factory.annotation.Autowired;

import com.travel.buddy.coreproject.model.Attraction;
import com.travel.buddy.coreproject.model.TravelPlanItem;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.repository.AttractionRepository;
import com.travel.buddy.coreproject.services.attractions.Interfaces.AttractionRecomandationHelper;

public class AttractionRecomandationByOldActivitiesHelperImpl implements AttractionRecomandationHelper {

    @Autowired
    public AttractionRepository attractionRepository;

    private List<TravelPlan> allUserActivities;
    UserProfile userProfile;

    public AttractionRecomandationByOldActivitiesHelperImpl(UserProfile userProfile){
        this.userProfile = userProfile;
    }

    public List<TravelPlanItem> getTravelPlanItems(){

        List<TravelPlanItem> travelPlanItems = new ArrayList<>();
        //List<TravelPlan> userActivities = new ArrayList<>();

        //userActivities.addAll(userProfile.getActivities()); // activitatile userului curent

        for(TravelPlan a : allUserActivities)
            travelPlanItems.addAll(a.getTravelPlanItems());

        return travelPlanItems;
    }

    public List<TravelPlan> getAllUserActivities() {
        return allUserActivities;
    }

    public void setAllUserActivities(List<TravelPlan> allUserActivities) {
        this.allUserActivities = allUserActivities;
    }

	@Override
	public List<Attraction> getAttractions() {
		return null;
	}
}