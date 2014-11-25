package com.enseirb.swissknife33.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.enseirb.swissknife33.dao.model.PersonalItemDTO;

public class PersonalItemParser extends AbstractParser<PersonalItemDTO> {
	
	public List<PersonalItemDTO> parse(JSONArray personalItemArray) throws JSONException {
		List<PersonalItemDTO> list = new ArrayList<PersonalItemDTO>();
		for (int i =0; i < personalItemArray.length(); i++){
			PersonalItemDTO p = new PersonalItemDTO();
			JSONObject jsonPersonalItem = personalItemArray.getJSONObject(i);
			if (jsonPersonalItem.has("key"))
				p.setKey(jsonPersonalItem.getString("key"));
			if (jsonPersonalItem.has("name"))
				p.setName(jsonPersonalItem.getString("name"));
			if (jsonPersonalItem.has("x_long"))
				p.setX_long(jsonPersonalItem.getString("x_long"));
			if (jsonPersonalItem.has("y_lat"))
				p.setY_lat(jsonPersonalItem.getString("y_lat"));
			list.add(p);
		}
		
		return list;
	}
	
}
