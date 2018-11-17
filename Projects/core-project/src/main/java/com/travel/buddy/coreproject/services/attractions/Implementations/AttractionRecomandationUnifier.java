package com.travel.buddy.coreproject.services.attractions.Implementations;

import com.travel.buddy.coreproject.DTOs.Attraction;
import com.travel.buddy.coreproject.DTOs.UserDTO;
import com.travel.buddy.coreproject.model.TravelPlanItem;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.attractions.Interfaces.AttractionRecomandationHelper;

import java.util.ArrayList;
import java.util.List;

public class AttractionRecomandationUnifier implements AttractionRecomandationHelper {
    private UserDTO userDTO;
    private List<Attraction> attractions;
    private List<AttractionRecomandationHelper> recomandationHelperList;
    public AttractionRecomandationUnifier(UserDTO _userDTO){
        userDTO = _userDTO;
        attractions = new ArrayList<>();
        recomandationHelperList = new ArrayList<>();
        recomandationHelperList.add(new AttractionRecomandationByOldTravelPlansHelperImpl(userDTO));
        recomandationHelperList.add(new AttractionRecomandationByUserFriendsHelperImpl(userDTO));
        recomandationHelperList.add(new AttractionRecomandationByUserPreferencesHelperImpl(userDTO));
    }

    private void unify(){
        for(AttractionRecomandationHelper helper : recomandationHelperList){
            for(TravelPlanItem travelPlanItem: helper.getTravelPlanItems()) {
            	//attractions.add(travelPlanItem.getAttraction());
            	attractions.add(null);
            }
        }
        //merge attractions
    }
    
    @Override
    public List<Attraction> getAttractions(){
        unify();
        return attractions;
    }

	@Override
	public List<TravelPlanItem> getTravelPlanItems() {
		return null;
	}
}