package com.travel.buddy.coreproject.services.interest.implementations;

import com.travel.buddy.coreproject.model.Interest;
import com.travel.buddy.coreproject.services.interest.interfaces.BLIInterestService;
import com.travel.buddy.coreproject.services.sessions.interfaces.BLIUserSessionService;
import com.travel.buddy.coreproject.services.userlogin.interfaces.BLIUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BLInterestService implements BLIInterestService{

    @Autowired
    private BLIUserSessionService userSessionService;

    @Autowired
    private BLIUserLoginService userLoginService;

    @Override
    public Interest getUserInterestBySessionUUID(String sessionUUID) {
        Long userId = userSessionService.getUserLoginIdBySessionUUID(sessionUUID);
        return userLoginService.getUserProfileByUserLoginId(userId).getInterest();
    }
}
