package com.travel.buddy.coreproject.services.matches.Interfaces.Implementations.Implementations;

import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.matches.Interfaces.Implementations.Interfaces.MatchScoreComputer;

public class MatchesNearbyUsersComputerImpl implements MatchScoreComputer {
    @Override
    public double getScore(UserProfile user1, UserProfile user2){
        // you cannot add implementation now because there is no info about user location (not yet!)
        return 0;
    }
}
