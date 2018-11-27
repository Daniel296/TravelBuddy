package com.travel.buddy.coreproject.controllers;

import com.travel.buddy.coreproject.DTOs.AttractionDTO;
import com.travel.buddy.coreproject.DTOs.UserDTO;
import com.travel.buddy.coreproject.model.TravelPlanItem;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.repository.UserProfileRepository;
import com.travel.buddy.coreproject.services.attractions.Filters.FilterReunion;
import com.travel.buddy.coreproject.services.attractions.Implementations.AttractionRecomandationByUserPreferencesHelperImpl;
import com.travel.buddy.coreproject.services.attractions.Implementations.AttractionRecomandationService;
import com.travel.buddy.coreproject.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
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

    @Autowired
    UserProfileRepository userProfileRepository;

    AttractionRecomandationService service;

    /*@PostMapping(value = "/getAll")
    public List<AttractionDTO> getAttractions(UserDTO userDTO, String cityName, List<String> interests){
        service = new AttractionRecomandationService();

        List<String> interests1 = new ArrayList<>(Arrays.asList("museum", "church", "restaurants", "pools"));

       return service.getAttractionsByUserPreferences(userDTO, "Paris", interests1);
   }*/

    @GetMapping(value = "/getAll")
    public List<AttractionDTO> getAttractions(){
        service = new AttractionRecomandationService();

        // MOCK

        List<String> interests1 = new ArrayList<>(Arrays.asList("museum", "church", "restaurants", "pools"));
        UserDTO userDTO = new UserDTO();
        String cityName = "Paris";
        List<AttractionDTO> attractions =  service.getAttractionsByUserPreferences(userDTO, cityName, interests1);

        //UserProfile userProfile = userProfileRepository.findById(userDTO.getId());
//        UserProfile userProfile = new UserProfile(); // userprofile must be get by id
//        FilterReunion filterReunion = new FilterReunion();
//        attractions = filterReunion.getAttractions(userProfile, attractions);
//
//        if (attractions.size() < Constants.RECOMENDED_ATTRACTIONS_MAX ){
//
//            List<String> defaultInterest = Arrays.asList("point+of+interest");
//            AttractionRecomandationByUserPreferencesHelperImpl defaultHelper =
//                    new AttractionRecomandationByUserPreferencesHelperImpl(userDTO);
//            List<AttractionDTO> defaultAttrs = defaultHelper.getAttractionByUserPreferences(cityName, defaultInterest);
//
//            //reunion
//            attractions.addAll(defaultAttrs);
//        }

        return attractions;
    }
}
