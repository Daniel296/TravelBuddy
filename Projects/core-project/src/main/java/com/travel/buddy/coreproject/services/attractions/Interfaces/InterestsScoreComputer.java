package com.travel.buddy.coreproject.services.attractions.Interfaces;

import com.travel.buddy.coreproject.model.Interest;

public interface InterestsScoreComputer {
    double getScore(Interest attractionInterest, Interest userProfileInterest);
}
