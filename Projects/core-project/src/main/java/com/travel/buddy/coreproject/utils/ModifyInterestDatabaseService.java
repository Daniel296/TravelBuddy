package com.travel.buddy.coreproject.utils;

import com.travel.buddy.coreproject.model.Interest;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.repository.InterestRepository;
import com.travel.buddy.coreproject.utils.SlopeOne.SlopeOne;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ModifyInterestDatabaseService {
    @Autowired
    private static InterestRepository interestRepository;

    public static void Update() {
        SlopeOne.prepareUpdate();
        Map<UserProfile, HashMap<String, Double>> userInterests = SlopeOne.outputData;

        for(UserProfile user : userInterests.keySet()){
            Interest interest = user.getInterest();
            Set<String> interestsAsStringSet = userInterests.get(user).keySet();
            Interest updatedInterest = GetUserInterestFromStringListHelper.getInterest(interestsAsStringSet);
            updatedInterest.setId(interest.getId());
            interestRepository.save(updatedInterest);
        }
    }
}