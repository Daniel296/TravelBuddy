package com.travel.buddy.coreproject.utils;

import com.travel.buddy.coreproject.model.Matches;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.repository.MatchesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetUserFriendsHelper {

    @Autowired
    private static MatchesRepository repository;

    public static Set<UserProfile> getFriends(UserProfile user){

        Set<UserProfile> friends = new HashSet<UserProfile>();

        List<Matches> matches = repository.findAll();

        for(Matches match:matches){
            if (match.getUserProfile1().getId() == user.getId()){
                friends.add(match.getUserProfile2());
            }
            else{
                if (match.getUserProfile2().getId() == user.getId()){
                    friends.add(match.getUserProfile1());
                }
            }
        }
        return friends;
    }

}
