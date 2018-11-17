package com.travel.buddy.coreproject.services.attractions.Implementations;

import com.travel.buddy.coreproject.DTOs.Attraction;
import com.travel.buddy.coreproject.DTOs.UserDTO;
import com.travel.buddy.coreproject.model.UserProfile;

import java.util.List;

public class AttractionRecomandationService{
    public List<Attraction> getAttractions(UserDTO userDTO){
        AttractionRecomandationUnifier unifier = new AttractionRecomandationUnifier(userDTO);
        return unifier.getAttractions();
    }
}