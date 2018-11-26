package com.travel.buddy.coreproject.services.attractions.Interfaces;

import com.travel.buddy.coreproject.DTOs.AttractionDTO;
import com.travel.buddy.coreproject.model.UserProfile;

import java.util.List;

public interface FilterHelper {

    List<AttractionDTO> getAttractions(UserProfile user, List<AttractionDTO> attractionDTOS);
}
