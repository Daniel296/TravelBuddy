package com.travel.buddy.coreproject.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.buddy.coreproject.model.City;
import com.travel.buddy.coreproject.model.Interest;
import com.travel.buddy.coreproject.model.TravelPlan;
import com.travel.buddy.coreproject.model.TravelPlanItem;
import com.travel.buddy.coreproject.model.UserLogin;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.repository.InterestRepository;
import com.travel.buddy.coreproject.repository.TravelPlanItemRepository;
import com.travel.buddy.coreproject.repository.TravelPlanRepository;
import com.travel.buddy.coreproject.repository.UserLoginRepository;
import com.travel.buddy.coreproject.repository.UserProfileRepository;
import com.travel.buddy.coreproject.services.cities.interfaces.BLICityService;

@RestController
@RequestMapping(value = "/user")
public class UserProfileController {

    @Autowired
    private UserProfileRepository repository;

    @Autowired
    private BLICityService cityService;

    @Autowired
    private InterestRepository interestRepository;

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Autowired
    private TravelPlanRepository travelPlanRepository;

    @Autowired
	private TravelPlanItemRepository travelPlanItemRepository;

    @GetMapping
    public List<UserProfile> getAllUsers(){

        UserProfile userProfile = new UserProfile("Petrisor", "Romsoft", "112", "Meil","Fimeil",null, null, null, null);

        UserLogin userLogin = new UserLogin();
        userLogin.setEmail("petrishor@rms.ro");
        userLogin.setFacebookToken("fb");
        userLogin.setGoogleToken("google");
        userLogin.setPassword("pass");

        userProfile.setUserLogin(userLogin);

        City city = cityService.getCityById(288L);

        userProfile.setCity(city);

        TravelPlan travelPlan = new TravelPlan();
        travelPlan.setId(7);
        travelPlan.setStartDate(743853);
        travelPlan.setEndDate(374837483);

        TravelPlanItem travelPlanItem1 = new TravelPlanItem();
        travelPlanItem1.setId(10);
        travelPlanItem1.setStartDate(3744);
        travelPlanItem1.setEndDate(347834);
        travelPlanItem1.setAttraction("Atractia li li li la li li lu li li lo");

        TravelPlanItem travelPlanItem2 = new TravelPlanItem();
        travelPlanItem2.setId(11);
        travelPlanItem2.setStartDate(37644);
        travelPlanItem2.setEndDate(3447834);
        travelPlanItem2.setAttraction("Atractia li li li la li li lu li li lu");

        TravelPlanItem travelPlanItem3 = new TravelPlanItem();
        travelPlanItem3.setId(12);
        travelPlanItem3.setStartDate(233744);
        travelPlanItem3.setEndDate(434347834);
        travelPlanItem3.setAttraction("Atractia li li li la li li lu li li lz");

        ArrayList<TravelPlanItem> travelPlanItems = new ArrayList<>();
        travelPlanItems.add(travelPlanItem1);
        travelPlanItems.add(travelPlanItem2);
        travelPlanItems.add(travelPlanItem3);

//        travelPlanItemRepository.save(travelPlanItem1);
//        travelPlanItemRepository.save(travelPlanItem2);
//        travelPlanItemRepository.save(travelPlanItem3);

        travelPlan.setTravelPlanItems(travelPlanItems);

        List<TravelPlan> travelPlans = new ArrayList<>();
        travelPlans.add(travelPlan);

        //travelPlanRepository.save(travelPlan);
        userProfile.setTravelPlans(travelPlans);

        Interest interest = new Interest();
        interest.setAirport(true);
        interest.setBank(true);
        interest.setBicycle_store(true);
        interest.setMosque(true);
        interest.setNight_club(true);


        //interestRepository.save(interest);
        userProfile.setInterest(interest);


        //userLoginRepository.save(userLogin);
        //repository.save(userProfile);

        return repository.findAll();
    }
}