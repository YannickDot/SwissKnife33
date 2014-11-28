package com.enseirb.swissknife33.dao.model;


public class PersonalItemDTO extends AbstractDTO {
	//TODO Switch to english
	//TODO Getters + Fluent Setters
	private String key;
    private String name;
    private String longitude;
    private String latitude;
    
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
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
