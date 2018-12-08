package com.travel.buddy.coreproject.DTOs;

import com.travel.buddy.coreproject.model.TravelPlanItem;

import java.util.List;

public class TravelPlanWrapper {
    private String startDate;
    private String endDate;
    private List<TravelPlanItem> travelPlanItems;

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
