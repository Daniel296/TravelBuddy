package com.travel.buddy.coreproject.services.matches.Implementations;

import com.travel.buddy.coreproject.model.Interest;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.utils.Constants;
import com.travel.buddy.coreproject.utils.score.ScoreComputerByUserInterestsImpl;
import com.travel.buddy.coreproject.services.matches.Interfaces.MatchScoreComputer;

public class MatchesInterestScoreComputerImpl implements MatchScoreComputer {
    @Override
    public double getScore(UserProfile user1, UserProfile user2) {
        Interest user1_interest = user1.getInterest();
        Interest user2_interest = user2.getInterest();
        // you have to choose: call InterestsScoreComputer from services.attractions or create your own class
        ScoreComputerByUserInterestsImpl scoreComputer = new ScoreComputerByUserInterestsImpl();
        return scoreComputer.getScore(user1_interest, user2_interest);
    }

    @Override
    public double getPercent() {
        return Constants.MATCHES_INTERESTS_PERCENT;
    }
}
