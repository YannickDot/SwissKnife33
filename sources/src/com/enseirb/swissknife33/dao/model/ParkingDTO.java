package com.enseirb.swissknife33.dao.model;



public class ParkingDTO extends AbstractDTO {
	
	private String key;
	private String domaniality;
	private String nature;
    private String name;
    private String numberOfSpace;
    private String longitude;
    private String latitude;
    
	public String getKey() {
		return key;
	}
	public ParkingDTO setKey(String key) {
		this.key = key;
		return this;
	}
	public String getDomaniality() {
		return domaniality;
	}
	public ParkingDTO setDomaniality(String domaniality) {
		this.domaniality = domaniality;
		return this;
	}
	public String getNature() {
		return nature;
	}
	public ParkingDTO setNature(String nature) {
		this.nature = nature;
		return this;
	}
	public String getName() {
		return name;
	}
	public ParkingDTO setName(String name) {
		this.name = name;
		return this;
	}
	public String getNumberOfSpace() {
		return numberOfSpace;
	}
	public ParkingDTO setNumberOfSpace(String numberOfSpace) {
		this.numberOfSpace = numberOfSpace;
		return this;
	}
	public String getLongitude() {
		return longitude;
	}
	public ParkingDTO setLongitude(String longitude) {
		this.longitude = longitude;
		return this;
	}
	public String getLatitude() {
		return latitude;
	}
	public ParkingDTO setLatitude(String latitude) {
		this.latitude = latitude;
		return this;
	}
}
