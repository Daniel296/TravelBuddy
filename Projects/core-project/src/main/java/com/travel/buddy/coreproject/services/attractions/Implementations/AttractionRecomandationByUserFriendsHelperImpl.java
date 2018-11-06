package com.travel.buddy.coreproject.services.attractions.Implementations;

import com.travel.buddy.coreproject.model.Activity;
import com.travel.buddy.coreproject.model.Attraction;
import com.travel.buddy.coreproject.model.Matches;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.repository.MatchesRepository;
import com.travel.buddy.coreproject.services.attractions.Interfaces.AttractionRecomandationHelper;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;

public class AttractionRecomandationByUserFriendsHelperImpl implements AttractionRecomandationHelper {
    private UserProfile userProfile;
    private MatchesRepository matchesRepository;
    private List<Matches> allMatches;

    public AttractionRecomandationByUserFriendsHelperImpl(UserProfile _userProfile){
        userProfile = _userProfile;
    }

    public List<Attraction> getAttractions(){
        List<UserProfile> matchedUsers = new ArrayList<>();
        List<Attraction> attractions = new ArrayList<>();
        List<Activity> activities = new ArrayList<>();

        allMatches = matchesRepository.findAll(); //iau toate match-urile user-ului

        for (Matches match : allMatches){
            if(match.getUserProfile1().getUserProfileId() == userProfile.getUserProfileId())
                matchedUsers.add(match.getUserProfile2()); //retin userii cu care a fost match-uit
            if(match.getUserProfile2().getUserProfileId() == userProfile.getUserProfileId())
                matchedUsers.add(match.getUserProfile1());
        }

        for(UserProfile profile : matchedUsers)
            activities.addAll(profile.getActivities()); // iau toate activitatile de la persoanele match-uite

        for(Activity a : activities)
            attractions.addAll(a.getAttractions()); 

        return attractions;
    }
}