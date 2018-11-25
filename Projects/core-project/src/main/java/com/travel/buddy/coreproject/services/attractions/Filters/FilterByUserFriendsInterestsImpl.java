package com.travel.buddy.coreproject.services.attractions.Filters;

import com.travel.buddy.coreproject.DTOs.AttractionDTO;
import com.travel.buddy.coreproject.model.Interest;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.attractions.Interfaces.FilterHelper;
import com.travel.buddy.coreproject.utils.GetUserFriendsHelper;
import com.travel.buddy.coreproject.utils.GetUserInterestsListHelper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilterByUserFriendsInterestsImpl implements FilterHelper {

    @Override
    public List<AttractionDTO> getAttractions(UserProfile user, List<AttractionDTO> attractionDTOS) {

        List<AttractionDTO> results = new ArrayList<>();
        Set<UserProfile> userFriends = GetUserFriendsHelper.getFriends(user);

        //compute a list with all the friends interests
        Set<String> friendsInterests = new HashSet<>();
        for (UserProfile friend : userFriends) {
            Interest friendInterest = friend.getInterest();
            Set<String> interests = GetUserInterestsListHelper.getInterests(friendInterest);
            friendsInterests.addAll(interests);
        }

        //for each attraction interest intersect with friends interests and compute list of attractions
        for (AttractionDTO attr : attractionDTOS) {

            Set<String> attrTypes = new HashSet<String>(attr.getInterests());
            int p = 1; // default comment
            attrTypes.retainAll(friendsInterests);

            if (attrTypes.size() > 0) {
                results.add(attr);
            }
        }

        return results;
    }
}
