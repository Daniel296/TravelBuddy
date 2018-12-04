package com.travel.buddy.coreproject.services.attractions.Implementations;

import com.travel.buddy.coreproject.DTOs.AttractionDTO;
import com.travel.buddy.coreproject.DTOs.UserDTO;
import com.travel.buddy.coreproject.services.attractions.Interfaces.AttractionRecomandationHelper;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AttractionRecomandationService{

    public List<AttractionDTO> getAttractionsByUserPreferences(String cityName, List<String> interests){
        //AttractionRecomandationUnifier unifier = new AttractionRecomandationUnifier(userDTO);
        AttractionRecomandationByUserPreferencesHelperImpl recommendationHelper = new AttractionRecomandationByUserPreferencesHelperImpl();

        List<AttractionDTO> attractions = recommendationHelper.getAttractionByUserPreferences(cityName, interests);


        return attractions;
    }
}