package com.enseirb.swissknife33.business.model;

public class PersonalItem {
	private int key;
    private String name;
    private float x_long;
    private float y_lat;
    
	public int getKey() {
		return key;
	}
	public PersonalItem setKey(int key) {
		this.key = key;
		return this;
	}
	public String getName() {
		return name;
	}
	public PersonalItem setName(String name) {
		this.name = name;
		return this;
	}
	public float getX_long() {
		return x_long;
	}
	public PersonalItem setX_long(float x_long) {
		this.x_long = x_long;
		return this;
	}
	public float getY_lat() {
		return y_lat;
	}
	public PersonalItem setY_lat(float y_lat) {
		this.y_lat = y_lat;
		return this;
	}
    
	
}
