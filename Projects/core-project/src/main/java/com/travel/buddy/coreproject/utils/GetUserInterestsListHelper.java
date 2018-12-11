package com.travel.buddy.coreproject.utils;

import com.travel.buddy.coreproject.model.Interest;

import java.lang.reflect.Field;
import java.util.*;

public class GetUserInterestsListHelper {
    public static List<String> interestssAsStringList = Arrays.asList(
            "amusement_park",
            "aquarium",
            "art_gallery",
            "beach",
            "bar",
            "bridge",
            "bowling_alley",
            "cafe",
            "casino",
            "cemetery",
            "church",
            "embassy",
            "hindu_temple",
            "lake",
            "library",
            "liquor_store",
            "mall",
            "mosque",
            "mountain",
            "movie_theater",
            "museum",
            "night_club",
            "ocean",
            "palace",
            "park",
            "restaurant",
            "school",
            "stadium",
            "synagogue",
            "sea",
            "ski",
            "tower",
            "tradition",
            "zoo"
            );
    public static Set<String> getInterests(Interest interest){
        Set<String> interests = new HashSet<>();
        boolean isSet;
        for(String i : interestssAsStringList){
            try {
                Field f = interest.getClass().getDeclaredField(i); //NoSuchFieldException
                f.setAccessible(true);
                isSet =  f.getBoolean(interest);
                if(isSet){
                    interests.add(i);
                }
            }
            catch(Exception ex){
                //System.out.println(ex.toString());
            }
        }
        return interests;
    }
}
