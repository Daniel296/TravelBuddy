package com.travel.buddy.coreproject.utils;

import com.travel.buddy.coreproject.model.Interest;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetUserInterestFromStringListHelper {

    public static Interest getInterest(Set<String> interestssAsStringList){
        Interest interest = new Interest();
        for(String i : interestssAsStringList){
            try {
                Field f = interest.getClass().getDeclaredField(i); //NoSuchFieldException
                f.setAccessible(true);
                f.setBoolean(interest, true);
            }
            catch(Exception ex){
                // i'll treat them later
            }
        }
        return interest;
    }

}
