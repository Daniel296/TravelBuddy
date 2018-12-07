package com.travel.buddy.coreproject.services.userlogin.interfaces;

import com.travel.buddy.coreproject.model.UserProfile;

public interface BLIUserLoginService {
	public UserProfile getUserProfileByUserLoginId(long userLoginId);
}
