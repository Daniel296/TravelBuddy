package com.travel.buddy.coreproject.services.matches.Implementations;

import com.travel.buddy.coreproject.model.TravelPlan;
import com.travel.buddy.coreproject.model.TravelPlanItem;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.matches.Interfaces.MatchScoreComputer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MatchesFutureTripsComputerImpl implements MatchScoreComputer {

    @Override
    public double getScore(UserProfile user1, UserProfile user2){
        // user1.getTravelPlans().get(i).getAttractions()  <= something like this
        // get users that will have trips on the same place at the same time (provide an error, eg 2km for distance and 2h for time)
        // as inefficient as possible
        // will be very very very nice to test a function like this and obtain a score different from 0

        double score = 0.0;
        List<TravelPlanItem> user1AllTravelPlanItems = getAllFutureTravelPlanItems(user1.getTravelPlans());
        List<TravelPlanItem> user2AllTravelPlanItems = getAllFutureTravelPlanItems(user2.getTravelPlans());

        for(TravelPlanItem user1TravelPlanItem : user1AllTravelPlanItems) {
            for(TravelPlanItem user2TravelPlanItem : user2AllTravelPlanItems) {

                boolean datesComparison = user1TravelPlanItem.getEndDate() > user2TravelPlanItem.getStartDate();   // check if items are at the same time
                //double distance = DistanceComputerBetweenAttractions.getDistance("KM", user1TravelPlanItem.getAttraction(), user2TravelPlanItem.getAttraction());
                double distance = 0.0;

                if(datesComparison) {
                    if(distance < 2.0) {
                        /* The app will recommend users in ascending order by score. So, if a user is closer to the current user it will have a higher score */
                        score += 2.0 - distance;

                        // If users are in the same place at the same time, add one more point to score
                        if(distance == 0.0) {
                            score += 1.0;
                        }
                    }
                }
                else {
                    break;
                }
            }
        }

        return score;
    }

    private List<TravelPlanItem> getAllFutureTravelPlanItems(List<TravelPlan> travelPlans) {
        List<TravelPlanItem> allTravelPlanItems = new ArrayList<>();
        //String currentTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
        long currentTime = new Date().getTime();

        for(TravelPlan travelPlan : travelPlans) {
            for(TravelPlanItem travelPlanItem : travelPlan.getTravelPlanItems()) {
                if(travelPlanItem.getStartDate() >= currentTime || travelPlanItem.getEndDate() >= currentTime) {
                    allTravelPlanItems.add(travelPlanItem);
                }
            }
        }

        // Sort all travel plan items by start date in ascending order
        allTravelPlanItems.sort((o1, o2) -> {
            if(o1.getStartDate() < o2.getStartDate()) {
                return -1;
            }
            else if(o1.getStartDate() > o2.getStartDate()) {
                return 1;
            }

            return 0;
        });

        return allTravelPlanItems;
    }
}
