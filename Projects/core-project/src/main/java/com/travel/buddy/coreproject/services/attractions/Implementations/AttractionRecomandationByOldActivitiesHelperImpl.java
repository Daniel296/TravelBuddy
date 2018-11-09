package com.travel.buddy.coreproject.services.attractions.Implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.travel.buddy.coreproject.model.Activity;
import com.travel.buddy.coreproject.model.Attraction;
import com.travel.buddy.coreproject.model.TravelPlanItem;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.repository.AttractionRepository;
import com.travel.buddy.coreproject.services.attractions.Interfaces.AttractionRecomandationHelper;

public class AttractionRecomandationByOldActivitiesHelperImpl implements AttractionRecomandationHelper {

    @Autowired
    public AttractionRepository attractionRepository;

    private List<Activity> allUserActivities;
    UserProfile userProfile;

    public AttractionRecomandationByOldActivitiesHelperImpl(UserProfile userProfile){
        this.userProfile = userProfile;
    }

    public List<TravelPlanItem> getTravelPlanItems(){

        List<TravelPlanItem> travelPlanItems = new ArrayList<>();
        //List<Activity> userActivities = new ArrayList<>();

        //userActivities.addAll(userProfile.getActivities()); // activitatile userului curent

        for(Activity a : allUserActivities)
            travelPlanItems.addAll(a.getTravelPlanItems());

        return travelPlanItems;
    }

    public List<Activity> getAllUserActivities() {
        return allUserActivities;
    }

    public void setAllUserActivities(List<Activity> allUserActivities) {
        this.allUserActivities = allUserActivities;
    }

	@Override
	public List<Attraction> getAttractions() {
		return null;
	}
}