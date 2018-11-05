package com.travel.buddy.coreproject.services.attractions.Implementations;

import com.travel.buddy.coreproject.model.Attraction;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.attractions.Interfaces.AttractionRecomandationHelper;

import java.util.ArrayList;
import java.util.List;

public class AttractionRecomandationByOldActivitiesHelperImpl implements AttractionRecomandationHelper {
    private UserProfile userProfile;
    public AttractionRecomandationByOldActivitiesHelperImpl(UserProfile _userProfile){
        userProfile = _userProfile;
    }
    public List<Attraction> getAttractions(){
        return new ArrayList<Attraction>();
    }
}