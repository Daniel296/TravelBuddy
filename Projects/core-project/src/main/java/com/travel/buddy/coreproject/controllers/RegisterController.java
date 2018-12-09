package com.travel.buddy.coreproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.buddy.coreproject.DTOs.UserRegisterDTO;
import com.travel.buddy.coreproject.model.UserLogin;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.repository.UserLoginRepository;
import com.travel.buddy.coreproject.repository.UserProfileRepository;

@RestController
@RequestMapping(value = "/register")
public class RegisterController {

	private @Autowired UserLoginRepository userLoginRepo;

	private @Autowired UserProfileRepository userProfileRepo;

	@CrossOrigin
	@PostMapping
	public String register(@RequestBody UserRegisterDTO userRegisterDTO) {

		if (userLoginRepo.existsByEmail(userRegisterDTO.getEmail())
				|| userProfileRepo.existsByPhonenumber((userRegisterDTO.getPhoneNumber()))) {
			return "NOT OK";
		}

		UserProfile userProfile = new UserProfile();
		userProfile.setPhoneNumber(userRegisterDTO.getPhoneNumber());
		userProfile.setFirstName(userRegisterDTO.getFirstName());
		userProfile.setLastName(userRegisterDTO.getLastName());
		userProfile.setGender(userRegisterDTO.getGender());
		userProfile.setGenderInterest(userRegisterDTO.getGenderInterest());

		UserLogin userLogin = new UserLogin();
		userLogin.setEmail(userRegisterDTO.getEmail());
		userLogin.setPassword(userRegisterDTO.getPassword());
		userLogin.setUserProfile(userProfile);

		try {
			userLoginRepo.saveAndFlush(userLogin);
		} catch (Exception e) {
			return "NOT OK";
		}

		return "OK";

	}
}
