package com.travel.buddy.coreproject.users_recomandations_helper;

import com.github.javafaker.Faker;
import com.travel.buddy.coreproject.model.TravelPlan;
import com.travel.buddy.coreproject.model.Attraction;
import com.travel.buddy.coreproject.model.Interest;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.attractions.Implementations.AttractionRecomandationByOldTravelPlansHelperImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test_AttractionRecomandationByOldTravelPlans {
    @Test
    public void TestAttractionRecomandation_GivenUserProfileAndAttractions_ExpectedToReturn_1_Attraction(){
        Faker faker = new Faker();

        //set attraction 1 interest
        Interest attractionInterest1 = new Interest();
        attractionInterest1.setCanCamping(true);
        attractionInterest1.setCanSwim(true);

        //set attraction 2 interest
        Interest attractionInterest2 = new Interest();
        attractionInterest2.setCold(true);
        attractionInterest2.setCanCycle(true);

        //set attraction 3 interest
        Interest attractionInterest3 = new Interest();
        attractionInterest3.setCanFishing(true);
        attractionInterest3.setCanSwim(true);

        //set attraction 4 interest
        Interest attractionInterest4 = new Interest();
        attractionInterest4.setRaining(true);
        attractionInterest4.setCanDrive(true);

        List<Attraction> attractions = new ArrayList<>();
        List<Attraction> attractions2 = new ArrayList<>();

        //attraction1
        Attraction attraction1 = new Attraction();
        attraction1.setInterest(attractionInterest1);

        //attraction2
        Attraction attraction2 = new Attraction();
        attraction2.setInterest(attractionInterest2);

        //attraction3
        Attraction attraction3 = new Attraction();
        attraction3.setInterest(attractionInterest3);

        //attraction4
        Attraction attraction4 = new Attraction();
        attraction4.setInterest(attractionInterest4);


        // attraction list1
        attractions.add(attraction1);
        attractions.add(attraction2);

        // attraction list2
        attractions2.add(attraction3);
        attractions2.add(attraction4);

        //travelplan1
        TravelPlan userTravelPlan1 = new TravelPlan();
        //userTravelPlan1.setAttractions(attractions);

        //travelplan2
        TravelPlan userTravelPlan2 = new TravelPlan();
        //userTravelPlan2.setAttractions(attractions2);

        //create old travelPlans list
        List<TravelPlan> allUserTravelPlans = new ArrayList<>();
        allUserTravelPlans.add(userTravelPlan1);
        allUserTravelPlans.add(userTravelPlan2);

        //our user
        String fName = faker.name().firstName();
        UserProfile userProfile = new UserProfile(fName, null, null, null, null, null, null, null, null);
        // userProfile.setInterest(userInterest);

        AttractionRecomandationByOldTravelPlansHelperImpl helper = new AttractionRecomandationByOldTravelPlansHelperImpl(userProfile);
        helper.setAllUserTravelPlans(allUserTravelPlans);
        List<Attraction> recomandedAttractions = helper.getAttractions();

        Assert.assertEquals(4, recomandedAttractions.size());
    }
}