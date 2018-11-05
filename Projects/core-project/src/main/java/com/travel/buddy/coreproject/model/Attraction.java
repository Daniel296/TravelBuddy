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
@Table(name = "ATTRACTION")
public class Attraction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5067486395552229437L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ATTRACTION_ID", unique = true, nullable = false)
	private long attractionId;

	@Column(name = "ATTRACTION_NAME", unique = true, nullable = false)
	private String attractionName;

	@Column(name = "COORDINATE_LATITUDE", unique = false, nullable = false)
	private double coordinateLatitude;

	@Column(name = "COORDINATE_LONGITUDE", unique = false, nullable = false)
	private double coordinateLongitude;

	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
	@JoinColumn(name = "CITY_ID")
	private City city;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "ACTIVITY_ID", referencedColumnName = "ACTIVITY_ID", insertable = true, updatable = true)
	private Activity activity;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "INTEREST_ID", nullable = false)
	private Interest interest;

	public Attraction() {
		super();
	}

	public Attraction(long attractionId, String attractionName, double coordinateLatitude, double coordinateLongitude,
			City city, Activity activity, Interest interest) {
		super();
		this.attractionId = attractionId;
		this.attractionName = attractionName;
		this.coordinateLatitude = coordinateLatitude;
		this.coordinateLongitude = coordinateLongitude;
		this.city = city;
		this.activity = activity;
		this.interest = interest;
	}

	public Attraction(String attractionName, double coordinateLatitude, double coordinateLongitude, City city,
			Activity activity, Interest interest) {
		super();
		this.attractionName = attractionName;
		this.coordinateLatitude = coordinateLatitude;
		this.coordinateLongitude = coordinateLongitude;
		this.city = city;
		this.activity = activity;
		this.interest = interest;
	}

	public long getAttractionId() {
		return attractionId;
	}

	public void setAttractionId(long attractionId) {
		this.attractionId = attractionId;
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

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Interest getInterest() {
		return interest;
	}

	public void setInterest(Interest interest) {
		this.interest = interest;
	}
}
