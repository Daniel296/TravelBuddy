package com.chatting.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "MESSAGE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1717396129675638643L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MESSAGE_ID", unique = true, nullable = false)
	private long id;
	
	@Column(name = "MESSAGE", unique = false, nullable = false)
	private String message;
	
	@Column(name = "TIMESTAMP", unique = false, nullable = false)
	private Double timestamp;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ROOM_ID", referencedColumnName = "ROOM_ID", insertable=true, updatable=true)
//    @JsonManagedReference
	@JsonBackReference
	private Room room;
	
	
	public Message() {
		super();
	}

	public Message(long id, String message, Double timestamp, Room room) {
		super();
		this.id = id;
		this.message = message;
		this.timestamp = timestamp;
		this.room = room;
	}

	public Message(String message, Double timestamp, Room room) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.room = room;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Double getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Double timestamp) {
		this.timestamp = timestamp;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + ", timestamp=" + timestamp + ", room=" + room + "]";
	}
}
