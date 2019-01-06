package com.travel.buddy.coreproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.buddy.coreproject.services.message.BLIMessageService;

@RestController
@RequestMapping(value = "chat/message")
public class MessageController {
	
	@Autowired
	private BLIMessageService messageService;
}
