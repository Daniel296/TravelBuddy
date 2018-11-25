package com.travel.buddy.coreproject.utils.score;

import com.travel.buddy.coreproject.model.TravelPlanItem;
import java.util.List;

import static com.travel.buddy.coreproject.utils.Constants.TRAVELPLANITEM_CLOSE_DISTANCE;
import static com.travel.buddy.coreproject.utils.Constants.TRAVELPLANITEM_MAX_DISTANCE;

public class ScoreComputerByUserPlanItemImpl {

    public double getScore(List<TravelPlanItem> user1AllTravelPlanItems, List<TravelPlanItem> user2AllTravelPlanItems){

        double score = 0.0;

        for(TravelPlanItem user1TravelPlanItem : user1AllTravelPlanItems) {
            for(TravelPlanItem user2TravelPlanItem : user2AllTravelPlanItems) {

                boolean datesComparison =
                        user1TravelPlanItem.getEndDate() > user2TravelPlanItem.getStartDate() &&
                                user2TravelPlanItem.getEndDate() > user1TravelPlanItem.getStartDate()
                        ;   // check if items are at the same time

                //double distance = DistanceComputerBetweenAttractions.getDistance("KM", user1TravelPlanItem.getAttraction(), user2TravelPlanItem.getAttraction());

                double distance = 0.0;

                if(datesComparison) {
                    if(distance < TRAVELPLANITEM_MAX_DISTANCE) {
                        /* The app will recommend users in ascending order by score. So, if a user is closer to the current user it will have a higher score */
                        score += TRAVELPLANITEM_MAX_DISTANCE - distance;

                        // If users are in the same place at the same time, double the score
                        if(distance <= TRAVELPLANITEM_CLOSE_DISTANCE) {
                            score *= 2;
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
}
