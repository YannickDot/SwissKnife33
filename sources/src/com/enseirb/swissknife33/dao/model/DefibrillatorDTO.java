package com.enseirb.swissknife33.dao.model;

public class DefibrillatorDTO extends AbstractDTO {
	
	private String key;
	private String address;
	private String town;
	private String zip_code;
	private String name;
	private String phone;
	private String typology;
	private String installed;
	private String information;
	private String longitude;
	private String latitude;
	
	public String getKey() {
		return key;
	}
	public DefibrillatorDTO setKey(String key) {
		this.key = key;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public DefibrillatorDTO setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getTown() {
		return town;
	}
	public DefibrillatorDTO setTown(String town) {
		this.town = town;
		return this;
	}
	public String getZip_code() {
		return zip_code;
	}
	public DefibrillatorDTO setZip_code(String zip_code) {
		this.zip_code = zip_code;
		return this;
	}
	public String getName() {
		return name;
	}
	public DefibrillatorDTO setName(String name) {
		this.name = name;
		return this;
	}
	public String getPhone() {
		return phone;
	}
	public DefibrillatorDTO setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	public String getTypology() {
		return typology;
	}
	public DefibrillatorDTO setTypology(String typology) {
		this.typology = typology;
		return this;
	}
	public String getInstalled() {
		return installed;
	}
	public DefibrillatorDTO setInstalled(String installed) {
		this.installed = installed;
		return this;
	}
	public String getInformation() {
		return information;
	}
	public DefibrillatorDTO setInformation(String information) {
		this.information = information;
		return this;
	}
	public String getLongitude() {
		return longitude;
	}
	public DefibrillatorDTO setLongitude(String longitude) {
		this.longitude = longitude;
		return this;
	}
	public String getLatitude() {
		return latitude;
	}
	public DefibrillatorDTO setLatitude(String latitude) {
		this.latitude = latitude;
		return this;
	}
	
	
}
