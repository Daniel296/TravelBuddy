package com.travel.buddy.coreproject.services.attractions.Implementations;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.springframework.beans.factory.annotation.Autowired;

import com.travel.buddy.coreproject.DTOs.AttractionDTO;
import com.travel.buddy.coreproject.model.TravelPlanItem;
import com.travel.buddy.coreproject.repository.AttractionRepository;
import com.travel.buddy.coreproject.services.attractions.Interfaces.AttractionRecomandationHelper;
import com.travel.buddy.coreproject.services.attractions.Interfaces.InterestsScoreComputer;
import com.travel.buddy.coreproject.utils.Constants;
import com.travel.buddy.coreproject.utils.score.ScoreComputerByUserInterestsImpl;

public class AttractionRecomandationByUserPreferencesHelperImpl implements AttractionRecomandationHelper {

    @Autowired
    public AttractionRepository attractionRepository;

    private final String API_KEY = Constants.API_KEY;

    private List<TravelPlanItem> allTravelPlanItems;

    public List<AttractionDTO> getAttractionByUserPreferences(String cityName, List<String> interests) {
        List<AttractionDTO> attractions = new ArrayList<>();

        if(interests == null || interests.size() == 0){
            // if user doesn't choose any interest then return all type of places
            interests = new ArrayList<>();
            interests.add("places");
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
                String name = null;
                double latitude = 0.0;
                double longitude = 0.0;
                String placeId = null;
                String address = null;
                List types = null;
                List<String> photoReferences = null;

                try {
                    JsonObject innerJsonObject = (JsonObject) result;

                    name = innerJsonObject.getString("name");
                    latitude = innerJsonObject.getJsonObject("geometry").getJsonObject("location").getJsonNumber("lat").doubleValue();
                    longitude = innerJsonObject.getJsonObject("geometry").getJsonObject("location").getJsonNumber("lng").doubleValue();
                    placeId = innerJsonObject.getString("place_id");
                    address = innerJsonObject.getString("formatted_address");
                    types = innerJsonObject.getJsonArray("types");

                    photoReferences = new ArrayList<>();
                    List jsonPhotoObjects = innerJsonObject.getJsonArray("photos");
                    for (Object jsonPhotoObject : jsonPhotoObjects) {
                        photoReferences.add(((JsonObject) jsonPhotoObject).getString("photo_reference"));
                    }
                } catch (NullPointerException ignored) { /* ignore current attraction because it doesn't contain all details we need */ }

                attractions.add(new AttractionDTO(name, latitude, longitude, placeId, address, types, photoReferences));
            }
        }

        return attractions;
    }

    public List<TravelPlanItem> getTravelPlanItems(){
        List<TravelPlanItem> travelPlanItems = new ArrayList<>();
        InterestsScoreComputer scoreComputer  = new ScoreComputerByUserInterestsImpl();
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
