package com.travel.buddy.coreproject.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.buddy.coreproject.model.UserLogin;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Serializable>{
	@Query(value = "select * from USER_LOGIN where USER_LOGIN_ID = :userLoginId", nativeQuery = true)
	public UserLogin findById(@Param("userLoginId") long userLoginId);
	
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM UserLogin c WHERE c.email = :email")
    public boolean existsByEmail(@Param("email") String email);
}
