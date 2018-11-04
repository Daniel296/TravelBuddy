package com.travel.buddy.coreproject.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.travel.buddy.coreproject.model.Country;
import java.util.ArrayList;
import java.util.List;



public class CountryHelper extends  JsonHelper {
    public List<Country> retrieveCountries() throws JSONException {
        List<Country> countries = new ArrayList<>();
        JSONObject obj = new JSONObject(json);

        JSONArray arr = obj.getJSONArray("countries");
        for (int i = 0; i < arr.length(); i++)
        {
            Country country = new Country();
            String countryName = arr.getJSONObject(i).getString("Name");
            String code = arr.getJSONObject(i).getString("Code");
            country.setName(countryName);
            country.setCountryCode(code);
            countries.add(country);
        }
        return countries;

    }


}
