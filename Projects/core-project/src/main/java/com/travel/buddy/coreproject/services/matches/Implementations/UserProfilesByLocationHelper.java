package com.travel.buddy.coreproject.services.matches.Implementations;

import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.repository.UserProfileRepository;
import com.travel.buddy.coreproject.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserProfilesByLocationHelper {
    @Autowired
    private static UserProfileRepository repository;

    public static List<UserProfile> GetUsers(Point point) {
        List<UserProfile> nearbyUsers = new ArrayList<>();
        List<UserProfile> users = repository.findAll();
        for(UserProfile user: users){
            Point userLocation = new Point(user.getLastLAT(), user.getLastLNG());
            if(DistanceComputerBetweenPoints.getDistance("KM", userLocation, point) < Constants.TRAVELPLANITEM_CLOSE_DISTANCE){
                nearbyUsers.add(user);
            }
        }
        return users;
    }
}