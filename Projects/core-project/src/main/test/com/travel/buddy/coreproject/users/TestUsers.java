package com.travel.buddy.coreproject.users;


import com.travel.buddy.coreproject.model.UserProfile;
import org.junit.Assert;
import org.junit.Test;

public class TestUsers {
    @Test
    public void TestUser(){
        String fName = "Petrisor";
        UserProfile userProfile = new UserProfile("Petrisor", "", "", "", "", null, null, null, null);
        Assert.assertEquals(userProfile.getFirstName(), fName);
    }
}
