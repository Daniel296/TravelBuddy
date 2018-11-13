package com.travel.buddy.coreproject.services.attractions.Implementations;

import com.travel.buddy.coreproject.model.Interest;
import com.travel.buddy.coreproject.services.attractions.Interfaces.InterestsScoreComputer;

public class InterestScoreComputerImpl implements InterestsScoreComputer {
    @Override
    public double getScore(Interest attractionInterest, Interest userProfileInterest) {

        return 4;
        /*((attractionInterest.isCanCamping() && userProfileInterest.isCanCamping()) ? 1 : 0) +
                ((attractionInterest.isCanDrive() && userProfileInterest.isCanDrive()) ? 1 : 0) +
                ((attractionInterest.isHot() && userProfileInterest.isHot()) ? 1 : 0) +
                ((attractionInterest.isCanSwim() && userProfileInterest.isCanSwim()) ? 1 : 0) +
                ((attractionInterest.isCanCycle() && userProfileInterest.isCanCycle()) ? 1 : 0);*/
    }
}