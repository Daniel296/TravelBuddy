package com.travel.buddy.coreproject.services.sessions.implementations;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.buddy.coreproject.model.UserSession;
import com.travel.buddy.coreproject.repository.UserSessionRepository;
import com.travel.buddy.coreproject.services.sessions.interfaces.BLIUserSessionService;
import com.travel.buddy.coreproject.utils.Constants;

@Service
public class BLUserSessionService implements BLIUserSessionService {

	@Autowired
	private UserSessionRepository userSessionRepository;

	@Override
	public boolean checkIfUserSessionUUIDExists(String sessionUUID) {
		UserSession session = null;
		try {
			session = userSessionRepository.getUserSessionBySessionUUID(sessionUUID);
		} catch (Exception e) {
			Constants.LOGGER.info("SESSION SERVICE---checkIfUserSessionUUIDExists(String sessionUUI)---"
					+ "non-existent sessionUUID");
		}
		if (session == null) {
			return false;
		}
		return true;
	}

	@Override
	public Long getUserLoginIdBySessionUUID(String sessionUUID) {
		Long userLoginId = null;
		try {
			userLoginId = userSessionRepository.getUserLoginIdBySessionUUID(sessionUUID);
		} catch (Exception e) {
			Constants.LOGGER.info("SESSION SERVICE---getUserLoginIdBySessionUUID(String sessionUUID)---"
					+ "non-existent sessionUUID");
		}
		return userLoginId;
	}

	@Override
	public String createNewUserSessionAndReturnIt(long userLoginId) {
		UUID uuid = UUID.randomUUID();
		String sessionUUID = uuid.toString();
		
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		long timestamp = Long.parseLong(df.format(currentTimestamp));
		
		userSessionRepository.save(new UserSession(userLoginId, sessionUUID, timestamp));
		
		return sessionUUID;
	}

}
