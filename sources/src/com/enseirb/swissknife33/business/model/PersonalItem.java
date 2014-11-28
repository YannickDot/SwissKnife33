package com.enseirb.swissknife33.business.model;

public class PersonalItem {
	private int key;
    private String name;
    private float longitude;
    private float latitude;
    
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
	public float getLongitude() {
		return longitude;
	}
	public PersonalItem setLongitude(float longitude) {
		this.longitude = longitude;
		return this;
	}
	public float getLatitude() {
		return latitude;
	}
	public PersonalItem setLatitude(float latitude) {
		this.latitude = latitude;
		return this;
	}
    
	
}
