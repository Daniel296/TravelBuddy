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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_PROFILE")
public class UserProfile implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 4492648575360971611L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_PROFILE_ID", unique = true, nullable = false)
    private long userProfileId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "GENDER_INTEREST")
    private String genderInterest;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_LOGIN_ID", nullable = false)
    private UserLogin userLogin;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_ID", referencedColumnName = "CITY_ID", insertable=true, updatable=true)
    private City city;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "USER_PROFILE_ID")
    private List<Activity> activities;
    
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "INTEREST_ID", nullable = false)
    private Interest interest;
    
    public UserProfile() {
    	super();
    }


	public UserProfile(long userProfileId, String firstName, String lastName, String phoneNumber, String gender,
			String genderInterest, UserLogin userLogin, City city, List<Activity> activities, Interest interest) {
		super();
		this.userProfileId = userProfileId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.genderInterest = genderInterest;
		this.userLogin = userLogin;
		this.city = city;
		this.activities = activities;
		this.interest = interest;
	}


	public UserProfile(String firstName, String lastName, String phoneNumber, String gender, String genderInterest,
			UserLogin userLogin, City city, List<Activity> activities, Interest interest) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.genderInterest = genderInterest;
		this.userLogin = userLogin;
		this.city = city;
		this.activities = activities;
		this.interest = interest;
	}


	public long getUserProfileId() {
		return userProfileId;
	}


	public void setUserProfileId(long userProfileId) {
		this.userProfileId = userProfileId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getGenderInterest() {
		return genderInterest;
	}


	public void setGenderInterest(String genderInterest) {
		this.genderInterest = genderInterest;
	}


	public UserLogin getUserLogin() {
		return userLogin;
	}


	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}


	public City getCity() {
		return city;
	}


	public void setCity(City city) {
		this.city = city;
	}


	public List<Activity> getActivities() {
		return activities;
	}


	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}


	public Interest getInterest() {
		return interest;
	}


	public void setInterest(Interest interest) {
		this.interest = interest;
	}
}
