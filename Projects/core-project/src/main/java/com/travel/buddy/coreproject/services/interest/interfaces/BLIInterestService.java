package com.travel.buddy.coreproject.services.interest.interfaces;

import com.travel.buddy.coreproject.model.Interest;

public interface BLIInterestService {
    Interest getUserInterestBySessionUUID(String sessionUUID);
}
