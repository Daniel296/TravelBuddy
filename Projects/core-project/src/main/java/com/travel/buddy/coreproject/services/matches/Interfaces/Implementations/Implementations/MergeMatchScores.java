package com.travel.buddy.coreproject.services.matches.Interfaces.Implementations.Implementations;

import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.matches.Interfaces.Implementations.Interfaces.MatchScoreComputer;

import java.util.ArrayList;
import java.util.List;

public class MergeMatchScores {
    private static MergeMatchScores instance = null;
    private List<MatchScoreComputer> scoreComputers;
    private MergeMatchScores(){
        scoreComputers = new ArrayList<>();
        scoreComputers.add(new MatchesFutureTripsComputerImpl());
        scoreComputers.add(new MatchesInterestScoreComputerImpl());
        scoreComputers.add(new MatchesNearbyUsersComputerImpl());
    }

    public static MergeMatchScores getInstance()
    {
        if (instance == null)
            instance = new MergeMatchScores();
        return instance;
    }

    public double getScore(UserProfile user1, UserProfile user2) {

        /// basic => should be replaced; it's more coupling

        for(MatchScoreComputer matchScore : scoreComputers){
            return 0.2 * scoreComputers.get(0).getScore(user1, user2) +
                    0.5 * scoreComputers.get(1).getScore(user1, user2) +
                    0.3 * scoreComputers.get(2).getScore(user1, user2);
        }
        return 0;
    }
}