package com.enseirb.swissknife33.business.model;

public class Parking {
	
	private int key;
	private String domaniality;
	private String nature;
    private String name;
    private int numberOfSpace;
    private float longitude;
    private float latitude;
    
	public int getKey() {
		return key;
	}
	public Parking setKey(int key) {
		this.key = key;
		return this;
	}
	public String getDomaniality() {
		return domaniality;
	}
	public Parking setDomaniality(String domaniality) {
		this.domaniality = domaniality;
		return this;
	}
	public String getNature() {
		return nature;
	}
	public Parking setNature(String nature) {
		this.nature = nature;
		return this;
	}
	public String getName() {
		return name;
	}
	public Parking setName(String name) {
		this.name = name;
		return this;
	}
	public int getNumberOfSpace() {
		return numberOfSpace;
	}
	public Parking setNumberOfSpace(int numberOfSpace) {
		this.numberOfSpace = numberOfSpace;
		return this;
	}
	public float getLongitude() {
		return longitude;
	}
	public Parking setLongitude(float longitude) {
		this.longitude = longitude;
		return this;
	}
	public float getLatitude() {
		return latitude;
	}
	public Parking setLatitude(float latitude) {
		this.latitude = latitude;
		return this;
	}
	
	@Override
	public String toString() {
		return String
				.format("Parking [key=%s, domaniality=%s, nature=%s, name=%s, numberOfSpace=%s, longitude=%s, latitude=%s]",
						key,
						domaniality,
						nature,
						name,
						numberOfSpace,
						longitude,
						latitude);
	}  
}
