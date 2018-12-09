package com.travel.buddy.coreproject.tests;

import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.matches.Implementations.Point;
import com.travel.buddy.coreproject.services.matches.Implementations.UserProfilesByLocationHelper;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

public class UserProfilesByLocationHelperTest {

    @Test
    public void getUsers() {
        Point p = new Point(40, 40);
        UserProfilesByLocationHelper userProfilesByLocationHelper = new UserProfilesByLocationHelper();
        List<UserProfile> users = userProfilesByLocationHelper.GetUsers(p);
        Assert.assertNull(users);
    }
}
