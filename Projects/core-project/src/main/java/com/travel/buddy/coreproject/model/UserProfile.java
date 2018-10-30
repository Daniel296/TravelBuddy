package com.travel.buddy.coreproject.model;

import java.io.Serializable;
import java.util.List;
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_LOGIN_ID")
    private UserLogin userLogin;

    @ManyToOne
    @JoinColumn(name = "CITY_ID", nullable = false)
    private City city;

    @Column(name = "ACTIVITIES")
    @OneToMany(mappedBy = "userProfile")
    private List<Activity> activities;

    public UserProfile(String firstName, String lastName, String phoneNumber, String gender, String genderInterest,
        UserLogin userLogin, City city, List<Activity> activities) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.genderInterest = genderInterest;
        this.userLogin = userLogin;
        this.city = city;
        this.activities = activities;
    }

    public UserProfile(long userProfileId, String firstName, String lastName, String phoneNumber, String gender, String genderInterest,
        UserLogin userLogin, City city, List<Activity> activities) {
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
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setGenderInterest(String genderInterest) {
        this.genderInterest = genderInterest;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getGenderInterest() {
        return genderInterest;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public City getCity() {
        return city;
    }

    public List<Activity> getActivities() {
        return activities;
    }
}
