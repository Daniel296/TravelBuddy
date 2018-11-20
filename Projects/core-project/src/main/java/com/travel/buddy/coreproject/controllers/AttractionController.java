package com.travel.buddy.coreproject.controllers;

import com.travel.buddy.coreproject.DTOs.AttractionDTO;
import com.travel.buddy.coreproject.DTOs.UserDTO;
import com.travel.buddy.coreproject.model.TravelPlanItem;
import com.travel.buddy.coreproject.services.attractions.Implementations.AttractionRecomandationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/attraction")
public class AttractionController {

    AttractionRecomandationService service;

    @PostMapping
    public List<AttractionDTO> getAttractions(UserDTO userDTO, String cityName, List<String> interests){
        service = new AttractionRecomandationService();

        List<String> interests1 = new ArrayList<>(Arrays.asList("museum", "church", "restaurants", "pools"));

       return service.getAttractionsByUserPreferences(userDTO, "Paris", interests1);
   }
}
