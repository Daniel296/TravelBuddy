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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "USER_PROFILE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserProfile implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 4492648575360971611L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_PROFILE_ID", unique = true, nullable = false)
    private long id;

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

	@Column(name = "LAST_LNG")
	private double lastLNG;

	@Column(name = "LAST_LAT")
	private double lastLAT;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_LOGIN_ID", nullable = false)
    @JsonBackReference
    private UserLogin userLogin;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_ID", referencedColumnName = "CITY_ID", insertable=true, updatable=true)
    @JsonManagedReference
    private City city;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "USER_PROFILE_ID")
    @JsonManagedReference
    private List<TravelPlan> travelPlans;
    
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "INTEREST_ID", nullable = false)
    @JsonManagedReference
    private Interest interest;
    
    
    public UserProfile() {
    	super();
    }

	public UserProfile(long id, String firstName, String lastName, String phoneNumber, String gender,
			String genderInterest, UserLogin userLogin, City city, List<TravelPlan> travelPlans, Interest interest) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.genderInterest = genderInterest;
		this.userLogin = userLogin;
		this.city = city;
		this.travelPlans = travelPlans;
		this.interest = interest;
	}

	public UserProfile(String firstName, String lastName, String phoneNumber, String gender, String genderInterest,
			UserLogin userLogin, City city, List<TravelPlan> travelPlans, Interest interest) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.genderInterest = genderInterest;
		this.userLogin = userLogin;
		this.city = city;
		this.travelPlans = travelPlans;
		this.interest = interest;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<TravelPlan> getTravelPlans() {
		return travelPlans;
	}

	public void setTravelPlans(List<TravelPlan> travelPlans) {
		this.travelPlans = travelPlans;
	}

	public Interest getInterest() {
		return interest;
	}

	public void setInterest(Interest interest) {
		this.interest = interest;
	}

	public double getLastLNG() {
		return lastLNG;
	}

	public void setLastLNG(double lastLNG) {
		this.lastLNG = lastLNG;
	}

	public double getLastLAT() {
		return lastLAT;
	}

	public void setLastLAT(double lastLAT) {
		this.lastLAT = lastLAT;
	}
}
