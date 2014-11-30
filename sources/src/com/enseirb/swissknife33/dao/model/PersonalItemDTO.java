package com.enseirb.swissknife33.dao.model;


public class PersonalItemDTO extends AbstractDTO {
	
	private String key;
    private String name;
    private String longitude;
    private String latitude;
    
	public String getKey() {
		return key;
	}
	public PersonalItemDTO setKey(String key) {
		this.key = key;
		return this;
	}
	public String getName() {
		return name;
	}
	public PersonalItemDTO setName(String name) {
		this.name = name;
		return this;
	}
	public String getLongitude() {
		return longitude;
	}
	public PersonalItemDTO setLongitude(String longitude) {
		this.longitude = longitude;
		return this;
	}
	public String getLatitude() {
		return latitude;
	}
	public PersonalItemDTO setLatitude(String latitude) {
		this.latitude = latitude;
		return this;
	}
	
	public String toJSON() {
		String json = "";
		json = "{"
				+"\"key\":"+"\""+key+"\","
				+"\"name\":"+"\""+name+"\","
				+"\"x_long\":"+"\""+longitude+"\","
				+"\"y_lat\":"+"\""+latitude+"\""
				+"}"; 
		
		return json;
	}
    
    

}
