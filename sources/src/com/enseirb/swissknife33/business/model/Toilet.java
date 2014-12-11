package com.enseirb.swissknife33.business.model;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class Toilet {
	
	private int key;
	private String address;
	private String name;
	private String district;
	private String typology;
	private double longitude;
	private double latitude;
	private float color = BitmapDescriptorFactory.HUE_YELLOW;
	
	public int getKey() {
		return key;
	}
	public Toilet setKey(int key) {
		this.key = key;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public Toilet setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getName() {
		return name;
	}
	public Toilet setName(String name) {
		this.name = name;
		return this;
	}
	public String getDistrict() {
		return district;
	}
	public Toilet setDistrict(String district) {
		this.district = district;
		return this;
	}
	public String getTypology() {
		return typology;
	}
	public Toilet setTypology(String typology) {
		this.typology = typology;
		return this;
	}
	public double getLongitude() {
		return longitude;
	}
	public Toilet setLongitude(double longitude) {
		this.longitude = longitude;
		return this;
	}
	public double getLatitude() {
		return latitude;
	}
	public Toilet setLatitude(double latitude) {
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
