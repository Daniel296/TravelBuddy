package com.travel.buddy.coreproject.services.matches.Interfaces.Implementations.Interfaces;

import com.travel.buddy.coreproject.model.UserProfile;

public interface MatchScoreComputer {
    double getScore(UserProfile user1, UserProfile user2);
}
