package com.travel.buddy.coreproject.services.matches.Implementations;

import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.repository.UserProfileRepository;
import com.travel.buddy.coreproject.services.userprofile.interfaces.BLIUserProfileService;
import com.travel.buddy.coreproject.tests.UserProfilesByLocationHelperTest;
import com.travel.buddy.coreproject.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserProfilesByLocationHelper {
    @Autowired
    private BLIUserProfileService userProfileService;

    public UserProfilesByLocationHelper(){

    }

    public List<UserProfile> GetUsers(Point point) {
        List<UserProfile> nearbyUsers = new ArrayList<>();
        List<UserProfile> users = userProfileService.getAllUserProfiles();
        for(UserProfile user: users){
            Point userLocation = new Point(user.getLastLat(), user.getLastLng());
            if(DistanceComputerBetweenPoints.getDistance("KM", userLocation, point) < Constants.TRAVELPLANITEM_CLOSE_DISTANCE){
                nearbyUsers.add(user);
            }
        }
        return users;
    }
}