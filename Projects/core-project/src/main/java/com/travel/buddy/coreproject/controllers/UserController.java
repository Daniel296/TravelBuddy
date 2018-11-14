package com.travel.buddy.coreproject.controllers;

import com.travel.buddy.coreproject.model.Country;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.repository.UserProfileRepository;
import com.travel.buddy.coreproject.services.countries.interfaces.BLICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserProfileRepository repository;

    @GetMapping(value = "/findAll")
    public List<UserProfile> getAllCountries(){
        return repository.findAll();
    }
}