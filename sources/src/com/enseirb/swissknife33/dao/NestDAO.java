package com.enseirb.swissknife33.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.enseirb.swissknife33.dao.model.NestDTO;
import com.enseirb.swissknife33.dao.utils.JsonParser;
import com.enseirb.swissknife33.exception.Swissknife33Exception;
import com.enseirb.swissknife33.parser.NestParser;

public class NestDAO extends AbstractDAO<NestDTO> {
	
	private String PERSISTENCE_KEY_NESTS = "NEST_DATA";
	
	public NestDAO(String url, NestParser parser, Context context) {
		this.URL = url;
		this.parser = parser;
		this.storage = new Storage(context);
	}
	
	public List<NestDTO> fetch() throws JSONException, Swissknife33Exception {
		
		//TODO : Here I tried to make the application offline first and check 
		// if data is cached before fetching it from the web.
		
		List<NestDTO> list = fetchFromURL();
		return list;

	}
	
	public List<NestDTO> fetchFromCache() throws JSONException, Swissknife33Exception {
		JSONArray jsonDataArray = new JSONArray();
		System.out.println("Fetching nestsDTO from cache.");
		
		String savedItems = storage.getString(PERSISTENCE_KEY_NESTS);
		System.out.println(savedItems);
		jsonDataArray = new JSONArray(savedItems);
		
		List<NestDTO> list = parser.parse(jsonDataArray);
		return list;
	}

	public List<NestDTO> fetchFromURL() throws JSONException, Swissknife33Exception {
		JsonParser JSON = new JsonParser();
		JSONObject jsonResult = new JSONObject();
		System.out.println("Fetching nestsDTO from URL.");
		
		try {
			jsonResult = JSON.readJsonFromUrl(URL);
		} catch (MalformedURLException e) {
			throw new Swissknife33Exception();
		} catch (IOException e) {
			throw new Swissknife33Exception();
		} catch (JSONException e) {
			throw e;
		}
		
		JSONArray nestsArray = jsonResult.getJSONArray("d");
		
		//update Cache
		storage.setString(PERSISTENCE_KEY_NESTS, nestsArray.toString());
		
		List<NestDTO> list = parser.parse(nestsArray);
		
		return list;
	}
}
