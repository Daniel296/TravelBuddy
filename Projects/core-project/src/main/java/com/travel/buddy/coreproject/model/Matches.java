package com.travel.buddy.coreproject.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
	@JoinColumn(name = "USER_PROFILE_ID1")
	private UserProfile userProfile1;
	
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
	@JoinColumn(name = "USER_PROFILE_ID2")
	private UserProfile userProfile2;
	
	public Matches() {
		super();
	}

	public Matches(long id, String compatibilityScore, long timestamp, boolean matchAcceptedByFirstUser,
			boolean matchAcceptedBySecondUser, UserProfile userProfile1, UserProfile userProfile2) {
		super();
		this.id = id;
		this.compatibilityScore = compatibilityScore;
		this.timestamp = timestamp;
		this.matchAcceptedByFirstUser = matchAcceptedByFirstUser;
		this.matchAcceptedBySecondUser = matchAcceptedBySecondUser;
		this.userProfile1 = userProfile1;
		this.userProfile2 = userProfile2;
	}

	public Matches(String compatibilityScore, long timestamp, boolean matchAcceptedByFirstUser,
			boolean matchAcceptedBySecondUser, UserProfile userProfile1, UserProfile userProfile2) {
		super();
		this.compatibilityScore = compatibilityScore;
		this.timestamp = timestamp;
		this.matchAcceptedByFirstUser = matchAcceptedByFirstUser;
		this.matchAcceptedBySecondUser = matchAcceptedBySecondUser;
		this.userProfile1 = userProfile1;
		this.userProfile2 = userProfile2;
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

	public UserProfile getUserProfile1() {
		return userProfile1;
	}

	public void setUserProfile1(UserProfile userProfile1) {
		this.userProfile1 = userProfile1;
	}

	public UserProfile getUserProfile2() {
		return userProfile2;
	}

	public void setUserProfile2(UserProfile userProfile2) {
		this.userProfile2 = userProfile2;
	}
}
