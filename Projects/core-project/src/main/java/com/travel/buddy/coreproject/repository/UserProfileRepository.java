package com.travel.buddy.coreproject.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.buddy.coreproject.model.Interest;
import com.travel.buddy.coreproject.model.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Serializable> {

	Interest findUserInterestById(Long id);
	
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM UserProfile c WHERE c.phoneNumber = :phoneNumber")
    public boolean existsByPhonenumber(@Param("phoneNumber") String phoneNumber);
	
}
