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
	private long travelPlanItemId;
	
	@Column(name  = "START_DATE", unique = false, nullable = false)
	private String startDate;
	
	@Column(name  = "END_DATE", unique = false, nullable = false)
	private String endDate;
	
	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
	@JoinColumn(name = "ATTRACTION_ID")
	private Attraction attraction;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "ACTIVITY_ID", referencedColumnName = "ACTIVITY_ID", insertable = true, updatable = true)
	private Activity activity;
	
	public TravelPlanItem() {
		super();
	}

	public TravelPlanItem(long travelPlanItemId, String startDate, String endDate, Attraction attraction,
			Activity activity) {
		super();
		this.travelPlanItemId = travelPlanItemId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.attraction = attraction;
		this.activity = activity;
	}

	public TravelPlanItem(String startDate, String endDate, Attraction attraction, Activity activity) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.attraction = attraction;
		this.activity = activity;
	}

	public long getTravelPlanItemId() {
		return travelPlanItemId;
	}

	public void setTravelPlanItemId(long travelPlanItemId) {
		this.travelPlanItemId = travelPlanItemId;
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

	public Attraction getAttraction() {
		return attraction;
	}

	public void setAttraction(Attraction attraction) {
		this.attraction = attraction;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
}
