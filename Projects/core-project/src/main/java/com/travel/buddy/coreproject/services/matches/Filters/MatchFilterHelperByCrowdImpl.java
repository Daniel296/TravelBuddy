package com.travel.buddy.coreproject.services.matches.Filters;

import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.matches.Implementations.DistanceComputerBetweenPoints;
import com.travel.buddy.coreproject.services.matches.Implementations.Point;
import com.travel.buddy.coreproject.services.matches.Interfaces.MatchFilterHelper;
import com.travel.buddy.coreproject.utils.Constants;

import java.util.Comparator;
import java.util.List;

public class MatchFilterHelperByCrowdImpl implements MatchFilterHelper {
    @Override
    public List<UserProfile> getUsers(List<UserProfile> users) {
        users.sort(new Comparator<UserProfile>() {
            @Override
            public int compare(UserProfile o1, UserProfile o2) {
                return (int) DistanceComputerBetweenPoints.getDistance(
                        "KM",
                        new Point(o1.getLastLAT(), o1.getLastLNG()),
                        new Point(o2.getLastLAT(), o2.getLastLNG()));
            }

        });
        return users.subList(0, Constants.MAX_NEARBY_USERS);
    }
}
