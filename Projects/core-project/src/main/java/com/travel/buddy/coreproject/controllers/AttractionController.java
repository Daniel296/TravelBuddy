package com.travel.buddy.coreproject.controllers;

import com.travel.buddy.coreproject.DTOs.UserDTO;
import com.travel.buddy.coreproject.model.TravelPlanItem;
import com.travel.buddy.coreproject.services.attractions.Implementations.AttractionRecomandationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/attraction")
public class AttractionController {
    AttractionRecomandationService service;
    List<TravelPlanItem> getAttractions(UserDTO userDTO){
        service = new AttractionRecomandationService();
       return service.getAttractions(userDTO);
   }
}
