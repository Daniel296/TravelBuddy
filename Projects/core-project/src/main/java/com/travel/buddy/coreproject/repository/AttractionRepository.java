package com.travel.buddy.coreproject.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.buddy.coreproject.model.Attraction;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Serializable> {

}
