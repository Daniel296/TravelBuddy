package com.travel.buddy.coreproject.repository;

import com.travel.buddy.coreproject.model.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Serializable> {

}