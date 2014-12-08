package com.enseirb.swissknife33.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.enseirb.swissknife33.dao.model.DefibrillatorDTO;
import com.enseirb.swissknife33.dao.utils.Connectivity;
import com.enseirb.swissknife33.dao.utils.JsonParser;
import com.enseirb.swissknife33.dao.utils.Storage;
import com.enseirb.swissknife33.exception.Swissknife33Exception;
import com.enseirb.swissknife33.parser.DefibrillatorParser;

public class DefibrillatorDAO extends AbstractDAO<DefibrillatorDTO> {
	
	private String PERSISTENCE_KEY_DEFIBRILATORS = "DEFRIBRILATOR_DATA";
	
	public DefibrillatorDAO(String url, DefibrillatorParser parser, Context context) {
		this.URL = url;
		this.parser = parser;
		this.storage = new Storage(context);
		this.connectivity = new Connectivity(context);
	}
	
	public List<DefibrillatorDTO> fetch() throws JSONException, Swissknife33Exception {
		
		List<DefibrillatorDTO> list = new ArrayList<DefibrillatorDTO>();
		
		if(connectivity.isOnline()){
			list = fetchFromURL();
		} else {
			list = fetchFromCache();
		}
		
		return list;
	}
	
	public List<DefibrillatorDTO> fetchFromCache() throws JSONException, Swissknife33Exception {
		JSONArray jsonDataArray = new JSONArray();
		System.out.println("Fetching defibrillatorsDTO from cache.");
		
		String savedItems = storage.getString(PERSISTENCE_KEY_DEFIBRILATORS);
		jsonDataArray = new JSONArray(savedItems);
		
		List<DefibrillatorDTO> list = parser.parse(jsonDataArray);
		return list;
	}

	public List<DefibrillatorDTO> fetchFromURL() throws JSONException, Swissknife33Exception {
		JsonParser JSON = new JsonParser();
		JSONObject jsonResult = new JSONObject();
		System.out.println("Fetching defibrillatorsDTO from URL.");
		
		try {
			jsonResult = JSON.readJsonFromUrl(URL);
		} catch (MalformedURLException e) {
			throw new Swissknife33Exception();
		} catch (IOException e) {
			throw new Swissknife33Exception();
		} catch (JSONException e) {
			throw e;
		}
		
		JSONArray defibrilatorsArray = jsonResult.getJSONArray("d");
		
		//update Cache
		storage.setString(PERSISTENCE_KEY_DEFIBRILATORS, defibrilatorsArray.toString());
		
		List<DefibrillatorDTO> list = parser.parse(defibrilatorsArray);
		
		return list;
	}
}
