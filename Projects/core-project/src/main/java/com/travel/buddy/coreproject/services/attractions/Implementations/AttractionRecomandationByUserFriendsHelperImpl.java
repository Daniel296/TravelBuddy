package com.travel.buddy.coreproject.services.attractions.Implementations;

import java.util.*;

import com.travel.buddy.coreproject.model.*;
import com.travel.buddy.coreproject.model.TravelPlan;
import com.travel.buddy.coreproject.repository.MatchesRepository;
import com.travel.buddy.coreproject.services.attractions.Interfaces.AttractionRecomandationHelper;

import javax.validation.constraints.Null;

public class AttractionRecomandationByUserFriendsHelperImpl implements AttractionRecomandationHelper {

    private UserProfile userProfile;
    private MatchesRepository matchesRepository;
    private List<Matches> allMatches;

    public AttractionRecomandationByUserFriendsHelperImpl(UserProfile userProfile){
        this.userProfile = userProfile;
    }

    public static HashMap<TravelPlanItem, Integer> sortByValue(HashMap<TravelPlanItem, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<TravelPlanItem, Integer> > list = new LinkedList<>(hm.entrySet());
        // Sort the list
        Collections.sort(list, Comparator.comparing(o -> (o.getValue()),Comparator.reverseOrder()));
        // put data from sorted list to HashMap
        HashMap<TravelPlanItem, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<TravelPlanItem, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public List<TravelPlanItem> getTravelPlanItems(){
        List<UserProfile> matchedUsers = new ArrayList<>();
        List<TravelPlanItem> travelPlanItems = new ArrayList<>();
        List<TravelPlan> travelPlan = new ArrayList<>();
        HashMap<TravelPlanItem, Integer> topTravelPlanItems = new HashMap<>();
        allMatches = matchesRepository.findAll(); //get all user matches

        for (Matches match : allMatches){
            if(match.getUserProfile1().getId() == userProfile.getId())
                matchedUsers.add(match.getUserProfile2());          //store matched users
            if(match.getUserProfile2().getId() == userProfile.getId())
                matchedUsers.add(match.getUserProfile1());
        }

        for(UserProfile profile : matchedUsers)
            travelPlan.addAll(profile.getActivities()); // get all the activities from the users("friends")

        for(TravelPlan t : travelPlan)
            travelPlanItems.addAll(t.getTravelPlanItems());

        for(TravelPlanItem t : travelPlanItems) {
            topTravelPlanItems.putIfAbsent(t, 1);       //count the "popularity" of the travelPLanItem
            if(topTravelPlanItems.get(t) !=null)
                topTravelPlanItems.replace(t,topTravelPlanItems.get(t)+1);
        }
        travelPlanItems.clear();
        topTravelPlanItems=sortByValue(topTravelPlanItems); //sort by nr of "friends" desc that visited that attraction
        travelPlanItems.addAll(topTravelPlanItems.keySet());
        return travelPlanItems;
    }

	@Override
	public List<Attraction> getAttractions() {
		return null;
	}
}