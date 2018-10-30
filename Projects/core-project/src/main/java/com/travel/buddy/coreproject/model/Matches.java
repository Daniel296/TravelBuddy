package com.travel.buddy.coreproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MATCHES")
public class Matches implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8130653175181230734L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MATCH_ID", unique = true, nullable = false)
	private long matchId;
	
	@Column(name = "FIRST_USER_ID", unique = false, nullable = false)
	private long firstUserId;
	
	@Column(name = "SECOND_USER_ID", unique = false, nullable = false)
	private long secondUserId;
	
	@Column(name = "COMPATIBILITY_SCORE", unique = false, nullable = false)
	private String compatibilityScore;
	
	@Column(name = "TIMESTAMP", unique = true, nullable = false)
	private String timestamp;

	@Column(name = "MATCH_ACCEPTED_BY_FIRST_USER", unique = false, nullable = false)
	private boolean matchAcceptedByFirstUser;
	
	@Column(name = "MATCH_ACCEPTED_BY_SECOND_USER", unique = false, nullable = false)
	private boolean matchAcceptedBySecondUser;
	
	public Matches() {
		super();
	}

	public Matches(long matchId, long firstUserId, long secondUserId, String compatibilityScore, String timestamp,
			boolean matchAcceptedByFirstUser, boolean matchAcceptedBySecondUser) {
		super();
		this.matchId = matchId;
		this.firstUserId = firstUserId;
		this.secondUserId = secondUserId;
		this.compatibilityScore = compatibilityScore;
		this.timestamp = timestamp;
		this.matchAcceptedByFirstUser = matchAcceptedByFirstUser;
		this.matchAcceptedBySecondUser = matchAcceptedBySecondUser;
	}

	public Matches(long firstUserId, long secondUserId, String compatibilityScore, String timestamp,
			boolean matchAcceptedByFirstUser, boolean matchAcceptedBySecondUser) {
		super();
		this.firstUserId = firstUserId;
		this.secondUserId = secondUserId;
		this.compatibilityScore = compatibilityScore;
		this.timestamp = timestamp;
		this.matchAcceptedByFirstUser = matchAcceptedByFirstUser;
		this.matchAcceptedBySecondUser = matchAcceptedBySecondUser;
	}

	public long getMatchId() {
		return matchId;
	}

	public void setMatchId(long matchId) {
		this.matchId = matchId;
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

	public String getCompatibilityScore() {
		return compatibilityScore;
	}

	public void setCompatibilityScore(String compatibilityScore) {
		this.compatibilityScore = compatibilityScore;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
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
}
