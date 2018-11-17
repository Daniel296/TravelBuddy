package com.travel.buddy.coreproject.DTOs;

import com.travel.buddy.coreproject.model.Interest;
import com.travel.buddy.coreproject.services.matches.Implementations.Point;

public class UserDTO {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    private long id;
    private Point location;
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

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String gender;
    private String genderInterest;
}
