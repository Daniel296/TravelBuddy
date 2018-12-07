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
                        new Point(o1.getLastLat(), o1.getLastLng()),
                        new Point(o2.getLastLat(), o2.getLastLng()));
            }

        });
        return users.subList(0, Constants.MAX_NEARBY_USERS);
    }
}
