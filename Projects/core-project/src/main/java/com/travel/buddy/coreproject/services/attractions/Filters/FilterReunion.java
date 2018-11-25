package com.travel.buddy.coreproject.services.attractions.Filters;

import com.google.common.collect.Lists;
import com.travel.buddy.coreproject.DTOs.AttractionDTO;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.attractions.Interfaces.FilterHelper;
import com.travel.buddy.coreproject.utils.Constants;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilterReunion {
    private List<FilterHelper> filterHelpers;

    public FilterReunion() {
        filterHelpers = new ArrayList<>();
        filterHelpers.add(new FilterByUserFriendsInterestsImpl());
        filterHelpers.add(new FilterByUserInterestsImpl());
    }

    public List<AttractionDTO> getAttractions(UserProfile userProfile, List<AttractionDTO> attractionDTOS) {
        if (attractionDTOS.size() < Constants.RECOMENDED_ATTRACTIONS_MAX && attractionDTOS.size() > Constants.RECOMENDED_ATTRACTIONS_MIN)
            return attractionDTOS;

        Set<AttractionDTO> attractions = new HashSet<>();

        for (FilterHelper filter : filterHelpers) {
            attractions.addAll(filter.getAttractions(userProfile, attractionDTOS));
            if (attractionDTOS.size() < Constants.RECOMENDED_ATTRACTIONS_MAX && attractionDTOS.size() > Constants.RECOMENDED_ATTRACTIONS_MIN)
                break;
        }
        return Lists.newArrayList(attractions);
    }
}