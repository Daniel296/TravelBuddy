package com.travel.buddy.coreproject.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name ="ROOM")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Room implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -444151752172567632L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROOM_ID", unique = true, nullable = false)
	private long id;
	
	@Column(name= "FIRST_PARTNER_ID", unique = false, nullable = false)
	private long firstPartnerId;
	
	@Column(name= "SECOND_PARTNER_ID", unique = false, nullable = false)
	private long secondPartnerId;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "ROOM_ID")
//    @JsonBackReference
	@JsonManagedReference
	private List<Message> roomMessages;
	
	public Room() {
		super();
	}

	public Room(long id, long firstPartnerId, long secondPartnerId, List<Message> roomMessages) {
		super();
		this.id = id;
		this.firstPartnerId = firstPartnerId;
		this.secondPartnerId = secondPartnerId;
		this.roomMessages = roomMessages;
	}

	public Room(long firstPartnerId, long secondPartnerId, List<Message> roomMessages) {
		super();
		this.firstPartnerId = firstPartnerId;
		this.secondPartnerId = secondPartnerId;
		this.roomMessages = roomMessages;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFirstPartnerId() {
		return firstPartnerId;
	}

	public void setFirstPartnerId(long firstPartnerId) {
		this.firstPartnerId = firstPartnerId;
	}

	public long getSecondPartnerId() {
		return secondPartnerId;
	}

	public void setSecondPartnerId(long secondPartnerId) {
		this.secondPartnerId = secondPartnerId;
	}

	public List<Message> getRoomMessages() {
		return roomMessages;
	}

	public void setRoomMessages(List<Message> roomMessages) {
		this.roomMessages = roomMessages;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", firstPartnerId=" + firstPartnerId + ", secondPartnerId=" + secondPartnerId
				+ ", roomMessages=" + roomMessages + "]";
	}
}

