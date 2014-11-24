package com.enseirb.swissknife33.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.enseirb.swissknife33.dao.model.ParkingDTO;
import com.enseirb.swissknife33.parser.ParkingParser;

import JSONUtils.*;

public class ParkingDAO extends AbstractDAO<ParkingDTO> {
	
	public ParkingDAO(String url, ParkingParser parser) {
		this.URL = url;
		this.parser = parser;
	}

	public List<ParkingDTO> fetch() throws JSONException{
		JsonParser JSON = new JsonParser();
		JSONObject jsonResult = new JSONObject();
		
		try {
			Log.d("DEBUG", "URL : " + URL);
			jsonResult = JSON.readJsonFromUrl(URL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		JSONArray parkingsArray = jsonResult.getJSONArray("d");
		ParkingParser parser = new ParkingParser();
		List<ParkingDTO> list = parser.parse(parkingsArray);
		
		return list;
	}
}
