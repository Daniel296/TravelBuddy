package com.travel.buddy.coreproject.services.matches.Implementations;

import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.matches.Interfaces.MatchScoreComputer;

import java.util.List;

public class MatchesNearbyUsersComputer {
    public List<UserProfile> getNearbyUsers(UserProfile user){
        Point location = new Point(user.getLastLat(), user.getLastLng());
        List<UserProfile> users = UserProfilesByLocationHelper.GetUsers(location);
        return users;
    }
}
