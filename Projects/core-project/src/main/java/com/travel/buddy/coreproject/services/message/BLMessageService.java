package com.travel.buddy.coreproject.services.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.buddy.coreproject.repository.MessageRepository;

@Service
public class BLMessageService implements BLIMessageService{
	
	@Autowired
	private MessageRepository messageRepository;
}
