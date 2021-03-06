package com.travel.buddy.coreproject.services.userlogin.implementations;

import org.springframework.beans.factory.annotation.Autowired;

import com.travel.buddy.coreproject.model.UserLogin;
import com.travel.buddy.coreproject.model.UserProfile;
import com.travel.buddy.coreproject.repository.UserLoginRepository;
import com.travel.buddy.coreproject.services.userlogin.interfaces.BLIUserLoginService;
import com.travel.buddy.coreproject.utils.Constants;
import org.springframework.stereotype.Service;

@Service
public class BLUserLoginService implements BLIUserLoginService {
	@Autowired
	private UserLoginRepository userLoginRepository;
	
	@Override
	public UserProfile getUserProfileByUserLoginId(long userLoginId) {
		UserLogin userLogin = null;
		try{
			userLogin = userLoginRepository.findById(userLoginId);
		}catch(Exception e) {
			Constants.LOGGER.info("USERLOGIN SERVICE---getUserProfileByUserLoginId(long userLoginId)---"
					+ "non-existent userLoginId");
		}
		
		if( userLogin != null ) {
			return userLogin.getUserProfile();
		}else {
			return null;
		}
	}

	@Override
	public UserLogin getUserLoginByEmailAndPassword(String email, String password) {
		UserLogin userLogin = null;
		try{
			userLogin = userLoginRepository.findByEmailAndPassword(email, password);
		}catch(Exception e) {
			Constants.LOGGER.info("USERLOGIN SERVICE---getUserLoginByEmailAndPassword(String email, String password)---"
					+ "non-existent userLoginId");
		}

		if( userLogin != null ) {
			return userLogin;
		}else {
			return null;
		}
	}

	@Override
	public UserLogin getUserLoginByGoogleToken(String googleToken) {



		return null;
	}

	@Override
	public UserLogin getUserLoginByFacebookToken(String facebookToken) {
		return null;
	}

}
