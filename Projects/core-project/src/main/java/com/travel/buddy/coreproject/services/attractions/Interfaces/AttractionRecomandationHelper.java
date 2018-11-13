package com.travel.buddy.coreproject.services.attractions.Interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travel.buddy.coreproject.DTOs.Attraction;
import com.travel.buddy.coreproject.model.TravelPlanItem;

@Service
public interface AttractionRecomandationHelper {

    List<TravelPlanItem> getTravelPlanItems();
    
    List<Attraction> getAttractions(); 

}
