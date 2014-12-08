package com.enseirb.swissknife33.dao;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import com.enseirb.swissknife33.dao.model.CheckBoxStateDTO;
import com.enseirb.swissknife33.dao.utils.Storage;
import com.enseirb.swissknife33.parser.CheckBoxStateParser;

public class CheckBoxStateDAO {
	private static final String NAME = "name";
	private static final String STATE = "state";
	
	private final Context context;
    private final CheckBoxStateParser parser;
	
	private String PERSISTENCE_KEY_CHECKBOX_STATE = "CHECKBOX_STATE_DATA";
	private Storage storage;
	
	public CheckBoxStateDAO(CheckBoxStateParser parser, Context context) {
        this.context = context;
        this.parser = parser;
        this.storage = new Storage(context);
    }
	
	public List<CheckBoxStateDTO> fetch() throws JSONException{
		JSONArray jsonDataArray = new JSONArray();
		
		String savedItems = storage.getString(PERSISTENCE_KEY_CHECKBOX_STATE);
		jsonDataArray = new JSONArray(savedItems);
		
		List<CheckBoxStateDTO> list = new ArrayList<CheckBoxStateDTO>();
		list = parser.parse(jsonDataArray);
		return list;
		
	}
	
	public int save(List<CheckBoxStateDTO> list) throws JSONException{
		storage.setString(PERSISTENCE_KEY_CHECKBOX_STATE, toJSONText(list));
		return 0;
	}
	
	public void clear() {
		storage.remove(PERSISTENCE_KEY_CHECKBOX_STATE);
	}
	
	private String toJSONText(List<CheckBoxStateDTO> list) throws JSONException{
		JSONArray checkBoxStateDTO_JSONArray = new JSONArray();
		
		for (CheckBoxStateDTO p : list){
			JSONObject checkBoxStateDTO_JSON = new JSONObject();
			checkBoxStateDTO_JSON
			.put(STATE, p.getState())
			.put(NAME, p.getName());
			
			checkBoxStateDTO_JSONArray.put(checkBoxStateDTO_JSON);
		}
			
		return checkBoxStateDTO_JSONArray.toString();
	}
	
	private JSONArray fromJSONText(String jsonArrayText) throws JSONException{
		JSONArray jsonArray = new JSONArray(jsonArrayText);
		
		return jsonArray;
	}

	public Context getContext() {
		return context;
	}

}
