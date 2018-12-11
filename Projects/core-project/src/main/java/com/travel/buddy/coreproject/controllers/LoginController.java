package com.travel.buddy.coreproject.controllers;

import com.travel.buddy.coreproject.DTOs.UserLoginDTO;
import com.travel.buddy.coreproject.model.UserLogin;
import com.travel.buddy.coreproject.repository.UserLoginRepository;
import com.travel.buddy.coreproject.repository.UserProfileRepository;
import com.travel.buddy.coreproject.services.sessions.interfaces.BLIUserSessionService;
import com.travel.buddy.coreproject.services.userlogin.interfaces.BLIUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private BLIUserLoginService userLoginService;

    @Autowired
    private BLIUserSessionService userSessionService;

    @CrossOrigin
    @PostMapping
    public String login(@RequestBody UserLoginDTO userLoginDTO) {
        UserLogin userLogin = null;

        if(userLoginDTO.getAuthorizationMethod().equals("Password")) {
            userLogin = userLoginService.getUserLoginByEmailAndPassword(userLoginDTO.getEmail(), userLoginDTO.getPassword());
        }

        if(userLoginDTO.getAuthorizationMethod().equals("Google")) {
            userLogin = userLoginService.getUserLoginByGoogleToken(userLoginDTO.getGoogleToken());
        }

        if(userLoginDTO.getAuthorizationMethod().equals("Facebook")) {
            userLogin = userLoginService.getUserLoginByFacebookToken(userLoginDTO.getFacebookToken());
        }

        if(userLogin != null) {
            String sessionUUID = userLoginDTO.getSessionUUID();
            boolean existSessionUUID = userSessionService.checkIfUserSessionUUIDExists(sessionUUID);

            if(!existSessionUUID) {
                sessionUUID = userSessionService.createNewUserSessionAndReturnIt(userLogin.getId());
            }

            return sessionUUID;
        }

        return "NOT OK";
    }
}
