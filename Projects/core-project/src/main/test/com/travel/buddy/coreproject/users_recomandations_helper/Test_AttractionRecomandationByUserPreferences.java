package com.travel.buddy.coreproject.users_recomandations_helper;


import com.github.javafaker.Faker;
import com.travel.buddy.coreproject.model.Attraction;
import com.travel.buddy.coreproject.model.Interest;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.attractions.Implementations.AttractionRecomandationByUserPreferencesHelperImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test_AttractionRecomandationByUserPreferences {
    @Test
    public void TestAttractionRecomandation_GivenUserProfileAndAttractions_ExpectedToReturn_1_Attraction(){
        Faker faker = new Faker();

        //set user interest
        Interest userInterest = new Interest();
        userInterest.setCanCamping(true);
        userInterest.setCanCycle(true);
        userInterests.add(userInterest)

        //set attraction 1 interest
        Interest attractionInterest1 = new Interest();
        attractionInterest1.setCanCamping(true);
        attractionInterest1.setCanSwim(true);

        //set attraction 2 interest
        Interest attractionInterest2 = new Interest();
        attractionInterest2.setCold(true);
        attractionInterest2.setCanCycle(true);


        List<Attraction> attractions = new ArrayList<>();

        //attraction1
        Attraction attraction1 = new Attraction();
        attraction1.setInterest(attractionInterest1);


        //attraction2
        Attraction attraction2 = new Attraction();
        attraction2.setInterest(attractionInterest2);


        // attraction list
        attractions.add(attraction1);
        attractions.add(attraction2);


        //our user
        String fName = faker.name().firstName();
        UserProfile userProfile = new UserProfile(fName, null, null, null, null, null, null, null, null);
        userProfile.setInterest(userInterest);

        AttractionRecomandationByUserPreferencesHelperImpl helper = new AttractionRecomandationByUserPreferencesHelperImpl(userProfile);
        helper.setAllAttractions(attractions);
        List<Attraction> recomandedAttractions = helper.getAttractions();

        Assert.assertEquals(recomandedAttractions.size(), 2);
    }
}