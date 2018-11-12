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
import javax.persistence.Table;

@Entity
@Table(name = "TRAVEL_PLAN")
public class TravelPlan implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1203154730314992633L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private long id;
	
	@Column(name = "START_DATE", unique = false, nullable = false)
	private String startDate;
	
	@Column(name = "END_DATE", unique = false, nullable = false)
	private String endDate;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_PROFILE_ID", referencedColumnName = "USER_PROFILE_ID", insertable=true, updatable=true)
	private UserProfile userProfile;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "TRAVEL_PLAN_ITEM_ID")
	private List<TravelPlanItem> travelPlanItems;
	
	public TravelPlan() {
		super();
	}

	public TravelPlan(long id, String startDate, String endDate, UserProfile userProfile,
			List<TravelPlanItem> travelPlanItems) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userProfile = userProfile;
		this.travelPlanItems = travelPlanItems;
	}

	public TravelPlan(String startDate, String endDate, UserProfile userProfile, List<TravelPlanItem> travelPlanItems) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.userProfile = userProfile;
		this.travelPlanItems = travelPlanItems;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public List<TravelPlanItem> getTravelPlanItems() {
		return travelPlanItems;
	}

	public void setTravelPlanItems(List<TravelPlanItem> travelPlanItems) {
		this.travelPlanItems = travelPlanItems;
	}
}
