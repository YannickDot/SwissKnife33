package com.enseirb.swissknife33.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import JSONUtils.JsonParser;

import com.enseirb.swissknife33.dao.model.ParkingDTO;
import com.enseirb.swissknife33.exception.Swissknife33Exception;
import com.enseirb.swissknife33.parser.ParkingParser;

public class ParkingDAO extends AbstractDAO<ParkingDTO> {
	
	public ParkingDAO(String url, ParkingParser parser) {
		this.URL = url;
		this.parser = parser;
	}

	public List<ParkingDTO> fetch() throws JSONException, Swissknife33Exception {
		JsonParser JSON = new JsonParser();
		JSONObject jsonResult = new JSONObject();
		
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
		List<ParkingDTO> list = parser.parse(parkingsArray);
		
		return list;
	}
}
