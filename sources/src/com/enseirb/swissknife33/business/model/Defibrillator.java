package com.enseirb.swissknife33.business.model;

public class Defibrillator {
	
	private int key;
	private String address;
	private String town;
	private String zip_code;
	private String name;
	private String phone;
	private String typology;
	private String installed;
	private String information;
	private float longitude;
	private float latitude;
	
	public int getKey() {
		return key;
	}
	public Defibrillator setKey(int key) {
		this.key = key;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public Defibrillator setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getTown() {
		return town;
	}
	public Defibrillator setTown(String town) {
		this.town = town;
		return this;
	}
	public String getZip_code() {
		return zip_code;
	}
	public Defibrillator setZip_code(String zip_code) {
		this.zip_code = zip_code;
		return this;
	}
	public String getName() {
		return name;
	}
	public Defibrillator setName(String name) {
		this.name = name;
		return this;
	}
	public String getPhone() {
		return phone;
	}
	public Defibrillator setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	public String getTypology() {
		return typology;
	}
	public Defibrillator setTypology(String typology) {
		this.typology = typology;
		return this;
	}
	public String getInstalled() {
		return installed;
	}
	public Defibrillator setInstalled(String installed) {
		this.installed = installed;
		return this;
	}
	public String getInformation() {
		return information;
	}
	public Defibrillator setInformation(String information) {
		this.information = information;
		return this;
	}
	public float getLongitude() {
		return longitude;
	}
	public Defibrillator setLongitude(float longitude) {
		this.longitude = longitude;
		return this;
	}
	public float getLatitude() {
		return latitude;
	}
	public Defibrillator setLatitude(float latitude) {
		this.latitude = latitude;
		return this;
	}
	
}
