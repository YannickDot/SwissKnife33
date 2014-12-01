package com.enseirb.swissknife33.dao;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.enseirb.swissknife33.R;
import com.enseirb.swissknife33.dao.model.PersonalItemDTO;
import com.enseirb.swissknife33.dao.utils.Storage;
import com.enseirb.swissknife33.parser.PersonalItemParser;

public class PersonalItemDAO {
	
	private static final String LATITUDE = "Latitude";
	private static final String LONGITUDE = "Longitude";
	private static final String NAME = "Name";
	private static final String KEY = "key";
	
	private final Context context;
    private final PersonalItemParser parser;
	
	private String PERSISTENCE_KEY_PERSONAL_ITEM = "PERSONAL_ITEM_DATA";
	private Storage storage;
	
	public PersonalItemDAO(PersonalItemParser parser, Context context) {
        this.context = context;
        this.parser = parser;
        this.storage = new Storage(context);
    }
	
	public List<PersonalItemDTO> fetch() throws JSONException{
		JSONArray jsonDataArray = new JSONArray();
		
		String savedItems = storage.getString(PERSISTENCE_KEY_PERSONAL_ITEM);
		jsonDataArray = new JSONArray(savedItems);
		
		List<PersonalItemDTO> list = parser.parse(jsonDataArray);
		
		return list;
		
	}
	
	public int save(List<PersonalItemDTO> list) throws JSONException{
		String jsonString = toJSONText(list);
		
		storage.setString(PERSISTENCE_KEY_PERSONAL_ITEM, jsonString);
		return 0;
	}
	
	private String toJSONText(List<PersonalItemDTO> list) throws JSONException{
		JSONArray personalItemDTO_JSONArray = new JSONArray();
		
		for (PersonalItemDTO p : list){
			JSONObject personalItemDTO_JSON = new JSONObject();
			personalItemDTO_JSON
			.put(KEY, p.getKey())
			.put(NAME, p.getName())
			.put(LONGITUDE, p.getLongitude())
			.put(LATITUDE, p.getLatitude());
			
			personalItemDTO_JSONArray.put(personalItemDTO_JSON);
		}
			
		return personalItemDTO_JSONArray.toString();
	}

}
