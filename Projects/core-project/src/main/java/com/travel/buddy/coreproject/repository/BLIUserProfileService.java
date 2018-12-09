package com.travel.buddy.coreproject.repository;


import java.util.List;
import com.travel.buddy.coreproject.model.UserProfile;

public interface BLIUserProfileService {
    List<UserProfile> getAllUserProfiles();
}