package com.enseirb.swissknife33.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.enseirb.swissknife33.dao.model.ParkingDTO;

public class ParkingParser extends AbstractParser<ParkingDTO> {
	
	public List<ParkingDTO> parse(JSONArray parkingsArray) throws JSONException{
		List<ParkingDTO> list = new ArrayList<ParkingDTO>();
		for (int i =0; i<parkingsArray.length();i++){
			ParkingDTO p = new ParkingDTO();
			JSONObject jsonParking = parkingsArray.getJSONObject(i);
			if (jsonParking.has("cle"))
				p.setCle(jsonParking.getString("cle"));
			if (jsonParking.has("domanialite"))
				p.setDomanialite(jsonParking.getString("domanialite"));
			if (jsonParking.has("nature"))
				p.setNature(jsonParking.getString("nature"));
			if (jsonParking.has("nom"))
				p.setNom(jsonParking.getString("nom"));
			if (jsonParking.has("nombre_de_places"))
				p.setNombre_de_places(jsonParking.getString("nombre_de_places"));
			if (jsonParking.has("x_long"))
				p.setX_long(jsonParking.getString("x_long"));
			if (jsonParking.has("y_lat"))
				p.setY_lat(jsonParking.getString("y_lat"));
			list.add(p);
		}
		return list;
	}
}
