package com.travel.buddy.coreproject.services.matches.Interfaces;

import com.travel.buddy.coreproject.model.UserProfile;

import java.util.List;

public interface MatchFilterHelper {
    List<UserProfile> getUsers(List<UserProfile> users);
}
