package com.travel.buddy.coreproject.services.attractions.Implementations;

import com.travel.buddy.coreproject.model.Attraction;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.repository.AttractionRepository;
import com.travel.buddy.coreproject.repository.CityRepository;
import com.travel.buddy.coreproject.services.attractions.Interfaces.AttractionRecomandationHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AttractionRecomandationByUserPreferencesHelperImpl implements AttractionRecomandationHelper {
    @Autowired
    public AttractionRepository attractionRepository;
    UserProfile userProfile;
    public AttractionRecomandationByUserPreferencesHelperImpl(UserProfile _userProfile){
        userProfile = _userProfile;
    }

    public List<Attraction> getAttractions(){
        List<Attraction> attractions = new ArrayList<>();
        List<Attraction> allAttractions = attractionRepository.findAll();
        for(Attraction a : allAttractions){
            //if a.interests() has something common with userProfile.interests()
            attractions.add(a);
        }
        return attractions;
    }
}