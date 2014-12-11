package com.enseirb.swissknife33.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.enseirb.swissknife33.dao.model.CheckBoxStateDTO;

public class CheckBoxStateParser {
	
	private static final String KEYWORD_STATE = "state";
	private static final String KEYWORD_NAME = "name";

	public List<CheckBoxStateDTO> parse(JSONArray checkBoxStateArray) throws JSONException {
		List<CheckBoxStateDTO> list = new ArrayList<CheckBoxStateDTO>();
		for (int i =0; i < checkBoxStateArray.length(); i++){
			CheckBoxStateDTO p = new CheckBoxStateDTO();
			JSONObject jsonCheckBoxState = checkBoxStateArray.getJSONObject(i);
			if (jsonCheckBoxState.has(KEYWORD_STATE))
				p.setState(jsonCheckBoxState.getString(KEYWORD_STATE));
			if (jsonCheckBoxState.has(KEYWORD_NAME))
				p.setName(jsonCheckBoxState.getString(KEYWORD_NAME));

			list.add(p);
		}
		
		return list;
	}
}
