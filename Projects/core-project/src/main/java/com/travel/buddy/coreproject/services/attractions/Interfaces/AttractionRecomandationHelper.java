package com.travel.buddy.coreproject.services.attractions.Interfaces;

import java.util.List;

import com.travel.buddy.coreproject.DTOs.AttractionDTO;
import org.springframework.stereotype.Service;

import com.travel.buddy.coreproject.model.TravelPlanItem;

@Service
public interface AttractionRecomandationHelper {

    List<TravelPlanItem> getTravelPlanItems();
    
    List<AttractionDTO> getAttractionDTOS();

}
