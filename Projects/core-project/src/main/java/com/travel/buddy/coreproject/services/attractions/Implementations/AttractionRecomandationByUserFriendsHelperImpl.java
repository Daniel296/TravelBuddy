package com.travel.buddy.coreproject.services.attractions.Implementations;

import java.util.*;

import com.travel.buddy.coreproject.DTOs.AttractionDTO;
import com.travel.buddy.coreproject.DTOs.UserDTO;
import com.travel.buddy.coreproject.model.*;
import com.travel.buddy.coreproject.repository.MatchesRepository;
import com.travel.buddy.coreproject.services.attractions.Interfaces.AttractionRecomandationHelper;

public class AttractionRecomandationByUserFriendsHelperImpl implements AttractionRecomandationHelper {

    private UserDTO userDTO;
    private MatchesRepository matchesRepository;
    private List<Matches> allMatches;

    public AttractionRecomandationByUserFriendsHelperImpl(UserDTO userDTO){
        this.userDTO = userDTO;
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
//        List<UserProfile> matchedUsers = new ArrayList<>();
        List<TravelPlanItem> travelPlanItems = new ArrayList<>();
//        List<TravelPlan> travelPlan = new ArrayList<>();
//        HashMap<TravelPlanItem, Integer> topTravelPlanItems = new HashMap<>();
        allMatches = matchesRepository.findAll(); //get all user matches

        /*for (Matches match : allMatches){
            if(match.getUserProfile1().getId() == userDTO.getId())
                matchedUsers.add(match.getUserProfile2());
            if(match.getUserProfile2().getId() == userDTO.getId())
                matchedUsers.add(match.getUserProfile1());
        }

        for(UserProfile profile : matchedUsers)
            travelPlan.addAll(profile.getTravelPlans()); // get all the travelPlans from the users("friends")

        for(TravelPlan t : travelPlan)
            travelPlanItems.addAll(t.getTravelPlanItems());

        for(TravelPlanItem t : travelPlanItems) {
            topTravelPlanItems.putIfAbsent(t, 1);       //count the "popularity" of the travelPLanItem
            if(topTravelPlanItems.get(t) !=null)
                topTravelPlanItems.replace(t,topTravelPlanItems.get(t)+1);
        }
        travelPlanItems.clear();
        topTravelPlanItems=sortByValue(topTravelPlanItems); //sort by nr of "friends" desc that visited that attraction
        travelPlanItems.addAll(topTravelPlanItems.keySet());*/
        return travelPlanItems;
    }

	@Override
	public List<AttractionDTO> getAttractionDTOS() {
		return null;
	}
}