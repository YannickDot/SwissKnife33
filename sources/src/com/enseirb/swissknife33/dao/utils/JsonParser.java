package com.enseirb.swissknife33.dao.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JsonParser {
	
	private static final String JSON = "JSON";
	private static final String UTF_8 = "UTF-8";

	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }

	public JSONObject readJsonFromUrl(String url) throws MalformedURLException, IOException, JSONException{
		InputStream is = new URL(url).openStream();
		try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName(UTF_8)));
	      String jsonText = readAll(rd);
	      
	      Log.i(JSON, jsonText);
	      
	      JSONObject json = new JSONObject(jsonText);
	      return json;
	    } finally {
	      is.close();
	    }
	}
		
}
