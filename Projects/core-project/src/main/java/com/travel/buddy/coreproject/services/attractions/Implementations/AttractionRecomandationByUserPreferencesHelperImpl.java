package com.travel.buddy.coreproject.services.attractions.Implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.travel.buddy.coreproject.model.Attraction;
import com.travel.buddy.coreproject.model.Interest;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.repository.AttractionRepository;
import com.travel.buddy.coreproject.services.attractions.Interfaces.AttractionRecomandationHelper;
import com.travel.buddy.coreproject.services.attractions.Interfaces.InterestsScoreComputer;

public class AttractionRecomandationByUserPreferencesHelperImpl implements AttractionRecomandationHelper {

    @Autowired
    public AttractionRepository attractionRepository;

    private List<Attraction> allAttractions;
    private UserProfile userProfile;

    public AttractionRecomandationByUserPreferencesHelperImpl(UserProfile userProfile){
        this.userProfile = userProfile;
    }

    public List<Attraction> getAttractions(){
        List<Attraction> attractions = new ArrayList<>();
        InterestsScoreComputer scoreComputer  = new InterestScoreComputerImpl();
        //allAttractions = attractionRepository.findAll();
        Interest userInterests = userProfile.getInterest();
        for(Attraction a : allAttractions){
            Interest attractionInterests =  a.getInterest();
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