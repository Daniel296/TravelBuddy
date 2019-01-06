package com.travel.buddy.coreproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.buddy.coreproject.services.room.BLIRoomService;

@RestController
@RequestMapping(value = "chat/room")
public class RoomController {
	
	@Autowired
	private BLIRoomService roomService;
}
