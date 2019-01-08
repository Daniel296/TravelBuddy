package com.travel.buddy.coreproject;

import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.matches.Implementations.Point;
import com.travel.buddy.coreproject.services.matches.Implementations.UserProfilesByLocationHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserProfilesByLocationHelperTest {

    @Test
    public void WhenGiven3AttractionNearCentralPoint_ResultShouldBe3() {
        Point p = new Point(47.1617486, 27.5841862);  // Primaria Iasi
        UserProfilesByLocationHelper userProfilesByLocationHelper = new UserProfilesByLocationHelper();
        List<UserProfile> users = new ArrayList<>();

        UserProfile user1 = new UserProfile();  // Piata Unirii
        user1.setLastLat(47.1656503);
        user1.setLastLng(27.5803949);

        UserProfile user2 = new UserProfile();  // Mitropolia Iasi
        user2.setLastLat(47.1610055);
        user2.setLastLng(27.5821142);

        UserProfile user3 = new UserProfile();  // Palatul Culturii
        user3.setLastLat(47.1573021);
        user3.setLastLng(27.5869821);


        users.add(user1);
        users.add(user2);
        users.add(user3);

        List<UserProfile> nearbyUsers = userProfilesByLocationHelper.GetUsers(p, users);
        Assert.assertEquals(3, nearbyUsers.size());
    }

    @Test
    public void WhenGiven2AttractionNearCentralPointAndOneFarAway_ResultShouldBe2() {
        Point p = new Point(47.1617486, 27.5841862);  // Primaria Iasi
        UserProfilesByLocationHelper userProfilesByLocationHelper = new UserProfilesByLocationHelper();
        List<UserProfile> users = new ArrayList<>();

        UserProfile user1 = new UserProfile();  // Piata Unirii
        user1.setLastLat(47.1656503);
        user1.setLastLng(27.5803949);

        UserProfile user2 = new UserProfile();  // Mitropolia Iasi
        user2.setLastLat(47.1610055);
        user2.setLastLng(27.5821142);

        UserProfile user3 = new UserProfile();  // La Castel
        user3.setLastLat(47.2099973);
        user3.setLastLng(27.5343217);


        users.add(user1);
        users.add(user2);
        users.add(user3);

        List<UserProfile> nearbyUsers = userProfilesByLocationHelper.GetUsers(p, users);
        Assert.assertEquals(2, nearbyUsers.size());
    }

    @Test
    public void WhenGivenNoAttractionNearCentralPoint_ResultShouldBe0() {
        Point p = new Point(47.1617486, 27.5841862);  // Primaria Iasi
        UserProfilesByLocationHelper userProfilesByLocationHelper = new UserProfilesByLocationHelper();
        List<UserProfile> users = new ArrayList<>();

        UserProfile user1 = new UserProfile();  // Lunca Cetatuii
        user1.setLastLat(47.0982573);
        user1.setLastLng(27.559814);

        UserProfile user3 = new UserProfile();  // La Castel
        user3.setLastLat(47.2099973);
        user3.setLastLng(27.5343217);


        users.add(user1);
        users.add(user3);

        List<UserProfile> nearbyUsers = userProfilesByLocationHelper.GetUsers(p, users);
        Assert.assertEquals(0, nearbyUsers.size());
    }

}