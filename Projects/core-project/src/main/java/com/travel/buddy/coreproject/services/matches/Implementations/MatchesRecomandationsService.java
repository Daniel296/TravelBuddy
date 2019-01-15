package com.travel.buddy.coreproject.services.matches.Implementations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.buddy.coreproject.DTOs.UserMatchDTO;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.repository.UserProfileRepository;
import com.travel.buddy.coreproject.services.matches.Interfaces.MatchesRecommandationsServiceInterface;
import com.travel.buddy.coreproject.utils.Constants;
import com.travel.buddy.coreproject.utils.GetUserFriendsHelper;

// rulat la o anumita perioada de timp si de updatat un tabel cu recomandari

@Service
public class MatchesRecomandationsService implements MatchesRecommandationsServiceInterface{

    @Autowired
    UserProfileRepository userProfileRepository;
    private Map<UserProfile, Double> userSubstractScoresMap = new HashMap<>();
    private  List<UserMatchDTO> usersRecomandationsList = new ArrayList<>();
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

    private void set(UserProfile userProfile) {
        prepareSubstractScores();
        List<UserProfile> userProfiles = userProfileRepository.findAll();
        MergeMatchScores mergeScore = MergeMatchScores.getInstance();
        Map<UserProfile, Double> scoreMap = new HashMap<>();

        //to be added into a table of recommandation (to be created)
        for (UserProfile anotherUser : userProfiles) {
            if (anotherUser.getId() != userProfile.getId()) {
                double score = mergeScore.getScore(userProfile, anotherUser);
                double substractScore = (double) userSubstractScoresMap.get(anotherUser);
                scoreMap.put(anotherUser, score - substractScore);
            }
        }
        ValueComparator bvc = new ValueComparator(scoreMap);
        TreeMap<UserProfile, Double> sorted_map = new TreeMap<>(bvc);
        int usersToAdd = Math.min(sorted_map.keySet().size(), 5);
        int count = 0;
        for (UserProfile user : sorted_map.keySet()) {
            if(count == usersToAdd)
                break;
            UserMatchDTO userMatchDTO = new UserMatchDTO();
            userMatchDTO.setCity(user.getCity().getName());
            userMatchDTO.setFirstName(user.getFirstName());
            userMatchDTO.setLastName(user.getLastName());
            usersRecomandationsList.add(userMatchDTO);
            count++;
        }
    }

    public MatchesRecomandationsService() {

    }

    public List<UserMatchDTO> getUsersRecomandations(UserProfile userProfile){
        List<UserProfile> userProfiles = userProfileRepository.findAll();
        for(UserProfile u : userProfiles){
            UserMatchDTO userMatchDTO = new UserMatchDTO();
            userMatchDTO.setCity(u.getCity().getName());
            userMatchDTO.setFirstName(u.getFirstName());
            userMatchDTO.setLastName(u.getLastName());
            usersRecomandationsList.add(userMatchDTO);
        }
        //set(userProfile);
        return usersRecomandationsList;
    }
}

class ValueComparator implements Comparator<UserProfile> {
    Map<UserProfile, Double> base;

    public ValueComparator(Map<UserProfile, Double> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with
    // equals.
    public int compare(UserProfile a, UserProfile b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}