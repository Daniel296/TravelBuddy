package com.travel.buddy.coreproject.DTOs;

import com.travel.buddy.coreproject.model.City;
import com.travel.buddy.coreproject.model.Interest;

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

public class AttractionDTO {

	/**
	 * 
	 */
	private long id;

	private String attractionName;

	private double coordinateLatitude;

	private double coordinateLongitude;

	private String description;

	private String url;

	private String code;

	private String photoUrl;

	private City city;

	private Interest interest;

	public AttractionDTO() {
		super();
	}

	public AttractionDTO(long id, String attractionName, double coordinateLatitude, double coordinateLongitude,
						 String description, String url, String code, String photoUrl, City city, Interest interest) {
		super();
		this.id = id;
		this.attractionName = attractionName;
		this.coordinateLatitude = coordinateLatitude;
		this.coordinateLongitude = coordinateLongitude;
		this.description = description;
		this.url = url;
		this.code = code;
		this.photoUrl = photoUrl;
		this.city = city;
		this.interest = interest;
	}

	public AttractionDTO(String attractionName, double coordinateLatitude, double coordinateLongitude, String description,
						 String url, String code, String photoUrl, City city, Interest interest) {
		super();
		this.attractionName = attractionName;
		this.coordinateLatitude = coordinateLatitude;
		this.coordinateLongitude = coordinateLongitude;
		this.description = description;
		this.url = url;
		this.code = code;
		this.photoUrl = photoUrl;
		this.city = city;
		this.interest = interest;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAttractionName() {
		return attractionName;
	}

	public void setAttractionName(String attractionName) {
		this.attractionName = attractionName;
	}

	public double getCoordinateLatitude() {
		return coordinateLatitude;
	}

	public void setCoordinateLatitude(double coordinateLatitude) {
		this.coordinateLatitude = coordinateLatitude;
	}

	public double getCoordinateLongitude() {
		return coordinateLongitude;
	}

	public void setCoordinateLongitude(double coordinateLongitude) {
		this.coordinateLongitude = coordinateLongitude;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Interest getInterest() {
		return interest;
	}

	public void setInterest(Interest interest) {
		this.interest = interest;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
}
