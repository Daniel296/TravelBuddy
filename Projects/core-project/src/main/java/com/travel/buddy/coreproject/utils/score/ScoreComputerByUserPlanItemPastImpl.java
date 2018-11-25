package com.travel.buddy.coreproject.utils.score;

import com.travel.buddy.coreproject.model.TravelPlanItem;

import java.util.List;

public class ScoreComputerByUserPlanItemPastImpl {

    public double getScore(List<TravelPlanItem> user1AllTravelPlanItems, List<TravelPlanItem> user2AllTravelPlanItems){

        double score = 0.0;

        for(TravelPlanItem user1TravelPlanItem : user1AllTravelPlanItems) {
            for(TravelPlanItem user2TravelPlanItem : user2AllTravelPlanItems) {

                if (user1TravelPlanItem.getAttraction().equals(user2TravelPlanItem.getAttraction())){
                    score += 0.5;
                }
            }
        }

        return score;
    }
}
