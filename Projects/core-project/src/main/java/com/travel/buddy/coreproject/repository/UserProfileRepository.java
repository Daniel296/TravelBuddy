package com.travel.buddy.coreproject.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.travel.buddy.coreproject.model.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Serializable> {
    @Query(value = "SELECT U FROM USER_PROFILE U")
    public List<UserProfile> findAll();
}
