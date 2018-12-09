package com.travel.buddy.coreproject.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.buddy.coreproject.model.TravelPlan;

@Repository
public interface TravelPlanRepository extends JpaRepository<TravelPlan, Serializable> {
	@Query(value="select * from TRAVEL_PLAN where TRAVEL_PLAN_ID = :travelPlanId", nativeQuery=true)
	public TravelPlan findByTravelPlanId(@Param("travelPlanId") long travelPlanId);
}
