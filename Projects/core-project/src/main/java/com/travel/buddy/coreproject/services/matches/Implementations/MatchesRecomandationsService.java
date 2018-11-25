package com.travel.buddy.coreproject.services.matches.Implementations;

import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Tuple;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// rulat la o anumita perioada de timp si de updatat un tabel cu recomandari

public class MatchesRecomandationsService {

    @Autowired
    UserProfileRepository userProfileRepository;
    private Map userScoresMap =new HashMap();
    public MatchesRecomandationsService(UserProfile userProfile) {
        List<UserProfile> userProfiles = userProfileRepository.findAll();
        MergeMatchScores mergeScore =  MergeMatchScores.getInstance();
        Map scoreMap = new HashMap();
        for(UserProfile user : userProfiles){
            if(user.getId() != userProfile.getId())
            {
                double score = mergeScore.getScore(userProfile, user);
                scoreMap.put(user.getId(), score);
            }
        }
        userScoresMap.put(userProfile.getId(), scoreMap);
    }
}
