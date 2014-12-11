package com.enseirb.swissknife33.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.enseirb.swissknife33.dao.model.ToiletDTO;

public class ToiletParser extends AbstractParser<ToiletDTO> {
	
	private static final String KEYWORD_KEY = "cle";
	private static final String KEYWORD_ADDRESS = "adresse";
	private static final String KEYWORD_NAME = "nom";
	private static final String KEYWORD_DISTRICT = "quartier";
	private static final String KEYWORD_TYPOLOGY = "typologie";
	private static final String KEYWORD_LONGITUDE = "x_long";
	private static final String KEYWORD_LATITUDE = "y_lat";

	public List<ToiletDTO> parse(JSONArray toiletsArray) throws JSONException {
		
		List<ToiletDTO> list = new ArrayList<ToiletDTO>();
		
		for (int i = 0; i < toiletsArray.length(); i++) {
			
			ToiletDTO p = new ToiletDTO();
			JSONObject jsonToilet = toiletsArray.getJSONObject(i);
			
			if (jsonToilet.has(KEYWORD_KEY))
				p.setKey(jsonToilet.getString(KEYWORD_KEY));
			if (jsonToilet.has(KEYWORD_ADDRESS))
				p.setAddress(jsonToilet.getString(KEYWORD_ADDRESS));	
			if (jsonToilet.has(KEYWORD_NAME))
				p.setName(jsonToilet.getString(KEYWORD_NAME));
			if (jsonToilet.has(KEYWORD_DISTRICT))
				p.setDistrict(jsonToilet.getString(KEYWORD_DISTRICT));
			if (jsonToilet.has(KEYWORD_TYPOLOGY))
				p.setTypology(jsonToilet.getString(KEYWORD_TYPOLOGY));
			if (jsonToilet.has(KEYWORD_LONGITUDE))
				p.setLongitude(jsonToilet.getString(KEYWORD_LONGITUDE));
			if (jsonToilet.has(KEYWORD_LATITUDE))
				p.setLatitude(jsonToilet.getString(KEYWORD_LATITUDE));
			
			list.add(p);
		}
		
		return list;
	}
}
