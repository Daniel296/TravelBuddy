package com.travel.buddy.coreproject.services.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.buddy.coreproject.repository.RoomRepository;

@Service
public class BLRoomService implements BLIRoomService{
	
	@Autowired
	private RoomRepository roomRepository;
}
