package com.enseirb.swissknife33.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.enseirb.swissknife33.dao.model.CheckBoxStateDTO;

public class CheckBoxStateParser {
	public List<CheckBoxStateDTO> parse(JSONArray checkBoxStateArray) throws JSONException {
		List<CheckBoxStateDTO> list = new ArrayList<CheckBoxStateDTO>();
		for (int i =0; i < checkBoxStateArray.length(); i++){
			CheckBoxStateDTO p = new CheckBoxStateDTO();
			JSONObject jsonCheckBoxState = checkBoxStateArray.getJSONObject(i);
			if (jsonCheckBoxState.has("state"))
				p.setState(jsonCheckBoxState.getString("state"));
			if (jsonCheckBoxState.has("name"))
				p.setName(jsonCheckBoxState.getString("name"));

			list.add(p);
		}
		
		return list;
	}
}
