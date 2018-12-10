package com.travel.buddy.coreproject.controllers;

import com.travel.buddy.coreproject.model.Interest;
import com.travel.buddy.coreproject.services.interest.interfaces.BLIInterestService;
import com.travel.buddy.coreproject.services.sessions.interfaces.BLIUserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/interest")
public class InterestController {

    @Autowired
    private BLIUserSessionService userSessionService;
    @Autowired
    private BLIInterestService interestService;


    @CrossOrigin
    @PostMapping(value ="/getAllBySessionUUID")
    public Interest getUserInterestBySessionUUID(@RequestParam("session") String sessionUUID){
        if (userSessionService.checkIfUserSessionUUIDExists(sessionUUID)) {
            return interestService.getUserInterestBySessionUUID(sessionUUID);
        }
        return null;
    }

}
