package com.travel.buddy.coreproject.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.travel.buddy.coreproject.DTOs.AttractionDTO;
import com.travel.buddy.coreproject.DTOs.InterestWrapper;
import com.travel.buddy.coreproject.DTOs.UserDTO;
import com.travel.buddy.coreproject.services.attractions.Implementations.AttractionRecomandationService;

@Controller
@RequestMapping(value = "/attraction")
public class AttractionController {

	private AttractionRecomandationService attractionRecommandationService = new AttractionRecomandationService();

	/*
	 * @PostMapping(value = "/getAll") public List<AttractionDTO>
	 * getAttractions(UserDTO userDTO, String cityName, List<String> interests){
	 * service = new AttractionRecomandationService();
	 * 
	 * List<String> interests1 = new ArrayList<>(Arrays.asList("museum", "church",
	 * "restaurants", "pools"));
	 * 
	 * return service.getAttractionsByUserPreferences(userDTO, "Paris", interests1);
	 * }
	 */

	@GetMapping(value = "/getAll")
	public List<AttractionDTO> getAttractions() {
		attractionRecommandationService = new AttractionRecomandationService();

		// MOCK

		List<String> interests1 = new ArrayList<>(Arrays.asList("museum", "church", "restaurants", "pools"));
		UserDTO userDTO = new UserDTO();
		String cityName = "Paris";
		// List<AttractionDTO> attractions =
		// attractionRecommandationService.getAttractionsByUserPreferences(userDTO,
		// cityName, interests1);

		// UserProfile userProfile = userProfileRepository.findById(userDTO.getId());
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

		return new ArrayList<AttractionDTO>();
	}

	@GetMapping(value="/test", consumes = "application/json", produces = "application/json")
	public List<AttractionDTO> getAllAttractions(@RequestBody InterestWrapper interestWrapper) {
		return attractionRecommandationService.getAttractionsByUserPreferences(interestWrapper.getCityName(),
				interestWrapper.getInterests());
	}

	public AttractionRecomandationService getService() {
		return attractionRecommandationService;
	}

	public void setService(AttractionRecomandationService service) {
		this.attractionRecommandationService = service;
	}

}
