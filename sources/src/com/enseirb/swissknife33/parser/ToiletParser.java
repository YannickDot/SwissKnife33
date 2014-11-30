package com.enseirb.swissknife33.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.enseirb.swissknife33.dao.model.ToiletDTO;

public class ToiletParser extends AbstractParser<ToiletDTO> {
	public List<ToiletDTO> parse(JSONArray toiletsArray) throws JSONException {
		
		List<ToiletDTO> list = new ArrayList<ToiletDTO>();
		
		for (int i = 0; i < toiletsArray.length(); i++) {
			
			ToiletDTO p = new ToiletDTO();
			JSONObject jsonToilet = toiletsArray.getJSONObject(i);
			
			if (jsonToilet.has("cle"))
				p.setKey(jsonToilet.getString("cle"));
			if (jsonToilet.has("adresse"))
				p.setAddress(jsonToilet.getString("adresse"));	
			if (jsonToilet.has("nom"))
				p.setName(jsonToilet.getString("nom"));
			if (jsonToilet.has("quartier"))
				p.setNeighborhood(jsonToilet.getString("quartier"));
			if (jsonToilet.has("typologie"))
				p.setTypology(jsonToilet.getString("typologie"));
			if (jsonToilet.has("x_long"))
				p.setLongitude(jsonToilet.getString("x_long"));
			if (jsonToilet.has("y_lat"))
				p.setLatitude(jsonToilet.getString("y_lat"));
			
			list.add(p);
		}
		
		return list;
	}
}
