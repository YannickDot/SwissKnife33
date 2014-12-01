package com.enseirb.swissknife33.business.model;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class PersonalItem {
	private int key;
    private String name;
    private double longitude;
    private double latitude;
    private float color = BitmapDescriptorFactory.HUE_VIOLET;
    
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
	public double getLongitude() {
		return longitude;
	}
	public PersonalItem setLongitude(double longitude) {
		this.longitude = longitude;
		return this;
	}
	public double getLatitude() {
		return latitude;
	}
	public PersonalItem setLatitude(double latitude) {
		this.latitude = latitude;
		return this;
	}
	public float getColor() {
		return color;
	}
	public void setColor(float color) {
		this.color = color;
	}
    
	
}
