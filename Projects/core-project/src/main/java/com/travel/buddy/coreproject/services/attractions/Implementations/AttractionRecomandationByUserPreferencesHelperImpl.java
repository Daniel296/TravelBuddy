package com.travel.buddy.coreproject.services.attractions.Implementations;

import com.travel.buddy.coreproject.model.Attraction;
import com.travel.buddy.coreproject.model.Interest;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.repository.AttractionRepository;
import com.travel.buddy.coreproject.repository.CityRepository;
import com.travel.buddy.coreproject.services.attractions.Interfaces.AttractionRecomandationHelper;
import com.travel.buddy.coreproject.services.attractions.Interfaces.InterestsScoreComputer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AttractionRecomandationByUserPreferencesHelperImpl implements AttractionRecomandationHelper {
    @Autowired
    public AttractionRepository attractionRepository;
    private List<Attraction> allAttractions;
    UserProfile userProfile;
    public AttractionRecomandationByUserPreferencesHelperImpl(UserProfile _userProfile){
        userProfile = _userProfile;
    }

    public List<Attraction> getAttractions(){
        List<Attraction> attractions = new ArrayList<>();
        InterestsScoreComputer scoreComputer  = new InterestScoreComputerImpl();
        //allAttractions = attractionRepository.findAll();
        Interest userInterests = userProfile.getInterests().get(0);
        for(Attraction a : allAttractions){
            Interest attractionInterests =  a.getInterests().get(0);
            double score = scoreComputer.getScore(attractionInterests, userInterests);
            if(score>0){ // this shouldn't be hardcoded
                attractions.add(a);
            }
        }
        return attractions;
    }

    public List<Attraction> getAllAttractions() {
        return allAttractions;
    }

    public void setAllAttractions(List<Attraction> allAttractions) {
        this.allAttractions = allAttractions;
    }
}