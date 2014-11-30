package com.enseirb.swissknife33.dao.model;

public class ToiletsDTO extends AbstractDTO {
	
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
	public ToiletsDTO setKey(String key) {
		this.key = key;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public ToiletsDTO setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getName() {
		return name;
	}
	public ToiletsDTO setName(String name) {
		this.name = name;
		return this;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public ToiletsDTO setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
		return this;
	}
	public String getTypology() {
		return typology;
	}
	public ToiletsDTO setTypology(String typology) {
		this.typology = typology;
		return this;
	}
	public String getLongitude() {
		return longitude;
	}
	public ToiletsDTO setLongitude(String longitude) {
		this.longitude = longitude;
		return this;
	}
	public String getLatitude() {
		return latitude;
	}
	public ToiletsDTO setLatitude(String latitude) {
		this.latitude = latitude;
		return this;
	}
	
}
