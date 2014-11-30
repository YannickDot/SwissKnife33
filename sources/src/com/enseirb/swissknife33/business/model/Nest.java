package com.enseirb.swissknife33.business.model;

public class Nest {
	
	private int key;
	private String shelter_type;
	private String targeted_species;
	private String name;
	private float longitude;
	private float latitude;
	
	public int getKey() {
		return key;
	}
	public Nest setKey(int key) {
		this.key = key;
		return this;
	}
	public String getShelter_type() {
		return shelter_type;
	}
	public Nest setShelter_type(String shelter_type) {
		this.shelter_type = shelter_type;
		return this;
	}
	public String getTargeted_species() {
		return targeted_species;
	}
	public Nest setTargeted_species(String targeted_species) {
		this.targeted_species = targeted_species;
		return this;
	}
	public String getName() {
		return name;
	}
	public Nest setName(String name) {
		this.name = name;
		return this;
	}
	public float getLongitude() {
		return longitude;
	}
	public Nest setLongitude(float longitude) {
		this.longitude = longitude;
		return this;
	}
	public float getLatitude() {
		return latitude;
	}
	public Nest setLatitude(float latitude) {
		this.latitude = latitude;
		return this;
	}
}
