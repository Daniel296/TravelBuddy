package com.travel.buddy.coreproject.services.sessions.interfaces;

public interface BLIUserSessionService {
	public boolean checkIfUserSessionUUIDExists(String sessionUUID);
	
	public long getUserLoginIdBySessionUUID(String sessionUUID);
	
	public String createNewUserSessionAndReturnIt(long userLoginId);
}
