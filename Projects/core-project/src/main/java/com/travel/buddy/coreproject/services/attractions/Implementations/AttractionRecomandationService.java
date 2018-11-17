package com.travel.buddy.coreproject.services.attractions.Implementations;

import com.travel.buddy.coreproject.DTOs.AttractionDTO;
import com.travel.buddy.coreproject.DTOs.UserDTO;

import java.util.List;

public class AttractionRecomandationService{

    public List<AttractionDTO> getAttractions(UserDTO userDTO, String cityName, List<String> interests){
        AttractionRecomandationUnifier unifier = new AttractionRecomandationUnifier(userDTO);


        return unifier.getAttractionDTOS();
    }
}