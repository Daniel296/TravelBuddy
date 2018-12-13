package com.travel.buddy.coreproject.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Constants {
    public static int RECOMENDED_ATTRACTIONS_MIN = 10;
    public static int RECOMENDED_ATTRACTIONS_MAX = 30;
    public static int TRAVELPLANITEM_MAX_DISTANCE = 5;
    public static double TRAVELPLANITEM_CLOSE_DISTANCE = 5;
    public static int MAX_NEARBY_USERS = 20;
    public static double SUBSTRACT_UNIT_PER_USER_FRIEND = 0.5;
    public static String API_KEY = "AIzaSyAvEehceQnGa0DWPp6vWvzDOIXOjXEcf1g";


    /* SCORE PERCENTAGES */
    public static double MATCHES_FUTURE_TRIPS_PERCENT = 0.00;
    public static double MATCHES_PAST_TRIPS_PERCENT = 0.00;
    public static double MATCHES_INTERESTS_PERCENT = 1.0;
    
    
    public static Logger LOGGER = LoggerFactory.getLogger(Constants.class);
}
