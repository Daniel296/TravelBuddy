package com.travel.buddy.coreproject.services.userprofile.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.repository.UserProfileRepository;
import com.travel.buddy.coreproject.services.sessions.interfaces.BLIUserSessionService;
import com.travel.buddy.coreproject.services.userlogin.interfaces.BLIUserLoginService;
import com.travel.buddy.coreproject.services.userprofile.interfaces.BLIUserProfileService;

@Service
public class BLUserProfileService implements BLIUserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;
    
    @Autowired 
    private BLIUserSessionService userSessionService;
    
    @Autowired
    private BLIUserLoginService userLoginService;

    @Override
    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

	@Override
	public UserProfile getBySessionUuid(String sessionUUID) {
		long userLoginId = userSessionService.getUserLoginIdBySessionUUID(sessionUUID);
		
		return userLoginService.getUserProfileByUserLoginId(userLoginId);
	}
}
