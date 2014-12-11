package com.enseirb.swissknife33.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.enseirb.swissknife33.dao.model.DefibrillatorDTO;

public class DefibrillatorParser extends AbstractParser<DefibrillatorDTO> {

	private static final String KEYWORD_KEY = "cle";
	private static final String KEYWORD_ADDRESS = "adresse";
	private static final String KEYWORD_CITY = "commune";
	private static final String KEYWORD_ZIP_CODE = "code_postal";
	private static final String KEYWORD_NAME = "nom";
	private static final String KEYWORD_PHONE = "telephone";
	private static final String KEYWORD_TYPOLOGY = "typologie";
	private static final String KEYWORD_INSTALLED = "installe";
	private static final String INFORMATION = "information";
	private static final String KEYWORD_LONGITUDE = "x_long";
	private static final String KEYWORD_LATITUDE = "y_lat";

	public List<DefibrillatorDTO> parse(JSONArray defibrillatorsArray) throws JSONException {
		
		List<DefibrillatorDTO> list = new ArrayList<DefibrillatorDTO>();
		
		for (int i = 0; i < defibrillatorsArray.length(); i++) {
			
			DefibrillatorDTO p = new DefibrillatorDTO();
			JSONObject jsonDefibrillator = defibrillatorsArray.getJSONObject(i);
			
			if (jsonDefibrillator.has(KEYWORD_KEY))
				p.setKey(jsonDefibrillator.getString(KEYWORD_KEY));
			if (jsonDefibrillator.has(KEYWORD_ADDRESS))
				p.setAddress(jsonDefibrillator.getString(KEYWORD_ADDRESS));
			if (jsonDefibrillator.has(KEYWORD_CITY))
				p.setTown(jsonDefibrillator.getString(KEYWORD_CITY));
			if (jsonDefibrillator.has(KEYWORD_ZIP_CODE))
				p.setZip_code(jsonDefibrillator.getString(KEYWORD_ZIP_CODE));
			if (jsonDefibrillator.has(KEYWORD_NAME))
				p.setName(jsonDefibrillator.getString(KEYWORD_NAME));
			if (jsonDefibrillator.has(KEYWORD_PHONE))
				p.setPhone(jsonDefibrillator.getString(KEYWORD_PHONE));
			if (jsonDefibrillator.has(KEYWORD_TYPOLOGY))
				p.setTypology(jsonDefibrillator.getString(KEYWORD_TYPOLOGY));
			if (jsonDefibrillator.has(KEYWORD_INSTALLED))
				p.setInstalled(jsonDefibrillator.getString(KEYWORD_INSTALLED));
			if (jsonDefibrillator.has(INFORMATION))
				p.setInformation(jsonDefibrillator.getString(INFORMATION));
			if (jsonDefibrillator.has(KEYWORD_LONGITUDE))
				p.setLongitude(jsonDefibrillator.getString(KEYWORD_LONGITUDE));
			if (jsonDefibrillator.has(KEYWORD_LATITUDE))
				p.setLatitude(jsonDefibrillator.getString(KEYWORD_LATITUDE));
			
			list.add(p);
		}
		
		return list;
	}
}
