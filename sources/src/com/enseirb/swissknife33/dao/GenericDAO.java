package com.enseirb.swissknife33.dao;

import java.util.List;

import org.json.JSONException;

public interface GenericDAO {
	public abstract List<?> fetch() throws JSONException;
}
