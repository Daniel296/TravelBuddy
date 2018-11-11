package com.travel.buddy.coreproject.users_matches_helper;

import com.travel.buddy.coreproject.model.Attraction;
import com.travel.buddy.coreproject.services.matches.Implementations.DistanceComputerBetweenAttractions;
import com.travel.buddy.coreproject.services.matches.Implementations.DistanceComputerBetweenPoints;
import com.travel.buddy.coreproject.services.matches.Implementations.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test_CalculatingDistance {

    @Test
    public void Test_DistanceTwoPoints() {
        Point point1 = new Point(48.64703, -122.26324);
        Point point2 = new Point(48.6721, -122.265);

        double distanceBetweenPoints = DistanceComputerBetweenPoints.getDistance("KM", point1, point2);

        Assert.assertEquals(2.791, distanceBetweenPoints, 1e-15);
    }

    @Test
    public void Test_DistanceBetweenAListOfPoints() {
        List<Point> points = new ArrayList<>();

        Point point1 = new Point(48.64703, -122.26324);
        Point point2 = new Point(48.6721, -122.265);
        Point point3 = new Point(48.4234, -122.34);

        points.add(point1);
        points.add(point2);
        points.add(point3);

        double distanceBetweenPoints = DistanceComputerBetweenPoints.getDistance("KM", points);

        Assert.assertEquals(DistanceComputerBetweenPoints.getDistance("KM", point1, point2) + DistanceComputerBetweenPoints.getDistance("KM", point2, point3), DistanceComputerBetweenPoints.getDistance("KM", points), distanceBetweenPoints);
    }

    @Test
    public void Test_DistanceBetweenTwoAttractions() {
        Attraction attraction1 = new Attraction(0, null, 48.64703, -122.26324, null, null);
        Attraction attraction2 = new Attraction(0, null, 48.6721, -122.265, null, null);

        double distanceBetweenAttractions = DistanceComputerBetweenAttractions.getDistance("KM", attraction1, attraction2);

        Assert.assertEquals(2.791, distanceBetweenAttractions, 1e-15);
    }

    @Test
    public void Test_DistanceBetweenAListOfAttractions() {
        List<Attraction> attractions = new ArrayList<>();

        Attraction attraction1 = new Attraction(0, null, 48.64703, -122.26324, null, null);
        Attraction attraction2 = new Attraction(0, null, 48.6721, -122.265, null, null);
        Attraction attraction3 = new Attraction(0, null, 48.4234, -122.34, null, null);

        attractions.add(attraction1);
        attractions.add(attraction2);
        attractions.add(attraction3);

        double distanceBetweenPoints = DistanceComputerBetweenAttractions.getDistance("KM", attractions);

        Assert.assertEquals(DistanceComputerBetweenAttractions.getDistance("KM", attraction1, attraction2) + DistanceComputerBetweenAttractions.getDistance("KM", attraction2, attraction3), DistanceComputerBetweenAttractions.getDistance("KM", attractions), distanceBetweenPoints);

    }
}