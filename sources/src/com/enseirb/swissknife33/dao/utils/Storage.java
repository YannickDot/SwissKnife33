package com.enseirb.swissknife33.dao.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Storage {
	private Context context = null;
	private SharedPreferences sharedPrefs = null;
	
	public static String APP_SHARED_PREFS = "com.enseirb.swissknife33";
	public static String PERSISTENCE_KEY_PERSONAL_ITEM = "PERSONAL_ITEM_DATA";
	private String DEFAULT_DATA = "";
	
	public Storage(Context context){
		this.context = context;
		sharedPrefs = context.getSharedPreferences(APP_SHARED_PREFS, Context.MODE_PRIVATE);
//		SharedPreferences.Editor editor = sharedPrefs.edit();
//		editor.clear();
//		editor.commit();
		
	}
	
	public void setString(String key, String value){
		SharedPreferences.Editor editor = sharedPrefs.edit();
		editor.putString(key, value);
		editor.commit();
	}
	
	public String getString(String key){
		String savedItems = sharedPrefs.getString(key, DEFAULT_DATA);
		return savedItems;
	}
	
	public void remove(String key){
		SharedPreferences.Editor editor = sharedPrefs.edit();
		editor.remove(key);
		editor.commit();
	}
}
