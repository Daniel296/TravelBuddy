package com.travel.buddy.coreproject.utils.score;

import com.travel.buddy.coreproject.model.Interest;
import com.travel.buddy.coreproject.services.attractions.Interfaces.InterestsScoreComputer;
import com.travel.buddy.coreproject.utils.GetUserInterestsListHelper;

import java.util.Set;

public class ScoreComputerByUserInterestsImpl implements InterestsScoreComputer {
    @Override
    public double getScore(Interest interests1, Interest interests2) {
        Set<String> interest1AsList = GetUserInterestsListHelper.getInterests(interests1);
        Set<String> interest2AsList = GetUserInterestsListHelper.getInterests(interests2);
        interest1AsList.retainAll(interest2AsList);
        return interest1AsList.size();
    }
}