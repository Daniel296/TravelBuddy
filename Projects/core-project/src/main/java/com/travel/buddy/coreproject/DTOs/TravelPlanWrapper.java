package com.travel.buddy.coreproject.DTOs;

import com.travel.buddy.coreproject.model.TravelPlanItem;

import java.io.Serializable;
import java.util.List;

public class TravelPlanWrapper implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -557811328686659186L;
	
	private String startDate;
    private String endDate;
    private List<TravelPlanItem> travelPlanItems;
    
    
    public TravelPlanWrapper() {
    	super();
    }

    public TravelPlanWrapper(String startDate, String endDate, List<TravelPlanItem> travelPlanItems) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.travelPlanItems = travelPlanItems;
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

    public List<TravelPlanItem> getTravelPlanItems() {
        return travelPlanItems;
    }

    public void setTravelPlanItems(List<TravelPlanItem> travelPlanItems) {
        this.travelPlanItems = travelPlanItems;
    }
}
