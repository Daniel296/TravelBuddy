package com.travel.buddy.coreproject.services.matches.Implementations;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class DistanceComputerBetweenPoints {

    public static double getDistance(String unit, Point... points){
        return getDistance(unit, Arrays.asList(points));
    }

    public static double getDistance(String unit, List<Point> points){
        double distance = 0.0;

        for(int i = 1; i < points.size(); i++) {
            distance += calculateDistance(points.get(i-1).getLatitude(), points.get(i-1).getLongitude(), points.get(i).getLatitude(), points.get(i).getLongitude(), unit);
        }

        return (new BigDecimal(distance)).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }

    private static double calculateDistance(double lat1, double lng1, double lat2, double lng2, String unit) {
        /* calculates the distance between two points (given the latitude/longitude of those points) */
        double theta = lng1 - lng2;
        double distance = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        distance = Math.acos(distance);
        distance = rad2deg(distance);
        distance = distance * 60 * 1.1515;

        if(unit.equals("KM")) {
            return distance * 1.609344;
        }

        return (new BigDecimal(distance)).setScale(2, RoundingMode.HALF_UP).doubleValue();    // in Miles or Kilometers
    }

    private static double deg2rad(double deg) {
        /* converts decimal degrees to radians */
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        /* converts radians to decimal degrees */
        return (rad * 180 / Math.PI);
    }
}
