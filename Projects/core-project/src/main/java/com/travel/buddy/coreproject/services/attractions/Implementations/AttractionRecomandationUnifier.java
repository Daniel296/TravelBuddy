package com.travel.buddy.coreproject.services.attractions.Implementations;

import com.travel.buddy.coreproject.DTOs.AttractionDTO;
import com.travel.buddy.coreproject.DTOs.UserDTO;
import com.travel.buddy.coreproject.model.TravelPlanItem;
import com.travel.buddy.coreproject.services.attractions.Interfaces.AttractionRecomandationHelper;

import java.util.ArrayList;
import java.util.List;

public class AttractionRecomandationUnifier implements AttractionRecomandationHelper {

    private UserDTO userDTO;
    private List<AttractionDTO> attractionDTOS;
    private List<AttractionRecomandationHelper> recomandationHelperList;

    public AttractionRecomandationUnifier(UserDTO userDTO){
        this.userDTO = userDTO;
        attractionDTOS = new ArrayList<>();
        recomandationHelperList = new ArrayList<>();
        recomandationHelperList.add(new AttractionRecomandationByOldTravelPlansHelperImpl(userDTO));
        recomandationHelperList.add(new AttractionRecomandationByUserFriendsHelperImpl(userDTO));
        recomandationHelperList.add(new AttractionRecomandationByUserPreferencesHelperImpl());
    }

    private void unify(){
        for(AttractionRecomandationHelper helper : recomandationHelperList){
            for(TravelPlanItem travelPlanItem: helper.getTravelPlanItems()) {
            	//attractionDTOS.add(travelPlanItem.getAttraction());
            	attractionDTOS.add(null);
            }
        }
        //merge attractionDTOS
    }
    
    @Override
    public List<AttractionDTO> getAttractionDTOS(){
        unify();
        return attractionDTOS;
    }

	@Override
	public List<TravelPlanItem> getTravelPlanItems() {
		return null;
	}
}