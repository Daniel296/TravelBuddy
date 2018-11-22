package com.chatting.models;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
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
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ROOM_PARTNER_ID", referencedColumnName = "USER_ID", insertable=true, updatable=true)
    @JsonManagedReference
	private User roomPartner;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", insertable=true, updatable=true)
    @JsonManagedReference
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "ROOM_ID")
//    @JsonBackReference
	@JsonManagedReference
	private List<Message> roomMessages;
	
	public Room() {
		super();
	}
}
