package com.enseirb.swissknife33.dao.model;


public class PersonalItemDTO extends AbstractDTO {
	//TODO Switch to english
	//TODO Getters + Fluent Setters
	private String key;
    private String name;
    private String x_long;
    private String y_lat;
    
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
	public String getX_long() {
		return x_long;
	}
	public void setX_long(String x_long) {
		this.x_long = x_long;
	}
	public String getY_lat() {
		return y_lat;
	}
	public void setY_lat(String y_lat) {
		this.y_lat = y_lat;
	}
	
	public String toJSON() {
		String json = "";
		json = "{"
				+"\"key\":"+"\""+key+"\","
				+"\"name\":"+"\""+name+"\","
				+"\"x_long\":"+"\""+x_long+"\","
				+"\"y_lat\":"+"\""+y_lat+"\""
				+"}"; 
		
		return json;
	}
    
    

}
