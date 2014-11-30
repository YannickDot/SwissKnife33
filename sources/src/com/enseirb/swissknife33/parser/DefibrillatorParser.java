package com.enseirb.swissknife33.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.enseirb.swissknife33.dao.model.DefibrillatorDTO;

public class DefibrillatorParser extends AbstractParser<DefibrillatorDTO> {

	public List<DefibrillatorDTO> parse(JSONArray defibrillatorsArray) throws JSONException {
		
		List<DefibrillatorDTO> list = new ArrayList<DefibrillatorDTO>();
		
		for (int i = 0; i < defibrillatorsArray.length(); i++) {
			
			DefibrillatorDTO p = new DefibrillatorDTO();
			JSONObject jsonDefibrillator = defibrillatorsArray.getJSONObject(i);
			
			if (jsonDefibrillator.has("cle"))
				p.setKey(jsonDefibrillator.getString("cle"));
			if (jsonDefibrillator.has("adresse"))
				p.setAddress(jsonDefibrillator.getString("adresse"));
			if (jsonDefibrillator.has("commune"))
				p.setTown(jsonDefibrillator.getString("commune"));
			if (jsonDefibrillator.has("code_postal"))
				p.setZip_code(jsonDefibrillator.getString("code_postal"));
			if (jsonDefibrillator.has("nom"))
				p.setName(jsonDefibrillator.getString("nom"));
			if (jsonDefibrillator.has("telephone"))
				p.setPhone(jsonDefibrillator.getString("telephone"));
			if (jsonDefibrillator.has("typologie"))
				p.setTypology(jsonDefibrillator.getString("typologie"));
			if (jsonDefibrillator.has("installe"))
				p.setInstalled(jsonDefibrillator.getString("installe"));
			if (jsonDefibrillator.has("information"))
				p.setInformation(jsonDefibrillator.getString("information"));
			if (jsonDefibrillator.has("x_long"))
				p.setLongitude(jsonDefibrillator.getString("x_long"));
			if (jsonDefibrillator.has("y_lat"))
				p.setLatitude(jsonDefibrillator.getString("y_lat"));
			
			list.add(p);
		}
		
		return list;
	}
}
