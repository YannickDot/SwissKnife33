package com.enseirb.swissknife33.parser;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import com.enseirb.swissknife33.dao.model.AbstractDTO;

public abstract class AbstractParser <T extends AbstractDTO> {

	public List<T> parse(JSONArray array) throws JSONException {
		return null;
	}
}
