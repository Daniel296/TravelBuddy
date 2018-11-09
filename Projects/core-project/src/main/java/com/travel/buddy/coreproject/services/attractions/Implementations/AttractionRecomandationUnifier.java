package com.travel.buddy.coreproject.services.attractions.Implementations;

import com.travel.buddy.coreproject.model.Attraction;
import com.travel.buddy.coreproject.model.TravelPlanItem;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.attractions.Interfaces.AttractionRecomandationHelper;

import java.util.ArrayList;
import java.util.List;

public class AttractionRecomandationUnifier implements AttractionRecomandationHelper {
    private UserProfile userProfile;
    private List<Attraction> attractions;
    private List<AttractionRecomandationHelper> recomandationHelperList;
    public AttractionRecomandationUnifier(UserProfile _userProfile){
        userProfile = _userProfile;
        attractions = new ArrayList<>();
        recomandationHelperList = new ArrayList<>();
        recomandationHelperList.add(new AttractionRecomandationByOldActivitiesHelperImpl(userProfile));
        recomandationHelperList.add(new AttractionRecomandationByUserFriendsHelperImpl(userProfile));
        recomandationHelperList.add(new AttractionRecomandationByUserPreferencesHelperImpl(userProfile));
    }

    private void unify(){
        for(AttractionRecomandationHelper helper : recomandationHelperList){
            for(TravelPlanItem travelPlanItem: helper.getTravelPlanItems()) {
            	attractions.add(travelPlanItem.getAttraction());
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