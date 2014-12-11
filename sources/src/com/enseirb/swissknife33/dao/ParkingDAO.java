package com.enseirb.swissknife33.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.content.Context;
import com.enseirb.swissknife33.dao.model.ParkingDTO;
import com.enseirb.swissknife33.dao.utils.Connectivity;
import com.enseirb.swissknife33.dao.utils.JsonParser;
import com.enseirb.swissknife33.dao.utils.Storage;
import com.enseirb.swissknife33.exception.Swissknife33Exception;
import com.enseirb.swissknife33.parser.ParkingParser;

public class ParkingDAO extends AbstractDAO<ParkingDTO> {
	
	private String PERSISTENCE_KEY_PARKINGS = "PARKINGS_DATA"; 
	
	public ParkingDAO(String url, ParkingParser parser, Context context) {
		this.URL = url;
		this.parser = parser;
		this.storage = new Storage(context);
		this.connectivity = new Connectivity(context);
	}
	
	public List<ParkingDTO> fetch() throws JSONException, Swissknife33Exception {

		List<ParkingDTO> list = new ArrayList<ParkingDTO>();
		
		if(connectivity.isOnline()){
			list = fetchFromURL();
		} else {
			list = fetchFromCache();
		}
		
		return list;

	}
	
	public List<ParkingDTO> fetchFromCache() throws JSONException, Swissknife33Exception {
		JSONArray jsonDataArray = new JSONArray();
		System.out.println("Fetching parkingsDTO from cache.");
		
		String savedItems = storage.getString(PERSISTENCE_KEY_PARKINGS);
		jsonDataArray = new JSONArray(savedItems);
		
		List<ParkingDTO> list = parser.parse(jsonDataArray);
		return list;
	}

	public List<ParkingDTO> fetchFromURL() throws JSONException, Swissknife33Exception {
		JsonParser JSON = new JsonParser();
		JSONObject jsonResult = new JSONObject();
		System.out.println("Fetching parkingsDTO from URL.");
		
		try {
			jsonResult = JSON.readJsonFromUrl(URL);
		} catch (MalformedURLException e) {
			throw new Swissknife33Exception();
		} catch (IOException e) {
			throw new Swissknife33Exception();
		} catch (JSONException e) {
			throw e;
		}
		
		JSONArray parkingsArray = jsonResult.getJSONArray("d");
		
		updateCache(parkingsArray);
		
		List<ParkingDTO> list = parser.parse(parkingsArray);
		
		return list;
	}

	private void updateCache(JSONArray parkingsArray) {
		storage.setString(PERSISTENCE_KEY_PARKINGS, parkingsArray.toString());
	}
}
