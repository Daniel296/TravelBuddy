package com.travel.buddy.coreproject.services.attractions.Implementations;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.travel.buddy.coreproject.DTOs.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

import com.travel.buddy.coreproject.DTOs.AttractionDTO;
import com.travel.buddy.coreproject.model.Interest;
import com.travel.buddy.coreproject.model.TravelPlanItem;
import com.travel.buddy.coreproject.repository.AttractionRepository;
import com.travel.buddy.coreproject.services.attractions.Interfaces.AttractionRecomandationHelper;
import com.travel.buddy.coreproject.services.attractions.Interfaces.InterestsScoreComputer;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import static java.lang.System.out;

public class AttractionRecomandationByUserPreferencesHelperImpl implements AttractionRecomandationHelper {

    @Autowired
    public AttractionRepository attractionRepository;

    private final String API_KEY = "AIzaSyAvEehceQnGa0DWPp6vWvzDOIXOjXEcf1g";

    private List<TravelPlanItem> allTravelPlanItems;
    private UserDTO userDTO;

    public AttractionRecomandationByUserPreferencesHelperImpl(UserDTO userDTO){
        this.userDTO = userDTO;
    }

    public List<AttractionDTO> getAttractionByUserPreferences(String cityName, List<String> interests) {
        List<AttractionDTO> attractions = new ArrayList<>();

        if(interests == null || interests.size() == 0){
            // here we need a default list of attractions


            //return
        }

        for(String interest : interests) {
            String json = getJSONResponse(cityName, interest);
            if(json == null) {
                return attractions;
            }

            JsonReader jsonReader = Json.createReader(new StringReader(json));
            JsonObject jsonObject = jsonReader.readObject();

            jsonReader.close();

            List results = jsonObject.getJsonArray("results");

            for (Object result : results) {
                JsonObject innerJsonObject = (JsonObject) result;

                String name = innerJsonObject.getString("name");
                double latitude = innerJsonObject.getJsonObject("geometry").getJsonObject("location").getJsonNumber("lat").doubleValue();
                double longitude = innerJsonObject.getJsonObject("geometry").getJsonObject("location").getJsonNumber("lng").doubleValue();
                String placeId = innerJsonObject.getString("id");
                String address = innerJsonObject.getString("formatted_address");
                List types = innerJsonObject.getJsonArray("types");
                List<String> photoReferences = new ArrayList<>();

                List jsonPhotoObjects = innerJsonObject.getJsonArray("photos");
                for (Object jsonPhotoObject : jsonPhotoObjects) {
                    photoReferences.add(((JsonObject) jsonPhotoObject).getString("photo_reference"));
                }

                //AttractionDTO attractionDTO = new AttractionDTO(name, latitude, longitude, placeId, address, types, photoReferences);
                attractions.add(new AttractionDTO(name, latitude, longitude, placeId, address, types, photoReferences));
            }
        }

        return attractions;
    }

    public List<TravelPlanItem> getTravelPlanItems(){
        List<TravelPlanItem> travelPlanItems = new ArrayList<>();
        InterestsScoreComputer scoreComputer  = new InterestScoreComputerImpl();
        //allAttractions = attractionRepository.findAll();
        //Interest userInterests = userDTO.getInterest();

        return travelPlanItems;
    }

    public List<TravelPlanItem> getAllTravelPlanItems() {
        return allTravelPlanItems;
    }

    public void setAllTravelPlanItems(List<TravelPlanItem> allTravelPlanItems) {
        this.allTravelPlanItems = allTravelPlanItems;
    }

	@Override
	public List<AttractionDTO> getAttractionDTOS() {
		return null;
	}

    private String getJSONResponse(String cityName, String interest) {
        HttpURLConnection connection = null;

        try {
            StringBuilder urlBuilder = new StringBuilder("https://maps.googleapis.com/maps/api/place/textsearch/json?");
            urlBuilder.append("query=").append(interest).append("+in+").append(cityName);
            urlBuilder.append("&").append("key=").append(API_KEY);

            out.println(urlBuilder.toString());

            URL url = new URL(urlBuilder.toString());
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            connection.connect();

            StringBuilder responseBuilder = new StringBuilder();
            if(connection.getResponseCode() == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = br.readLine()) != null) {
                    responseBuilder.append(line).append("\n");
                }
                br.close();
                System.out.println(responseBuilder.toString());
            }

            return responseBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
        }

        return null;
    }
}