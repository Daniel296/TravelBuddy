package com.chatting.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("rawtypes")
@Entity
@Table(name = "USER")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable, Comparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4987217928990949477L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID", unique = true, nullable = false)
	private long id;
	
	@Column(name = "USER_PROFILE_ID", unique = true, nullable = false)
	private long userProfileId;
	
	@Column(name = "EMAIL", unique = true, nullable = false)
	private String email;
	
	
	@Column(name = "FIRSTNAME", unique = false, nullable = false)
	private String firtname;
	
	@Column(name = "LASTNAME", unique = false, nullable = false)
	private String lastname;
	
	@Column(name = "LAST_AJAX_REQUEST", unique = false, nullable = false)
	private double lastAJAXRequest;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "USER_ID")
    @JsonBackReference
	private List<Room> rooms;
	
	
	public User() {
		super();
	}

	public User(long id, long userProfileId, String email, String firtname, String lastname, double lastAJAXRequest,
			List<Room> rooms) {
		super();
		this.id = id;
		this.userProfileId = userProfileId;
		this.email = email;
		this.firtname = firtname;
		this.lastname = lastname;
		this.lastAJAXRequest = lastAJAXRequest;
		this.rooms = rooms;
	}

	public User(long userProfileId, String email, String firtname, String lastname, double lastAJAXRequest,
			List<Room> rooms) {
		super();
		this.userProfileId = userProfileId;
		this.email = email;
		this.firtname = firtname;
		this.lastname = lastname;
		this.lastAJAXRequest = lastAJAXRequest;
		this.rooms = rooms;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(long userProfileId) {
		this.userProfileId = userProfileId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirtname() {
		return firtname;
	}

	public void setFirtname(String firtname) {
		this.firtname = firtname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getLastAJAXRequest() {
		return lastAJAXRequest;
	}

	public void setLastAJAXRequest(double lastAJAXRequest) {
		this.lastAJAXRequest = lastAJAXRequest;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public int compareTo(Object o) {
		return this.email.compareTo(((User)o).getEmail());
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userProfileId=" + userProfileId + ", email=" + email + ", firtname=" + firtname
				+ ", lastname=" + lastname + ", lastAJAXRequest=" + lastAJAXRequest + ", rooms=" + rooms + "]";
	}
}
