package com.travel.buddy.coreproject.services.userprofile.interfaces;


import java.util.List;
import com.travel.buddy.coreproject.model.UserProfile;

public interface BLIUserProfileService {
    List<UserProfile> getAllUserProfiles();

	UserProfile getBySessionUuid(String sessionUUID);
}