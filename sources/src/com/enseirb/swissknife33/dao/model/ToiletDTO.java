package com.enseirb.swissknife33.dao.model;

public class ToiletDTO extends AbstractDTO {
	
	private String key;
	private String address;
	private String name;
	private String neighborhood;
	private String typology;
	private String longitude;
	private String latitude;
	
	public String getKey() {
		return key;
	}
	public ToiletDTO setKey(String key) {
		this.key = key;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public ToiletDTO setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getName() {
		return name;
	}
	public ToiletDTO setName(String name) {
		this.name = name;
		return this;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public ToiletDTO setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
		return this;
	}
	public String getTypology() {
		return typology;
	}
	public ToiletDTO setTypology(String typology) {
		this.typology = typology;
		return this;
	}
	public String getLongitude() {
		return longitude;
	}
	public ToiletDTO setLongitude(String longitude) {
		this.longitude = longitude;
		return this;
	}
	public String getLatitude() {
		return latitude;
	}
	public ToiletDTO setLatitude(String latitude) {
		this.latitude = latitude;
		return this;
	}
	
}
