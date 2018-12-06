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
    @Column(name = "USER_SESSion_ID", unique = true, nullable = false)
	private long id;
	
	@Column(name = "USER_LOGIN_ID", unique = true, nullable = false)
	private long userLoginId;
	
	@Column(name = "SESSION_ID", unique = true, nullable = false)
	private String sessionId;
	
	@Column(name = "TIMESTAMP", unique = false, nullable = false)
	private long timestamp;
	
	
	public UserSession() {
		super();
	}

	public UserSession(long id, long userLoginId, String sessionId, long timestamp) {
		super();
		this.id = id;
		this.userLoginId = userLoginId;
		this.sessionId = sessionId;
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

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "UserSession [id=" + id + ", userLoginId=" + userLoginId + ", sessionId=" + sessionId + ", timestamp="
				+ timestamp + "]";
	}
}
