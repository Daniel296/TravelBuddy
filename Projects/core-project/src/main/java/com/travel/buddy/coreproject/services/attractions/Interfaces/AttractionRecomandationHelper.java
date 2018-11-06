package com.travel.buddy.coreproject.services.attractions.Interfaces;

import com.travel.buddy.coreproject.model.Attraction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttractionRecomandationHelper {

    List<Attraction> getAttractions();

}
