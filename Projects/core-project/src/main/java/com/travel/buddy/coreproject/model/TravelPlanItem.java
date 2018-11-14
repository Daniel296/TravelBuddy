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
@Table(name = "TRAVEL_PLAN_ITEM")
public class TravelPlanItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3722801903966904134L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRAVEL_PLAN_ITEM_ID", unique = true, nullable = false)
	private long id;
	
	@Column(name  = "START_DATE", unique = false, nullable = false)
	private long startDate;
	
	@Column(name  = "END_DATE", unique = false, nullable = false)
	private long endDate;

	@Column(name  = "ATTRACTION_CODE", unique = false, nullable = false)
	private String attractionCode;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "TRAVEL_PLAN_ID", referencedColumnName = "TRAVEL_PLAN_ID", insertable = true, updatable = true)
	private TravelPlan travelPlan;
	
	public TravelPlanItem() {
		super();
	}

	public TravelPlanItem(long id, long startDate, long endDate, String attractionCode, TravelPlan travelPlan) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.attractionCode = attractionCode;
		this.travelPlan = travelPlan;
	}

	public TravelPlanItem(long startDate, long endDate, String attractionCode, TravelPlan travelPlan) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.attractionCode = attractionCode;
		this.travelPlan = travelPlan;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStartDate() {
		return startDate;
	}

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	public long getEndDate() {
		return endDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}

	public String getAttraction() {
		return attractionCode;
	}

	public void setAttraction(String attractionCode) {
		this.attractionCode = attractionCode;
	}

	public TravelPlan getTravelPlan() {
		return travelPlan;
	}

	public void setTravelPlan(TravelPlan travelPlan) {
		this.travelPlan = travelPlan;
	}
}
