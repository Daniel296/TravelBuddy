package com.travel.buddy.coreproject.utils;

import com.travel.buddy.coreproject.model.City;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CitiesHelper extends  JsonHelper {
    public List<City> retrieveCities() throws JSONException {
        List<City> cities = new ArrayList<>();
        JSONObject obj = new JSONObject(json);

        JSONArray arr = obj.getJSONArray("cities");
        for (int i = 0; i < arr.length(); i++)
        {
            City city = new City();
            String cityName = arr.getJSONObject(i).getString("name");
            city.setName(cityName);
            cities.add(city);
        }
        return cities;

    }
}
