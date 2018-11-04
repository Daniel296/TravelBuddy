package com.travel.buddy.coreproject.services.attractions.Implementations;

import com.travel.buddy.coreproject.model.Attraction;
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

        recomandationHelperList = new ArrayList<>();
        recomandationHelperList.add(new AttractionRecomandationByOldActivitiesHelperImpl(userProfile));
        recomandationHelperList.add(new AttractionRecomandationByUserFriendsHelperImpl(userProfile));
        recomandationHelperList.add(new AttractionRecomandationByUserPreferencesHelperImpl(userProfile));
    }

    private void unify(){
        //merge attractions
    }

    public List<Attraction> getAttractions(){
        unify();
        return attractions;
    }
}