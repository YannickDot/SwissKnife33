package com.enseirb.swissknife33.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import JSONUtils.JsonParser;

import com.enseirb.swissknife33.dao.model.AbstractDTO;
import com.enseirb.swissknife33.dao.model.ParkingDTO;
import com.enseirb.swissknife33.parser.AbstractParser;
import com.enseirb.swissknife33.parser.ParkingParser;

public abstract class AbstractDAO <T>{
protected String URL = "";
	

	public AbstractDAO(String url){
		this.URL = url;
	}
	
	public List<T> fetch() throws JSONException{
		JsonParser JSON = new JsonParser();
		JSONObject jsonResult = new JSONObject();
		
		try {
			jsonResult = JSON.readJsonFromUrl(URL);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray array = jsonResult.getJSONArray("d");
		AbstractParser<T> parser = getParser();//new AbstractParser<T>();
		List<T> list = parser.parse(array);
		
		return list;
	
	}

	private AbstractParser<T> getParser() {
		// TODO Auto-generated method stub
		return null;
	}
}
