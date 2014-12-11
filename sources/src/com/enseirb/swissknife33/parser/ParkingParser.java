package com.enseirb.swissknife33.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.enseirb.swissknife33.dao.model.ParkingDTO;

public class ParkingParser extends AbstractParser<ParkingDTO> {
	
	private static final String KEYWORD_KEY = "cle";
	private static final String KEYWORD_DOMANIALITY = "domanialite";
	private static final String KEYWORD_NATURE = "nature";
	private static final String KEYWORD_NAME = "nom";
	private static final String KEYWORD_NUMBER_OF_SPACE = "nombre_de_places";
	private static final String KEYWORD_LONGITUDE = "x_long";
	private static final String KEYWORD_LATITUDE = "y_lat";

	public List<ParkingDTO> parse(JSONArray parkingsArray) throws JSONException {
		
		List<ParkingDTO> list = new ArrayList<ParkingDTO>();
		
		for (int i = 0; i < parkingsArray.length(); i++) {
			
			ParkingDTO p = new ParkingDTO();
			JSONObject jsonParking = parkingsArray.getJSONObject(i);
			
			if (jsonParking.has(KEYWORD_KEY))
				p.setKey(jsonParking.getString(KEYWORD_KEY));
			if (jsonParking.has(KEYWORD_DOMANIALITY))
				p.setDomaniality(jsonParking.getString(KEYWORD_DOMANIALITY));
			if (jsonParking.has(KEYWORD_NATURE))
				p.setNature(jsonParking.getString(KEYWORD_NATURE));
			if (jsonParking.has(KEYWORD_NAME))
				p.setName(jsonParking.getString(KEYWORD_NAME));
			if (jsonParking.has(KEYWORD_NUMBER_OF_SPACE))
				p.setNumberOfSpace(jsonParking.getString(KEYWORD_NUMBER_OF_SPACE));
			if (jsonParking.has(KEYWORD_LONGITUDE))
				p.setLongitude(jsonParking.getString(KEYWORD_LONGITUDE));
			if (jsonParking.has(KEYWORD_LATITUDE))
				p.setLatitude(jsonParking.getString(KEYWORD_LATITUDE));
			
			list.add(p);
		}
		
		return list;
	}
}
