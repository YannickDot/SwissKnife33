package com.enseirb.swissknife33.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.enseirb.swissknife33.dao.model.NestDTO;

public class NestParser extends AbstractParser<NestDTO> {
	
	private static final String KEYWORD_KEY = "cle";
	private static final String KEYWORD_NATURE = "nature_abris";
	private static final String KEYWORD_SPECIES_DETAIL = "detail_espece_visee";
	private static final String KEYWORD_NAME = "nom";
	private static final String KEYWORD_LONGITUDE = "x_long";
	private static final String KEYWORD_LATITUDE = "y_lat";
	
	public List<NestDTO> parse(JSONArray nestsArray) throws JSONException {
		
		List<NestDTO> list = new ArrayList<NestDTO>();
		
		for (int i = 0; i < nestsArray.length(); i++) {
			
			NestDTO p = new NestDTO();
			JSONObject jsonNest = nestsArray.getJSONObject(i);
			
			if (jsonNest.has(KEYWORD_KEY))
				p.setKey(jsonNest.getString(KEYWORD_KEY));
			if (jsonNest.has(KEYWORD_NATURE))
				p.setShelter_type(jsonNest.getString(KEYWORD_NATURE));
			if (jsonNest.has(KEYWORD_SPECIES_DETAIL))
				p.setTargeted_species(jsonNest.getString(KEYWORD_SPECIES_DETAIL));
			if (jsonNest.has(KEYWORD_NAME))
				p.setName(jsonNest.getString(KEYWORD_NAME));
			if (jsonNest.has(KEYWORD_LONGITUDE))
				p.setLongitude(jsonNest.getString(KEYWORD_LONGITUDE));
			if (jsonNest.has(KEYWORD_LATITUDE))
				p.setLatitude(jsonNest.getString(KEYWORD_LATITUDE));
			
			list.add(p);
		}
		
		return list;
	}
}
