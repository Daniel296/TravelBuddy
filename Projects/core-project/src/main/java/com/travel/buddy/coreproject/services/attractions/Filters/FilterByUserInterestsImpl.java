package com.travel.buddy.coreproject.services.attractions.Filters;

import com.travel.buddy.coreproject.DTOs.AttractionDTO;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.services.attractions.Interfaces.FilterHelper;
import com.travel.buddy.coreproject.utils.GetUserInterestsListHelper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilterByUserInterestsImpl implements FilterHelper {

    @Override
    public List<AttractionDTO> getAttractions(UserProfile user, List<AttractionDTO> attractionDTOS) {

        List<AttractionDTO> results = new ArrayList<>();
        Set<String> userTypes= GetUserInterestsListHelper.getInterests(user.getInterest());

        //for each attraction, compute the intersection between the current attraction types and our user interests types and add it to results if positive size
        for(AttractionDTO attr:attractionDTOS) {

            Set<String> attrTypes = new HashSet<String>(attr.getInterests());

            attrTypes.retainAll(userTypes);

            if (attrTypes.size() > 0) {
                results.add(attr);
            }
        }

        return results;
    }
}
