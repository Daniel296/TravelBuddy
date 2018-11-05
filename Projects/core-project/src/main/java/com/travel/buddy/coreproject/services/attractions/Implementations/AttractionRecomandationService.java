package com.travel.buddy.coreproject.services.attractions.Implementations;

import com.travel.buddy.coreproject.model.Attraction;
import com.travel.buddy.coreproject.model.UserProfile;

import java.util.List;

public class AttractionRecomandationService{
    public List<Attraction> getAttractions(UserProfile userProfile){
        AttractionRecomandationUnifier unifier = new AttractionRecomandationUnifier(userProfile);
        return unifier.getAttractions();
    }
}