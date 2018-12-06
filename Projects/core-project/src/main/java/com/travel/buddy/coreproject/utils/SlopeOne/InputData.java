package com.travel.buddy.coreproject.utils.SlopeOne;

import com.travel.buddy.coreproject.model.Interest;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.repository.UserProfileRepository;
import com.travel.buddy.coreproject.utils.GetUserInterestsListHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class InputData {

    protected static List<String> items = GetUserInterestsListHelper.interestssAsStringList;
    @Autowired
    private static UserProfileRepository userProfileRepository;

    public static Map<UserProfile, HashMap<String, Double>> initializeData() {
        Map<UserProfile, HashMap<String, Double>> data = new HashMap<>();
        HashMap<String, Double> userInterests;

        List<UserProfile> users = userProfileRepository.findAll();

        for (UserProfile user : users) {
            userInterests = new HashMap<String, Double>();
            Set<String> interests = GetUserInterestsListHelper.getInterests(user.getInterest());
            for (String item : interests) {
                userInterests.put(item, 1.0);
            }
            data.put(user, userInterests);
        }
        return data;
    }
}