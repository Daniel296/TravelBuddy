package com.travel.buddy.coreproject.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.travel.buddy.coreproject.model.UserSession;

@Repository
public interface UserSessionRepository extends JpaRepository<UserSession, Serializable> {

	@Query(value = "select from USER_SESSION where USER_SESSION_UUID = :sessionUUID", nativeQuery = true)
	public UserSession getUserSessionBySessionUUID(@Param("sessionUUID") String sessionUUID);

	@Query(value = "select USER_LOGIN_ID from USER_SESSION where USER_SESSION_UUID = :sessionUUID", nativeQuery = true)
	public Long getUserLoginIdBySessionUUID(@Param("sessionUUID") String sessionUUID);

	/*@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "insert into USER_SESSION set USER_LOGIN_ID = (:userLoginId), "
			+ "SESSION_UUID = (:sessionUUID), TIMESTAMP = (:timestamp)", nativeQuery = true)
	public void save(@Param("userLoginId") long userLoginId, @Param("sessionUUID") String sessionUUID,
			@Param("timestamp") long timestamp);*/

}
