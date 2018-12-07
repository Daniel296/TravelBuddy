package com.travel.buddy.coreproject.controllers;

import com.travel.buddy.coreproject.model.TravelPlan;
import com.travel.buddy.coreproject.model.TravelPlanItem;
import com.travel.buddy.coreproject.services.sessions.interfaces.BLIUserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/trip")
public class TripPlanController {

    @Autowired
    private BLIUserSessionService userSessionService;

    @CrossOrigin
    @PostMapping(value = "/create")
    public String createTravelPlan(@RequestParam("session") String sessionUUID,@RequestParam("startDate") String startDate,
                                       @RequestParam("endDate") String endDate,@RequestParam("tpiList") List<TravelPlanItem> travelPlanItems){
        if (userSessionService.checkIfUserSessionUUIDExists(sessionUUID)){
            TravelPlan tp = new TravelPlan();
            //will continue soon
            return "OK";
        }
        else
            return "NOT OK";
    }
}
