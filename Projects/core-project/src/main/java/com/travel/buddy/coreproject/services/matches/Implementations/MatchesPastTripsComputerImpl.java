package com.travel.buddy.coreproject.services.matches.Implementations;

import com.travel.buddy.coreproject.model.TravelPlanItem;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.matches.Interfaces.MatchScoreComputer;
import com.travel.buddy.coreproject.utils.Constants;
import com.travel.buddy.coreproject.utils.score.ScoreComputerByUserPlanItemPastImpl;

import java.util.List;

import static com.travel.buddy.coreproject.services.matches.Implementations.MatchesFutureTripsComputerImpl.getAllTravelPlanItems;

public class MatchesPastTripsComputerImpl implements MatchScoreComputer {

    @Override
    public double getScore(UserProfile user1, UserProfile user2){

        List<TravelPlanItem> user1AllTravelPlanItems = getAllTravelPlanItems(user1.getTravelPlans(), Time.PAST);
        List<TravelPlanItem> user2AllTravelPlanItems = getAllTravelPlanItems(user2.getTravelPlans(), Time.PAST);

        double score = new ScoreComputerByUserPlanItemPastImpl().getScore(user1AllTravelPlanItems,user2AllTravelPlanItems);

        return score;
    }

    @Override
    public double getPercent() {
        return Constants.MATCHES_PAST_TRIPS_PERCENT;
    }
}
