package com.travel.buddy.coreproject.services.attractions.Implementations;

import java.util.ArrayList;
import java.util.List;

import com.travel.buddy.coreproject.model.*;
import com.travel.buddy.coreproject.model.TravelPlan;
import com.travel.buddy.coreproject.repository.MatchesRepository;
import com.travel.buddy.coreproject.services.attractions.Interfaces.AttractionRecomandationHelper;

public class AttractionRecomandationByUserFriendsHelperImpl implements AttractionRecomandationHelper {

    private UserProfile userProfile;
    private MatchesRepository matchesRepository;
    private List<Matches> allMatches;

    public AttractionRecomandationByUserFriendsHelperImpl(UserProfile userProfile){
        this.userProfile = userProfile;
    }

    public List<TravelPlanItem> getTravelPlanItems(){
        List<UserProfile> matchedUsers = new ArrayList<>();
        List<TravelPlanItem> travelPlanItems = new ArrayList<>();
        List<TravelPlan> activities = new ArrayList<>();

        allMatches = matchesRepository.findAll(); //iau toate match-urile user-ului

        for (Matches match : allMatches){
            if(match.getUserProfile1().getUserProfileId() == userProfile.getUserProfileId())
                matchedUsers.add(match.getUserProfile2()); //retin userii cu care a fost match-uit
            if(match.getUserProfile2().getUserProfileId() == userProfile.getUserProfileId())
                matchedUsers.add(match.getUserProfile1());
        }

        for(UserProfile profile : matchedUsers)
            activities.addAll(profile.getActivities()); // iau toate activitatile de la persoanele match-uite

        for(TravelPlan a : activities)
            travelPlanItems.addAll(a.getTravelPlanItems()); 

        return travelPlanItems;
    }

	@Override
	public List<Attraction> getAttractions() {
		return null;
	}
}