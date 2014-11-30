package com.enseirb.swissknife33.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.enseirb.swissknife33.dao.model.NestDTO;

public class NestParser extends AbstractParser<NestDTO> {
	public List<NestDTO> parse(JSONArray nestsArray) throws JSONException {
		
		List<NestDTO> list = new ArrayList<NestDTO>();
		
		for (int i = 0; i < nestsArray.length(); i++) {
			
			NestDTO p = new NestDTO();
			JSONObject jsonNest = nestsArray.getJSONObject(i);
			
			if (jsonNest.has("cle"))
				p.setKey(jsonNest.getString("cle"));
			if (jsonNest.has("nature_abris"))
				p.setShelter_type(jsonNest.getString("nature_abris"));
			if (jsonNest.has("detail_espece_visee"))
				p.setTargeted_species(jsonNest.getString("detail_espece_visee"));
			if (jsonNest.has("nom"))
				p.setName(jsonNest.getString("nom"));
			if (jsonNest.has("x_long"))
				p.setLongitude(jsonNest.getString("x_long"));
			if (jsonNest.has("y_lat"))
				p.setLatitude(jsonNest.getString("y_lat"));
			
			list.add(p);
		}
		
		return list;
	}
}
