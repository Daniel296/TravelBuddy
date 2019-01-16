package com.travel.buddy.coreproject.services.matches.Implementations;

import java.util.ArrayList;
import java.util.List;

import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.matches.Interfaces.MatchScoreComputer;

public class MergeMatchScores {

    private static MergeMatchScores instance = null;
    private List<MatchScoreComputer> scoreComputers;

    private MergeMatchScores() {
        scoreComputers = new ArrayList<>();
        scoreComputers.add(new MatchesFutureTripsComputerImpl());
        scoreComputers.add(new MatchesInterestScoreComputerImpl());
        scoreComputers.add(new MatchesPastTripsComputerImpl());
    }

    public static MergeMatchScores getInstance() {
        if (instance == null)
            instance = new MergeMatchScores();
        return instance;
    }

    public double getScore(UserProfile user1, UserProfile user2) {

        /// basic => should be replaced; it's more coupling
        return scoreComputers.get(1).getScore(user1, user2);
        //for (MatchScoreComputer matchScore : scoreComputers) {
          //  return matchScore.getPercent() * matchScore.getScore(user1, user2);
        //}
    }
}