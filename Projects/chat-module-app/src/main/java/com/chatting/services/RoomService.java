package com.chatting.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatting.DAOs.RoomDAO;
import com.chatting.models.Room;

@Service
public class RoomService {
	
	@Autowired
	private RoomDAO roomDAO;
	
	public List<Room> getAllRoomsForOneUser(long userId){
		return roomDAO.findAllUsersRooms(userId);
	}
}
