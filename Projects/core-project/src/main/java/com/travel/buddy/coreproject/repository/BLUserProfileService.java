package com.travel.buddy.coreproject.repository;

import com.travel.buddy.coreproject.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import com.travel.buddy.coreproject.repository.UserProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BLUserProfileService implements BLIUserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }
}
