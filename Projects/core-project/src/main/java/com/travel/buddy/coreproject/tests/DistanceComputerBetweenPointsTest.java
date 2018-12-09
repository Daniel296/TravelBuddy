package com.travel.buddy.coreproject.tests;

import com.travel.buddy.coreproject.services.matches.Implementations.DistanceComputerBetweenPoints;
import com.travel.buddy.coreproject.services.matches.Implementations.Point;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class DistanceComputerBetweenPointsTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void WhenGiven2Points_ResultShouldBeRight() {
        // Iasi and Bucuresti = 326 km (error = 1 km)
        Point IasiPoint = new Point(47.17, 27.57);
        Point BucharestPoint = new Point(44.42, 26.12);
        Assert.assertEquals(326, DistanceComputerBetweenPoints.getDistance("KM", IasiPoint, BucharestPoint), 1);
    }

    @org.junit.Test
    public void WhenGiven3Points_ResultShouldBeRight() {
        // Iasi - Bucuresti - Iasi = 656 km (error = 1 km)
        Point IasiPoint = new Point(47.17, 27.57);
        Point BucharestPoint = new Point(44.42, 26.12);
        Assert.assertEquals(652, DistanceComputerBetweenPoints.getDistance("KM", IasiPoint, BucharestPoint, IasiPoint), 1);
    }

    @org.junit.Test
    public void WhenGiven1Point_ResultShouldBe0() {
        // Iasi - Bucuresti - Iasi = 656 km (error = 1 km)
        Point IasiPoint = new Point(47.17, 27.57);
        Assert.assertEquals(0, DistanceComputerBetweenPoints.getDistance("KM", IasiPoint), 1);
    }

    @org.junit.Test
    public void WhenGivenPOICOnfigurationInIasi_ResultShouldBeRight() {
        // distance computer uses straight forward computation between 2 points,
        // without taking account of street/ buildings etc, that's
        Point PiataUniriiPoint = new Point(47.1656503, 27.5803949);
        Point MitropoliaIasiPoint = new Point(47.1610055, 27.5821142);
        Point ZenitySpaPoint = new Point(47.1494063, 27.6175271);
        Point PalatulCulturiiPoint = new Point(47.1573021, 27.5869821);
        Point ViperClubPoint = new Point(47.1552609, 27.6055663);
        int pointsOfInterestNumber = 5;
        Assert.assertEquals(10, DistanceComputerBetweenPoints.getDistance(
                "KM",
                PiataUniriiPoint,
                MitropoliaIasiPoint,
                ZenitySpaPoint,
                PalatulCulturiiPoint,
                ViperClubPoint)
                , pointsOfInterestNumber);
    }
}