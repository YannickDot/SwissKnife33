package com.enseirb.swissknife33.dao;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.enseirb.swissknife33.dao.model.PersonalItemDTO;
import com.enseirb.swissknife33.dao.utils.Storage;
import com.enseirb.swissknife33.parser.PersonalItemParser;

public class PersonalItemDAO {
	
	private static final String LATITUDE = "y_lat";
	private static final String LONGITUDE = "x_long";
	private static final String NAME = "name";
	private static final String KEY = "key";
	
	private final Context context;
    private final PersonalItemParser parser;
	
	private String PERSISTENCE_KEY_PERSONAL_ITEM = "PERSONAL_ITEM_DATA";
	private String EMPTY_JSONARRAY_STR = "[]";
	private Storage storage;
	
	public PersonalItemDAO(PersonalItemParser parser, Context context) {
        this.context = context;
        this.parser = parser;
        this.storage = new Storage(context);
    }
	
	public List<PersonalItemDTO> fetch() throws JSONException{
		JSONArray jsonDataArray = new JSONArray();
		
		String savedItems = storage.getString(PERSISTENCE_KEY_PERSONAL_ITEM);
		Log.i("personalitem debug", savedItems);
		jsonDataArray = new JSONArray(savedItems);
		
		List<PersonalItemDTO> list = new ArrayList<PersonalItemDTO>();
		list = parser.parse(jsonDataArray);
		return list;
		
	}
	
	public int save(List<PersonalItemDTO> list) throws JSONException{
		
		String old_values_str = storage.getString(PERSISTENCE_KEY_PERSONAL_ITEM);
		JSONArray old_values = new JSONArray();
		if(old_values_str.isEmpty()){
			old_values = fromJSONText(EMPTY_JSONARRAY_STR);
		} else {
			old_values = fromJSONText(old_values_str);
		}
		
		for (PersonalItemDTO p : list){
			JSONObject personalItemDTO_JSON = new JSONObject();
			personalItemDTO_JSON
			.put(KEY, p.getKey())
			.put(NAME, p.getName())
			.put(LONGITUDE, p.getLongitude())
			.put(LATITUDE, p.getLatitude());
			
			old_values.put(personalItemDTO_JSON);
		}
		
		
		storage.setString(PERSISTENCE_KEY_PERSONAL_ITEM, old_values.toString());
		return 0;
	}
	
	public void clear() {
		storage.remove(PERSISTENCE_KEY_PERSONAL_ITEM);
	}
	
	
	private JSONArray fromJSONText(String jsonArrayText) throws JSONException{
		JSONArray jsonArray = new JSONArray(jsonArrayText);
		
		return jsonArray;
	}

	public Context getContext() {
		return context;
	}

}
