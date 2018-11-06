package com.travel.buddy.coreproject.services.matches.Implementations;

import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MatchesRecomandationsService {

    @Autowired
    UserProfileRepository userProfileRepository;

    public MatchesRecomandationsService(UserProfile userProfile){
        List<UserProfile> userProfiles = userProfileRepository.findAll();
        MergeMatchScores mergeScore =  MergeMatchScores.getInstance();
        for(UserProfile user : userProfiles){
            mergeScore.getScore(userProfile, user);
        }
    }
}
