package com.travel.buddy.coreproject.users_recomandations_helper;

import com.github.javafaker.Faker;
import com.travel.buddy.coreproject.model.Attraction;
import com.travel.buddy.coreproject.model.Interest;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.attractions.Implementations.AttractionRecomandationByOldActivitiesHelperImpl;
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

        Assert.assertEquals(distanceBetweenPoints, 2.791, 1e-15);
    }

    @Test
    public void Test_DistanceBetweenAListOfPoints() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(48.64703, -122.26324));
        points.add(new Point(48.6721, -122.265));
        points.add(new Point(48.4234, -122.34));

        Point point1 = new Point(48.64703, -122.26324);
        Point point2 = new Point(48.6721, -122.265);
        Point point3 = new Point(48.4234, -122.34);

        double distanceBetweenPoints = DistanceComputerBetweenPoints.getDistance("KM", points);

        Assert.assertEquals(DistanceComputerBetweenPoints.getDistance("KM", points), DistanceComputerBetweenPoints.getDistance("KM", point1, point2) + DistanceComputerBetweenPoints.getDistance("KM", point2, point3), distanceBetweenPoints);
    }

    @Test
    public void Test_DistanceBetweenTwoAttractions() {

    }

    @Test
    public void Test_DistanceBetweenAListOfAttractions() {

    }
}