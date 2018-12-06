package com.travel.buddy.coreproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="USER_SESSION")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserSession implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 507511082577691611L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_SESSION_ID", unique = true, nullable = false)
	private long id;
	
	@Column(name = "USER_LOGIN_ID", unique = false, nullable = false)
	private long userLoginId;
	
	@Column(name = "SESSION_UUID", unique = true, nullable = false)
	private String sessionUUID;
	
	@Column(name = "TIMESTAMP", unique = false, nullable = false)
	private long timestamp;
	
	
	public UserSession() {
		super();
	}

	public UserSession(long id, long userLoginId, String sessionUUID, long timestamp) {
		super();
		this.id = id;
		this.userLoginId = userLoginId;
		this.sessionUUID = sessionUUID;
		this.timestamp = timestamp;
	}
	
	public UserSession(long userLoginId, String sessionUUID, long timestamp) {
		super();
		this.userLoginId = userLoginId;
		this.sessionUUID = sessionUUID;
		this.timestamp = timestamp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(long userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getSessionUUID() {
		return sessionUUID;
	}

	public void setSessionUUID(String sessionUUID) {
		this.sessionUUID = sessionUUID;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "UserSession [id=" + id + ", userLoginId=" + userLoginId + ", sessionUUID=" + sessionUUID + ", timestamp="
				+ timestamp + "]";
	}
}
