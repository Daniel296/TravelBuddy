package com.travel.buddy.coreproject.tests;

import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.matches.Implementations.Point;
import com.travel.buddy.coreproject.services.matches.Implementations.UserProfilesByLocationHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserProfilesByLocationHelperTest {

    @Test
    public void getUsers() {
        Point p = new Point(40, 40);
        UserProfilesByLocationHelper userProfilesByLocationHelper = new UserProfilesByLocationHelper();
        List<UserProfile> users = userProfilesByLocationHelper.GetUsers(p);
        Assert.assertNull(users);
    }
}
