package com.enseirb.swissknife33.dao.model;

public class NestDTO extends AbstractDTO {
	//TODO Switch to english
	//TODO Getters + Fluent Setters
	private String cle;
	private String nature_abris;
	private String detail_espece_visee;
	private String nom;
	private String x_long;
	private String y_lat;
	public void setCle(String cle) {
		this.cle = cle;
	}
	public void setNature_abris(String nature_abris) {
		this.nature_abris = nature_abris;
	}
	public void setDetail_espece_visee(String detail_espece_visee) {
		this.detail_espece_visee = detail_espece_visee;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setX_long(String x_long) {
		this.x_long = x_long;
	}
	public void setY_lat(String y_lat) {
		this.y_lat = y_lat;
	}
	
}
