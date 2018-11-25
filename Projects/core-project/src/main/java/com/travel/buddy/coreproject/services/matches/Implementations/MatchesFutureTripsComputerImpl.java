package com.travel.buddy.coreproject.services.matches.Implementations;

import com.travel.buddy.coreproject.model.TravelPlan;
import com.travel.buddy.coreproject.model.TravelPlanItem;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.matches.Interfaces.MatchScoreComputer;
import com.travel.buddy.coreproject.utils.Constants;
import com.travel.buddy.coreproject.utils.score.ScoreComputerByUserPlanItemImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MatchesFutureTripsComputerImpl implements MatchScoreComputer {

    @Override
    public double getScore(UserProfile user1, UserProfile user2){

        List<TravelPlanItem> user1AllTravelPlanItems = getAllTravelPlanItems(user1.getTravelPlans(), Time.FUTURE);
        List<TravelPlanItem> user2AllTravelPlanItems = getAllTravelPlanItems(user2.getTravelPlans(), Time.FUTURE);

        double score = new ScoreComputerByUserPlanItemImpl().getScore(user1AllTravelPlanItems,user2AllTravelPlanItems);

        return score;
    }

    @Override
    public double getPercent() {
        return Constants.MATCHES_FUTURE_TRIPS_PERCENT;
    }

    public static List<TravelPlanItem> getAllTravelPlanItems(List<TravelPlan> travelPlans, Time time) {
        List<TravelPlanItem> allTravelPlanItems = new ArrayList<>();
        //String currentTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
        long currentTime = new Date().getTime();

        for(TravelPlan travelPlan : travelPlans) {
            for(TravelPlanItem travelPlanItem : travelPlan.getTravelPlanItems()) {
                switch (time){
                    case NOW:
                        if(travelPlanItem.getStartDate() <= currentTime && travelPlanItem.getEndDate() >= currentTime) {
                            allTravelPlanItems.add(travelPlanItem);
                        }
                        break;
                    case FUTURE:
                        if(travelPlanItem.getStartDate() > currentTime) {
                            allTravelPlanItems.add(travelPlanItem);
                        }

                    case PAST:
                        if(travelPlanItem.getEndDate() < currentTime) {
                            allTravelPlanItems.add(travelPlanItem);
                        }
                        break;
                    default:
                        break;
                }

            }
        }

        return allTravelPlanItems;
    }
}
