package com.travel.buddy.coreproject.services.sessions.implementations;

import org.springframework.stereotype.Service;

import com.travel.buddy.coreproject.services.sessions.interfaces.BLIUserSessionService;

@Service
public class BLUserSessionService implements BLIUserSessionService{

	@Override
	public boolean checkIfUserSessionUUIDExists(String sessionUUID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getUserLoginIdBySessionUUID(String sessionUUID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String createNewUserSessionAndReturnIt(long userLoginId) {
		// TODO Auto-generated method stub
		return null;
	}

}
