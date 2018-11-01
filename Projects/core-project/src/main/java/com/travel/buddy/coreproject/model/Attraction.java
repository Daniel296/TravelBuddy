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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ATTRACTION")
public class Attraction implements Serializable{
	
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
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CITY_ID", nullable = false)
	private City city;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "ACTIVITY_ID", referencedColumnName = "ACTIVITY_ID", insertable=true, updatable=true)
	private Activity activity;
	
	public Attraction() {
		super();
	}

	public Attraction(long attractionId, String attractionName, double coordinateLatitude, double coordinateLongitude,
			City city, Activity activity) {
		super();
		this.attractionId = attractionId;
		this.attractionName = attractionName;
		this.coordinateLatitude = coordinateLatitude;
		this.coordinateLongitude = coordinateLongitude;
		this.city = city;
		this.activity = activity;
	}

	public Attraction(String attractionName, double coordinateLatitude, double coordinateLongitude, City city,
			Activity activity) {
		super();
		this.attractionName = attractionName;
		this.coordinateLatitude = coordinateLatitude;
		this.coordinateLongitude = coordinateLongitude;
		this.city = city;
		this.activity = activity;
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
}
