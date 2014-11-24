package com.enseirb.swissknife33.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import JSONUtils.JsonParser;

import com.enseirb.swissknife33.dao.model.ParkingDTO;
import com.enseirb.swissknife33.parser.ParkingParser;

public class ParkingDAO extends AbstractDAO<ParkingDTO> {
	
	public ParkingDAO(String url, ParkingParser parser) {
		this.URL = url;
		this.parser = parser;
	}

	@SuppressWarnings("unchecked")
	public List<ParkingDTO> fetch() throws JSONException {
		JsonParser JSON = new JsonParser();
		JSONObject jsonResult = new JSONObject();
		
		try {
			jsonResult = JSON.readJsonFromUrl(URL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		JSONArray parkingsArray = jsonResult.getJSONArray("d");
//		ParkingParser parser = new ParkingParser();
		List<ParkingDTO> list = (List<ParkingDTO>) parser.parse(parkingsArray);
		
		return list;
	}
}
