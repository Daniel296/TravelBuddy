package com.travel.buddy.coreproject.services.matches.Interfaces;

import java.util.List;

import com.travel.buddy.coreproject.DTOs.UserMatchDTO;
import com.travel.buddy.coreproject.model.UserProfile;

public interface MatchesRecommandationsServiceInterface {
	public List<UserMatchDTO> getUsersRecomandations(UserProfile userProfile);
}
