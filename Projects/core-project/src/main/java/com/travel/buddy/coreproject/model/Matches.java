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
@Table(name = "MATCHES")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Matches implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8130653175181230734L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MATCHES_ID", unique = true, nullable = false)
	private long id;
	
	@Column(name = "COMPATIBILITY_SCORE", unique = false, nullable = false)
	private String compatibilityScore;
	
	@Column(name = "TIMESTAMP", unique = true, nullable = false)
	private long timestamp;

	@Column(name = "MATCH_ACCEPTED_BY_FIRST_USER", unique = false, nullable = false)
	private boolean matchAcceptedByFirstUser;
	
	@Column(name = "MATCH_ACCEPTED_BY_SECOND_USER", unique = false, nullable = false)
	private boolean matchAcceptedBySecondUser;
	
	@Column(name = "FIRST_USER_ID", unique = false, nullable = false)
	private long firstUserId;
	
	@Column(name = "SECOND_USER_ID", unique = false, nullable = false)
	private long secondUserId;
	
	public Matches() {
		super();
	}

	public Matches(long id, String compatibilityScore, long timestamp, boolean matchAcceptedByFirstUser,
			boolean matchAcceptedBySecondUser, long firstUserId, long secondUserId) {
		super();
		this.id = id;
		this.compatibilityScore = compatibilityScore;
		this.timestamp = timestamp;
		this.matchAcceptedByFirstUser = matchAcceptedByFirstUser;
		this.matchAcceptedBySecondUser = matchAcceptedBySecondUser;
		this.firstUserId = firstUserId;
		this.secondUserId = secondUserId;
	}

	public Matches(String compatibilityScore, long timestamp, boolean matchAcceptedByFirstUser,
			boolean matchAcceptedBySecondUser, long firstUserId, long secondUserId) {
		super();
		this.compatibilityScore = compatibilityScore;
		this.timestamp = timestamp;
		this.matchAcceptedByFirstUser = matchAcceptedByFirstUser;
		this.matchAcceptedBySecondUser = matchAcceptedBySecondUser;
		this.firstUserId = firstUserId;
		this.secondUserId = secondUserId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompatibilityScore() {
		return compatibilityScore;
	}

	public void setCompatibilityScore(String compatibilityScore) {
		this.compatibilityScore = compatibilityScore;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isMatchAcceptedByFirstUser() {
		return matchAcceptedByFirstUser;
	}

	public void setMatchAcceptedByFirstUser(boolean matchAcceptedByFirstUser) {
		this.matchAcceptedByFirstUser = matchAcceptedByFirstUser;
	}

	public boolean isMatchAcceptedBySecondUser() {
		return matchAcceptedBySecondUser;
	}

	public void setMatchAcceptedBySecondUser(boolean matchAcceptedBySecondUser) {
		this.matchAcceptedBySecondUser = matchAcceptedBySecondUser;
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

	@Override
	public String toString() {
		return "Matches [id=" + id + ", compatibilityScore=" + compatibilityScore + ", timestamp=" + timestamp
				+ ", matchAcceptedByFirstUser=" + matchAcceptedByFirstUser + ", matchAcceptedBySecondUser="
				+ matchAcceptedBySecondUser + ", firstUserId=" + firstUserId + ", secondUserId=" + secondUserId + "]";
	}
}
