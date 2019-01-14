package com.travel.buddy.coreproject.services.matches.Implementations;

import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.repository.UserProfileRepository;
import com.travel.buddy.coreproject.utils.Constants;
import com.travel.buddy.coreproject.utils.GetUserFriendsHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// rulat la o anumita perioada de timp si de updatat un tabel cu recomandari

public class MatchesRecomandationsService {

    @Autowired
    UserProfileRepository userProfileRepository;

    private Map<UserProfile, Double> userSubstractScoresMap = new HashMap<UserProfile, Double>();
    // build a map having as key an user profile and as value a map like <user, score>
    //

    private void prepareSubstractScores() {
        List<UserProfile> userProfiles = userProfileRepository.findAll();
        for (UserProfile userProfile : userProfiles) {
            Set<UserProfile> userFriends = GetUserFriendsHelper.getFriends(userProfile);
            int userFriendsNumber = userFriends.size();
            double substractScore = userFriendsNumber * Constants.SUBSTRACT_UNIT_PER_USER_FRIEND;
            userSubstractScoresMap.put(userProfile, substractScore);
        }
    }

    public MatchesRecomandationsService() {
        List<UserProfile> userProfiles = userProfileRepository.findAll();
        MergeMatchScores mergeScore = MergeMatchScores.getInstance();
        Map<UserProfile, Object> scoreMap = new HashMap<UserProfile, Object>();

        for(UserProfile userProfile: userProfiles)
        {
             //to be added into a table of recommandation (to be created)
            for(UserProfile anotherUser:userProfiles)
            {
                if (anotherUser.getId() != userProfile.getId()) {
                    double score = mergeScore.getScore(userProfile, anotherUser);
                    double substractScore = score  - (double)userSubstractScoresMap.get(anotherUser);
                    scoreMap.put(anotherUser, score-substractScore);
                }
            }
            Map userScoresMap = new HashMap();
            userScoresMap.put(userProfile, scoreMap);
        }
    }
}