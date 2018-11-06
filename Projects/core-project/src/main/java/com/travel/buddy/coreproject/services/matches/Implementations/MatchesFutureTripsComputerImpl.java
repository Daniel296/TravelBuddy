package com.travel.buddy.coreproject.services.matches.Implementations;

import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.matches.Interfaces.MatchScoreComputer;

public class MatchesFutureTripsComputerImpl implements MatchScoreComputer {

    @Override
    public double getScore(UserProfile user1, UserProfile user2){
        // user1.getActivities().get(i).getAttractions()  <= something like this
        // get users that will have trips on the same place at the same time (provide an error, eg 2km for distance and 2h for time)
        // as inefficient as possible
        // will be very very very nice to test a function like this and obtain a score different from 0
        return 0;
    }
}
