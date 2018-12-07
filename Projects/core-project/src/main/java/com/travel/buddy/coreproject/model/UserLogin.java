package com.travel.buddy.coreproject.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "USER_LOGIN")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserLogin implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -4630951279196708431L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_LOGIN_ID", unique = true, nullable = false)
    private long id;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "FACEBOOK_TOKEN", nullable = true)
    private String facebookToken;

    @Column(name = "GOOGLE_TOKEN", nullable = true)
    private String googleToken;

    @OneToOne(mappedBy = "userLogin", cascade = CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
    @JsonBackReference
    private UserProfile userProfile;
    
    @OneToOne(mappedBy = "userProfile1", cascade = CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
    @JsonBackReference
    private Matches matches1;
    
    @OneToOne(mappedBy = "userProfile2", cascade = CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
    @JsonBackReference
    private Matches matches2;
    
    
    public UserLogin() {
    	super();
    }

	public UserLogin(long id, String email, String password, String facebookToken, String googleToken,
			UserProfile userProfile, Matches matches1, Matches matches2) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.facebookToken = facebookToken;
		this.googleToken = googleToken;
		this.userProfile = userProfile;
		this.matches1 = matches1;
		this.matches2 = matches2;
	}

	public UserLogin(String email, String password, String facebookToken, String googleToken, UserProfile userProfile,
			Matches matches1, Matches matches2) {
		super();
		this.email = email;
		this.password = password;
		this.facebookToken = facebookToken;
		this.googleToken = googleToken;
		this.userProfile = userProfile;
		this.matches1 = matches1;
		this.matches2 = matches2;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFacebookToken() {
		return facebookToken;
	}

	public void setFacebookToken(String facebookToken) {
		this.facebookToken = facebookToken;
	}

	public String getGoogleToken() {
		return googleToken;
	}

	public void setGoogleToken(String googleToken) {
		this.googleToken = googleToken;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public Matches getMatches1() {
		return matches1;
	}

	public void setMatches1(Matches matches1) {
		this.matches1 = matches1;
	}

	public Matches getMatches2() {
		return matches2;
	}

	public void setMatches2(Matches matches2) {
		this.matches2 = matches2;
	}
}
