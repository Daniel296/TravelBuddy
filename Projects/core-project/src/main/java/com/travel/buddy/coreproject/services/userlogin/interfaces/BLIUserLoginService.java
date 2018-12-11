package com.travel.buddy.coreproject.services.userlogin.interfaces;

import com.travel.buddy.coreproject.model.UserLogin;
import com.travel.buddy.coreproject.model.UserProfile;

public interface BLIUserLoginService {
	UserProfile getUserProfileByUserLoginId(long userLoginId);

	UserLogin getUserLoginByEmailAndPassword(String email, String password);

	UserLogin getUserLoginByGoogleToken(String googleToken);

	UserLogin getUserLoginByFacebookToken(String facebookToken);
}
