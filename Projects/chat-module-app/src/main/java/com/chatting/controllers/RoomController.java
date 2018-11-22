package com.chatting.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatting.models.Room;
import com.chatting.services.RoomService;

@RestController
@RequestMapping(value = "/room")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@PostMapping(value = "/findAllByUserId")
	public List<Room> getAllRoomsForOneUser(@RequestParam("userId") Long userId){
		return roomService.getAllRoomsForOneUser(userId);
	}
}
