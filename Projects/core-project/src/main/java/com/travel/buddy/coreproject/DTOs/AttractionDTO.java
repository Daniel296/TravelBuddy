package com.travel.buddy.coreproject.DTOs;

import com.travel.buddy.coreproject.model.City;
import com.travel.buddy.coreproject.model.Interest;

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
	private String placeId;
	private String address;
	private List<String> interests;
	private List<String> photoReferences;

	public AttractionDTO() {
		super();
	}

	public AttractionDTO(long id, String attractionName, double coordinateLatitude, double coordinateLongitude, String placeId, String address, List<String> interests, List<String> photoReferences) {
		this.id = id;
		this.attractionName = attractionName;
		this.coordinateLatitude = coordinateLatitude;
		this.coordinateLongitude = coordinateLongitude;
		this.placeId = placeId;
		this.address = address;
		this.interests = interests;
		this.photoReferences = photoReferences;
	}

	public AttractionDTO(String attractionName, double coordinateLatitude, double coordinateLongitude, String placeId, String address, List<String> interests, List<String> photoReferences) {
		this.attractionName = attractionName;
		this.coordinateLatitude = coordinateLatitude;
		this.coordinateLongitude = coordinateLongitude;
		this.placeId = placeId;
		this.address = address;
		this.interests = interests;
		this.photoReferences = photoReferences;
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

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getInterests() {
		return interests;
	}

	public void setInterests(List<String> interests) {
		this.interests = interests;
	}

	public List<String> getPhotoReferences() {
		return photoReferences;
	}

	public void setPhotoReferences(List<String> photoReferences) {
		this.photoReferences = photoReferences;
	}
}
