package com.enseirb.swissknife33.business.model;

public class Toilet {
	
	private int key;
	private String address;
	private String name;
	private String neighborhood;
	private String typology;
	private float longitude;
	private float latitude;
	
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
	public String getNeighborhood() {
		return neighborhood;
	}
	public Toilet setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
		return this;
	}
	public String getTypology() {
		return typology;
	}
	public Toilet setTypology(String typology) {
		this.typology = typology;
		return this;
	}
	public float getLongitude() {
		return longitude;
	}
	public Toilet setLongitude(float longitude) {
		this.longitude = longitude;
		return this;
	}
	public float getLatitude() {
		return latitude;
	}
	public Toilet setLatitude(float latitude) {
		this.latitude = latitude;
		return this;
	}
}
