package com.enseirb.swissknife33.dao;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.enseirb.swissknife33.R;
import com.enseirb.swissknife33.dao.model.PersonalItemDTO;
import com.enseirb.swissknife33.parser.PersonalItemParser;
import com.google.android.gms.internal.js;

public class PersonalItemDAO {
	
	private final Context context;
    private final SharedPreferences sharedPrefs;
	
	private static String SAVED_ITEMS_JSON = "savedItemsJSON";
	private static String EMPTY_STRING = "";
	private static String SHARED_PREFS_PERSONAL = "shared_prefs_personal_item";
	
	public PersonalItemDAO(Context context) {
        this.context = context;
        sharedPrefs = context.getSharedPreferences(SHARED_PREFS_PERSONAL, Context.MODE_PRIVATE);
    }
	
	public List<PersonalItemDTO> fetch() throws JSONException{
		JSONArray jsonDataArray = new JSONArray();
		
		String savedItems = sharedPrefs.getString(SAVED_ITEMS_JSON, EMPTY_STRING);
		jsonDataArray = new JSONArray(savedItems);
		
		PersonalItemParser parser = new PersonalItemParser();
		List<PersonalItemDTO> list = parser.parse(jsonDataArray);
		
		return list;
		
	}
	
	public int save(List<PersonalItemDTO> list){
		String jsonString = "[";
		for (PersonalItemDTO p : list){
			jsonString += p.toJSON() + ",";
		}
		jsonString += "{}]";
		
		SharedPreferences.Editor editor = sharedPrefs.edit();
		editor.putString(SAVED_ITEMS_JSON, jsonString);
		editor.commit();
		return 0;
	}

}
