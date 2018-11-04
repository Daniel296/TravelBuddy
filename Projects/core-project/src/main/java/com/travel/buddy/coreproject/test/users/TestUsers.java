package com.travel.buddy.coreproject.test.users;


import com.travel.buddy.coreproject.model.UserProfile;
import org.junit.Assert;
import org.junit.Test;

public class TestUsers {
    @Test
    public void TestUser(){
        String fName = "Petrisor";
        UserProfile userProfile = new UserProfile(fName, "", "", "", "", null, null, null);
        Assert.assertEquals(userProfile.getFirstName(), fName);
    }
}
