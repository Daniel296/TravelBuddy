package com.travel.buddy.coreproject.users_recomandations_helper;


import com.travel.buddy.coreproject.DTOs.AttractionDTO;
import com.travel.buddy.coreproject.services.attractions.Implementations.AttractionRecomandationByUserPreferencesHelperImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test_AttractionDTORecommendationByUserPreferences {
    @Test
    public void TestAttractionRecommendation_GivenUserInterests_ExpectedToReturn_40_Attractions (){
        AttractionRecomandationByUserPreferencesHelperImpl attractionRecommendationByUserPreferencesHelper = new AttractionRecomandationByUserPreferencesHelperImpl();

        List<String> userInterests = new ArrayList<>();
        userInterests.add("restaurants");
        userInterests.add("museums");

        List<AttractionDTO> attractions = attractionRecommendationByUserPreferencesHelper.getAttractionByUserPreferences("Paris", userInterests);

        Assert.assertEquals(attractions.size(), 40);
    }

    @Test
    public void TestAttractionRecommendation_GivenNoUserInterests_ExpectedToReturn_20_Attractions (){
        AttractionRecomandationByUserPreferencesHelperImpl attractionRecommendationByUserPreferencesHelper = new AttractionRecomandationByUserPreferencesHelperImpl();
        List<AttractionDTO> attractions = attractionRecommendationByUserPreferencesHelper.getAttractionByUserPreferences("Paris", new ArrayList<>());

        Assert.assertEquals(attractions.size(), 20);
    }
}