package com.travel.buddy.coreproject.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.buddy.coreproject.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Serializable>{

}
