package com.travel.buddy.coreproject.services.matches.Implementations;

import com.travel.buddy.coreproject.DTOs.AttractionDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistanceComputerBetweenAttractions {

    public static double getDistance(String unit, AttractionDTO... attractionDTOS){
        return getDistance(unit, Arrays.asList(attractionDTOS));
    }

    public static double getDistance(String unit, List<AttractionDTO> attractionDTOS){
        List<Point> points = new ArrayList<>();

        for(AttractionDTO attractionDTO : attractionDTOS) {
            points.add(new Point(attractionDTO.getCoordinateLatitude(), attractionDTO.getCoordinateLongitude()));
        }

        return DistanceComputerBetweenPoints.getDistance(unit, points);
    }
}
