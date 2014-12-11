package com.enseirb.swissknife33.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.enseirb.swissknife33.dao.model.PersonalItemDTO;

public class PersonalItemParser extends AbstractParser<PersonalItemDTO> {
	
	private static final String KEYWORD_KEY = "key";
	private static final String KEYWORD_NAME = "name";
	private static final String KEYWORD_LONGITUDE = "x_long";
	private static final String KEYWORD_LATITUDE = "y_lat";

	public List<PersonalItemDTO> parse(JSONArray personalItemArray) throws JSONException {
		List<PersonalItemDTO> list = new ArrayList<PersonalItemDTO>();
		for (int i =0; i < personalItemArray.length(); i++){
			PersonalItemDTO p = new PersonalItemDTO();
			JSONObject jsonPersonalItem = personalItemArray.getJSONObject(i);
			if (jsonPersonalItem.has(KEYWORD_KEY))
				p.setKey(jsonPersonalItem.getString(KEYWORD_KEY));
			if (jsonPersonalItem.has(KEYWORD_NAME))
				p.setName(jsonPersonalItem.getString(KEYWORD_NAME));
			if (jsonPersonalItem.has(KEYWORD_LONGITUDE))
				p.setLongitude(jsonPersonalItem.getString(KEYWORD_LONGITUDE));
			if (jsonPersonalItem.has(KEYWORD_LATITUDE))
				p.setLatitude(jsonPersonalItem.getString(KEYWORD_LATITUDE));
			list.add(p);
		}
		
		return list;
	}
	
}
