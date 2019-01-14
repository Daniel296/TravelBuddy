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

    @Column(name = "PASSWORD", unique = false, nullable = false)
    private String password;

    @Column(name = "FACEBOOK_TOKEN", unique = true, nullable = true)
    private String facebookToken;

    @Column(name = "GOOGLE_TOKEN", unique = true, nullable = true)
    private String googleToken;

    @OneToOne(mappedBy = "userLogin", cascade = CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
//    @JsonManagedReference
    private UserProfile userProfile;
    
    
    public UserLogin() {
    	super();
    }

	public UserLogin(long id, String email, String password, String facebookToken, String googleToken,
			UserProfile userProfile) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.facebookToken = facebookToken;
		this.googleToken = googleToken;
		this.userProfile = userProfile;
	}

	public UserLogin(String email, String password, String facebookToken, String googleToken, UserProfile userProfile) {
		super();
		this.email = email;
		this.password = password;
		this.facebookToken = facebookToken;
		this.googleToken = googleToken;
		this.userProfile = userProfile;
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

	@Override
	public String toString() {
		return "UserLogin [id=" + id + ", email=" + email + ", password=" + password + ", facebookToken="
				+ facebookToken + ", googleToken=" + googleToken + ", userProfile=" + userProfile + "]";
	}
}
