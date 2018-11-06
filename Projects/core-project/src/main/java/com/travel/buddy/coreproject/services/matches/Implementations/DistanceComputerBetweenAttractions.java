package com.travel.buddy.coreproject.services.matches.Implementations;

import com.travel.buddy.coreproject.model.Attraction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistanceComputerBetweenAttractions {

    public static double getDistance(String unit, Attraction... attractions){
        return getDistance(unit, Arrays.asList(attractions));
    }

    public static double getDistance(String unit, List<Attraction> attractions){
        List<Point> points = new ArrayList<>();

        for(Attraction attraction : attractions) {
            points.add(new Point(attraction.getCoordinateLatitude(), attraction.getCoordinateLongitude()));
        }

        return DistanceComputerBetweenPoints.getDistance(unit, points);
    }
}
