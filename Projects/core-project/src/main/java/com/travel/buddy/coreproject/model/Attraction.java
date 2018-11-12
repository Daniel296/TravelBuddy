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
@Table(name = "ATTRACTION")
public class Attraction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5067486395552229437L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private long id;

	@Column(name = "ATTRACTION_NAME", unique = true, nullable = false)
	private String attractionName;

	@Column(name = "COORDINATE_LATITUDE", unique = false, nullable = false)
	private double coordinateLatitude;

	@Column(name = "COORDINATE_LONGITUDE", unique = false, nullable = false)
	private double coordinateLongitude;
	
	@Column(name = "DESCRIPTION", unique = false, nullable = true)
	private String description;
	
	@Column(name = "URL", unique = true, nullable = true)
	private String url;
	
	@Column(name = "CODE", unique = true, nullable = false)
	private String code;
	
	@Column(name = "PHOTO_URL", unique = true, nullable = true)
	private String photoUrl;

	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
	@JoinColumn(name = "CITY_ID")
	private City city;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "INTEREST_ID", nullable = false)
	private Interest interest;

	public Attraction() {
		super();
	}

	public Attraction(long id, String attractionName, double coordinateLatitude, double coordinateLongitude,
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

	public Attraction(String attractionName, double coordinateLatitude, double coordinateLongitude, String description,
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
