package com.travel.buddy.coreproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="CHAT_HISTORY")
public class ChatHistory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5484060196968203644L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CHAT_HISTORY_ID", unique = true, nullable = false)
	private long id;
	
	@Column(name = "FIRST_USER_ID", unique = false, nullable = false)
	private long firstUserId;
	
	@Column(name = "SECOND_USER_ID", unique = false, nullable = false)
	private long secondUserId;
	
	@Column(name = "MESSAGE", unique = true, nullable = false)
	private String message;
	
	@Column(name = "TIMESTAMP", unique = false, nullable = false)
	private long timestamp;
	
	@Column(name = "MESSAGE_TYPE", unique = false, nullable = false)
	private String messageType;
	
	public ChatHistory() {
		super();
	}

	public ChatHistory(long id, long firstUserId, long secondUserId, String message, long timestamp,
			String messageType) {
		super();
		this.id = id;
		this.firstUserId = firstUserId;
		this.secondUserId = secondUserId;
		this.message = message;
		this.timestamp = timestamp;
		this.messageType = messageType;
	}

	public ChatHistory(long firstUserId, long secondUserId, String message, long timestamp, String messageType) {
		super();
		this.firstUserId = firstUserId;
		this.secondUserId = secondUserId;
		this.message = message;
		this.timestamp = timestamp;
		this.messageType = messageType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFirstUserId() {
		return firstUserId;
	}

	public void setFirstUserId(long firstUserId) {
		this.firstUserId = firstUserId;
	}

	public long getSecondUserId() {
		return secondUserId;
	}

	public void setSecondUserId(long secondUserId) {
		this.secondUserId = secondUserId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
}
