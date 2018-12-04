package com.travel.buddy.coreproject.utils;

import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.utils.SlopeOne.SlopeOne;

import java.util.HashMap;
import java.util.Map;

public class ModifyInterestDatabaseService {
    public static void Update() {
        SlopeOne.prepareUpdate();
        Map<UserProfile, HashMap<String, Double>> userInterests = SlopeOne.outputData;

    }
}