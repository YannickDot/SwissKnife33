package com.enseirb.swissknife33.dao.model;

public class NestDTO extends AbstractDTO {

	private String key;
	private String shelter_type;
	private String targeted_species;
	private String name;
	private String longitude;
	private String latitude;
	
	public String getKey() {
		return key;
	}
	public NestDTO setKey(String key) {
		this.key = key;
		return this;
	}
	public String getShelter_type() {
		return shelter_type;
	}
	public NestDTO setShelter_type(String shelter_type) {
		this.shelter_type = shelter_type;
		return this;
	}
	public String getTargeted_species() {
		return targeted_species;
	}
	public NestDTO setTargeted_species(String targeted_species) {
		this.targeted_species = targeted_species;
		return this;
	}
	public String getName() {
		return name;
	}
	public NestDTO setName(String name) {
		this.name = name;
		return this;
	}
	public String getLongitude() {
		return longitude;
	}
	public NestDTO setLongitude(String longitude) {
		this.longitude = longitude;
		return this;
	}
	public String getLatitude() {
		return latitude;
	}
	public NestDTO setLatitude(String latitude) {
		this.latitude = latitude;
		return this;
	}
}
